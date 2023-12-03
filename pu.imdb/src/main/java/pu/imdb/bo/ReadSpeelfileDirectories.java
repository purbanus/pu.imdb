package pu.imdb.bo;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import nl.mediacenter.services.FileWalker;

public class ReadSpeelfileDirectories implements Observer
{
private FileWalker fileWalker = new FileWalker( new File( "/home/purbanus/Videos/speelfilms" ) );
public void run()
{
	fileWalker.addObserver( this );
	fileWalker.setReportDirs( fileWalker.REPORTDIRS_AFTER );
	fileWalker.run();
}
@Override
public void update( Observable aO, Object aArg )
{
	File file = (File) aArg;
	if ( ! file.isDirectory() )
	{
		return;
	}
	String fileName = file.getName();
}

}
