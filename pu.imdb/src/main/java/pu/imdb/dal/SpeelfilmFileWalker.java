package pu.imdb.dal;

import static java.nio.file.FileVisitResult.*;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Dit is @Data zonder @HashCodeAndEquals
@Getter
@Setter
@ToString
public class SpeelfilmFileWalker extends SimpleFileVisitor<Path>
{
private static String [] FOUTE_DIRECTORIES = { "@eaDir" };
private static String [] FOUTE_FILES ={ ".directory", "Thumbs.db" };

public static String expandHome( String aPath )
{
	if ( aPath.startsWith( "~" + java.io.File.separator ) )
	{
		aPath = System.getProperty( "user.home" ) + aPath.substring( 1 );
	}
	else if ( aPath.startsWith( "~" ) )
	{
		// here you can implement reading homedir of other users if you care
		throw new UnsupportedOperationException( "Home dir expansion not implemented for explicit usernames" );
	}
	return aPath;
}

private final Path startingDirectory;
private final List<SpeelFilm> speelFilms = new ArrayList<>();
private final int maxDepth;

// private int level; // Ik zie geen manier om het level bij te houden

SpeelfilmFileWalker()
{
	super();
	startingDirectory = null;
	maxDepth = Integer.MAX_VALUE;
}
public SpeelfilmFileWalker( String aStartingDirectory )
{
	this( aStartingDirectory, Integer.MAX_VALUE );
}
public SpeelfilmFileWalker( String aStartingDirectory, int aMaxDepth )
{
	super();
	startingDirectory = Paths.get( expandHome( aStartingDirectory ) );
	maxDepth = aMaxDepth;
}
public List<String> getFouteDirectories()
{
	return Arrays.asList( FOUTE_DIRECTORIES );
}
public List<String> getFouteFiles()
{
	return Arrays.asList( FOUTE_FILES );
}
public void run() throws IOException
{
	Files.walkFileTree( getStartingDirectory(), Collections.EMPTY_SET, maxDepth, this );
}
@Override
public FileVisitResult preVisitDirectory( Path aPath, BasicFileAttributes aAttributes )
{
	if ( !isDirectoryOk( aPath ) )
	{
		return FileVisitResult.SKIP_SUBTREE;
	}
	SpeelFilm speelFilm = parseSpeelFilm( aPath, aAttributes );
	if ( speelFilm != null )
	{
		speelFilms.add( speelFilm );
		return SKIP_SUBTREE;
	}
	return CONTINUE;
}

/**
 * Dit werkt niet, op deze manier level bijhouden. Als je SKIP_SUBTREE doet dan wordt postVisitDirectory niet aangeroepen!
 * Erg raar maar waar. Je kunt ook niet in visitFile checken of het een directory is en dan level-- doen.
 */
//@Override
//public FileVisitResult postVisitDirectory( Path aPath, IOException aException ) throws IOException
//{
//	level--;
//	// Bij Exceptions gaat je level telling de mist in denk ik
////	super.postVisitDirectory( aPath, aException );
//	return CONTINUE;
//}

@Override
public FileVisitResult visitFile( Path aPath, BasicFileAttributes aAttributes )
{
	if ( isFileOk( aPath, aAttributes ) )
	{
		SpeelFilm speelFilm = parseSpeelFilm( aPath, aAttributes );
		if ( speelFilm != null )
		{
			speelFilms.add( speelFilm );
		}
	}
	return CONTINUE;
}

// If there is some error accessing the file, let the user know.
// If you don't override this method and an error occurs, an IOException is thrown.
@Override
public FileVisitResult visitFileFailed( Path aFile, IOException aException )
{
	System.err.println( "Fout in file " + aFile.toString() + " " + aException );
	return CONTINUE;
}

SpeelFilm parseSpeelFilm( Path aPath, BasicFileAttributes aAttributes )
{
	String fileName = aPath.getFileName().toString();
	String parent = aPath.getParent().getFileName().toString();
	if ( parent.equals( "Holland Cinema" ) )
	{
		return parseHollandCinema( aPath, fileName, aAttributes );
	}
	return parseNormaleSpeelFilm( aPath, fileName, aAttributes, true );
}
SpeelFilm parseNormaleSpeelFilm( Path aPath, String aFileName, BasicFileAttributes aAttributes, boolean aReportErrors )
{
	String [] parts = extractParts( aFileName );
	// At least 4 parts
	if ( parts.length < 4 )
	{
		if ( aReportErrors )
		{
			System.out.println( "Minstens 4 delen in: " + aFileName );
		}
		return null;
	}
	Integer yearPosition = findYearPosition( parts );
	if ( yearPosition == null )
	{
		if ( aReportErrors )
		{
			System.out.println( "Geen jaar gevonden in: " + aFileName );
		}
		return null;
	}
	String director = parts[yearPosition - 1];
	StringBuilder title = new StringBuilder();
	for ( int x = 0; x < yearPosition - 1; x++ )
	{
		if ( x > 0 )
		{
			title.append( " - " );
		}
		title.append( parts[x] );
	}
	Integer year = getYear( parts[yearPosition] );
	String actors = null;
	String music = null;
	String review = null;
	for ( int x = yearPosition + 1; x < parts.length; x++ )
	{
		if ( parts[x-1].equalsIgnoreCase( "Met" ) )
		{
			actors = parts[x];
		}
		else if ( parts[x-1].equalsIgnoreCase( "Muziek" ) )
		{
			music = parts[x];
		}
		else if ( x == parts.length - 1 )
		{
			review = parts[x];
		}
	}
	
	SpeelFilm speelFilm = SpeelFilm.builder()
		.path( aPath.toString() )
		.title( title.toString() )
		.director( director )
		.year( year )
		.actors( actors )
		.music( music )
		.review( review )
		.dateTimeLastModified( getLastModifiedTime( aAttributes ) )
		.build()
		;
	return speelFilm;
}
public LocalDateTime getLastModifiedTime( BasicFileAttributes aAttributes )
{
	if ( aAttributes == null )
	{
		return null;
	}
	LocalDateTime dateTimeLastModified = LocalDateTime.ofInstant( aAttributes.lastModifiedTime().toInstant(), ZoneId.systemDefault() );
	return dateTimeLastModified;
}

SpeelFilm parseHollandCinema( Path aPath, String aFileName, BasicFileAttributes aAttributes )
{
	// Jaar staat voorop
	if ( ! isYear( aFileName.substring( 0, 4 ) ) )
	{
		return null;
	}
	String yearString = aFileName.substring( 0, 4 );
	String rawTitle = aFileName.substring( 5 );

	// Er zijn een paar normale speelfilms
	SpeelFilm speelFilm = parseNormaleSpeelFilm( aPath, rawTitle, aAttributes, false );
	if ( speelFilm != null )
	{
		return speelFilm;
	}

	String title;
	if ( aAttributes.isDirectory() )
	{
		title = rawTitle;
	}
	else
	{
		if ( ! aFileName.endsWith( ".avi" ) && ! aFileName.endsWith( ".flv" ) && ! aFileName.endsWith( ".mkv" ) && ! aFileName.endsWith( ".mp4" ) )
		{
			return null;
		}
		int endYearPosition = rawTitle.indexOf( "dvdrip.xvid" );
		if ( endYearPosition < 0 )
		{
			System.out.println( "endYearPosition niet gevonden in " + rawTitle );
			return null;
		}
		int startYearPosition = endYearPosition - 6;
		title = rawTitle.substring( 0, startYearPosition );
	}
	title = title.replace( '.', ' ' );
	Integer year = getYear( yearString );
	
	speelFilm = SpeelFilm.builder()
		.path( aPath.toString() )
		.series( "Holland Cinema" )
		.title( title )
		.year( year )
		.dateTimeLastModified( getLastModifiedTime( aAttributes ) )
		.build()
		;
	return speelFilm;
}

public String [] extractParts( String aFileName )
{
	String [] parts = aFileName.split( "-" );
	parts = trim( parts );
	// Verder opsplitsen als "jjjj Met" voorkomt
	for ( int x = 0; x < parts.length; x++ )
	{
		String partsX = parts[x].toLowerCase();
		if ( partsX.endsWith( "met" ) )
		{
			if ( partsX.length() == 8 && isYear( partsX.substring( 0, 4 ) ) )
			{
				return splitJaarAndMetIntoParts( parts, x );
			}
		}
	}
	return parts;
}

String [] splitJaarAndMetIntoParts( String [] aParts, int aIndex )
{
	String [] newParts = new String[aParts.length + 1];
	for ( int x = 0; x < aIndex; x++ )
	{
		newParts[x] = aParts[x];
	}
	newParts[aIndex] = aParts[aIndex].substring( 0, 4 );
	newParts[aIndex + 1] = "Met";
	for ( int x = aIndex + 1; x < aParts.length; x++ )
	{
		newParts[x + 1] = aParts[x];
	}
	return newParts;
}

Integer findYearPosition( String [] aParts )
{
	for ( int x = 2; x < aParts.length; x++ )
	{
		if ( isYear( aParts[x] ) )
		{
			return x;
		}
	}
	return null;
}
boolean isYear( String aYearString )
{
	if ( aYearString.length() != 4 )
	{
		return false;
	}
	for ( int x = 0; x < 4; x++ )
	{
		char cijfer = aYearString.charAt( x );
		if ( ! Character.isDigit( cijfer ) )
		{
			return false;
		}
	}
	return true;
}

Integer getYear( String aYearString )
{
	try
	{
		return Integer.parseInt( aYearString );
	}
	catch ( NumberFormatException e )
	{
		System.out.println( "Ongeldig jaar: " + aYearString );
	}
	return null;
}

String [] trim( String [] aParts )
{
	if ( aParts == null )
	{
		return null;
	}
	for ( int x = 0; x < aParts.length; x++ )
	{
		if ( aParts[x] != null )
		{
			aParts[x] = aParts[x].trim();
		}
	}
	return aParts;
}

public boolean isFileOk( Path aFile, BasicFileAttributes aAttributes )
{
	if ( !aAttributes.isRegularFile() )
	{
		return false;
	}
	if ( !isFileOrDirectoryOk( aFile ) )
	{
		return false;
	}
	for ( String fouteFile : getFouteFiles() )
	{
		if ( aFile.endsWith( fouteFile ) )
		{
			return false;
		}
	}
	return true;
}
public boolean isDirectoryOk( Path aDirectory )
{
	if ( !isFileOrDirectoryOk( aDirectory ) )
	{
		return false;
	}
	for ( String fouteDirectory : getFouteDirectories() )
	{
		if ( aDirectory.endsWith( fouteDirectory ) )
		{
			return false;
		}
	}
	return true;
}
private boolean isFileOrDirectoryOk( Path aPath )
{
	Path path = aPath.toAbsolutePath();
	if ( path == null )
	{
		return false;
	}
	return true;
}

}
