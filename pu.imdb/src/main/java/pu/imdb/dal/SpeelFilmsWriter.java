package pu.imdb.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository
@Data
public class SpeelFilmsWriter
{
@Autowired private SpeelFilmRepository speelFilmRepository;

public void deleteAllSpeelFilms()
{
	getSpeelFilmRepository().deleteAll();
}
public void writeSpeelFilms( List<SpeelFilm> aSpeelFilms )
{
	deleteAllSpeelFilms();
	getSpeelFilmRepository().saveAllAndFlush( aSpeelFilms );
}
public void writeSpeelFilm( SpeelFilm aSpeelFilm )
{
	getSpeelFilmRepository().save( aSpeelFilm );
}

}
