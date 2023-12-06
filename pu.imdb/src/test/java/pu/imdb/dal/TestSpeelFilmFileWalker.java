package pu.imdb.dal;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pu.imdb.util.MatrixFormatter;
import pu.imdb.util.StringHelper;

import lombok.Data;

@SpringBootTest
@Data
public class TestSpeelFilmFileWalker
{
//public static String SPEELFILM_LISTING = "/speelfilms listing 2023-10-19 - 10 regels.txt";
public static String SPEELFILM_LISTING = "/speelfilms listing 2023-10-19.txt";
public static String SPEELFILMS_AT_NAS4 = "/home/purbanus/Videos/speelfilms";
public static String SPEELFILMS_AT_5TB = "/media/purbanus/5TB Seagate/Videos/nas4";

@Autowired private SpeelFilmsWriter speelFilmsWriter;

@Test
public void testNormaleSpeelFilmParser() throws FileNotFoundException, IOException, URISyntaxException
{
	URL url = getClass().getResource( "../" + SPEELFILM_LISTING );
	List<String> regels = IOUtils.readLines( new FileInputStream( new File( url.toURI() ) ), Charset.forName( "UTF-8" ) );

	List<SpeelFilm> speelFilms = new ArrayList<>();
	//Instant instant = Instant.now();
	SpeelfilmFileWalker walker = new SpeelfilmFileWalker();
	for ( String regel : regels )
	{
		String subRegel = regel.substring( 45 );
		SpeelFilm speelFilm = walker.parseNormaleSpeelFilm( Path.of( "/home/purbanus/pipo" ), subRegel, null, true );
		if ( speelFilm != null )
		{
			speelFilms.add(  speelFilm );
		}
	}
	listSpeelFilms( speelFilms );
}
@Test
public void testSpeelFilmsAtNas4() throws IOException
{
	SpeelfilmFileWalker walker = new SpeelfilmFileWalker( SPEELFILMS_AT_5TB, 2 );
	walker.run();
	List<SpeelFilm> speelFilms = walker.getSpeelFilms();
	listSpeelFilms( speelFilms );
}
@Test
public void testSplitJaarAndMetIntoParts() throws FileNotFoundException, IOException, URISyntaxException
{
	String [] parts = { "Blue Velvet", "David Lynch", "1986 Met", "Isabella etc", };
	String [] expected = { "Blue Velvet", "David Lynch", "1986", "Met", "Isabella etc", };
	SpeelfilmFileWalker walker = new SpeelfilmFileWalker();
	assertArrayEquals( expected, walker.splitJaarAndMetIntoParts( parts, 2 ) );
}
private void listSpeelFilms( List<SpeelFilm> aSpeelFilms )
{
	aSpeelFilms.sort( Comparator.comparing( SpeelFilm::getTitle ) );
	
	MatrixFormatter mf = new MatrixFormatter();
	mf.addHeader( StringHelper.streep( 120 ) );
	mf.addDetail( new String [] { "Titel", "Regisseur", "Jaar", "Acteurs", "Muziek", } );
	mf.addHeader( StringHelper.streep( 120 ) );
	for ( SpeelFilm speelFilm : aSpeelFilms )
	{
		mf.addDetail( new String[] {speelFilm.getTitle(), speelFilm.getDirector(), String.valueOf( speelFilm.getYear() ), speelFilm.getActors(), speelFilm.getMusic(), } );
	}
	System.out.println( mf.getOutput() );
}
}
