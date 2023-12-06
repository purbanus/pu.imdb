--delete from speel_film;

insert into speel_film ( id, date_time_last_modified, title, year, director, path ) values( 1, '2023-05-14 12:02:23', 'pipo titel', 2015, 'De Dikke Deur', '/home/purbanus/filmpje' );

alter sequence speel_film_seq restart with 2000;

