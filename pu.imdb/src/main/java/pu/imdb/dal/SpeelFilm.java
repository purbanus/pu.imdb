package pu.imdb.dal;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "UN_Film_Title_Year", columnNames = { "title", "year" }) })
public class SpeelFilm
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

@Column //( nullable = false ) // @@Misschien later
private String imdbId;

@Column( nullable = false )
private String path;

@Column
private String series;

@Column( nullable = false )
private String title;

@Column //( nullable = false ) // @@Misschien later
private String director;

@Column( nullable = false )
private int year;

@Column //( nullable = false ) // @@Misschien later
private String actors;

@Column
private String music;

@Column( length = 4096 )
private String review;

@Column( nullable = false )
private LocalDateTime dateTimeLastModified;

//ManyToMany Film -> Director
//ManyToMany Film -> Acteur
}
