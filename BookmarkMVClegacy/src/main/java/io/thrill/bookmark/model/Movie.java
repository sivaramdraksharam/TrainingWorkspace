package io.thrill.bookmark.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import io.thrill.bookmark.constants.MovieGenre;

@Entity
@Table(name="movies")
@PrimaryKeyJoinColumn(name="id") 
public class Movie extends Bookmark{
	
	@Column(name="releaseyear")
	private int releaseYear;
	
	@Column(name="cast")
	private String cast;
	
	@Column(name="directors")
	private String directors;
	
	@Column(name="genre")
	@Enumerated(EnumType.STRING)
	private MovieGenre genre;
	
	@Column(name="imdbrating")
	private Double imdbRating;

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getDirectors() {
		return directors;
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public MovieGenre getGenre() {
		return genre;
	}

	public void setGenre(MovieGenre genre) {
		this.genre = genre;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	
	@Override
	public String toString() {
		return "Movie [releaseYear=" + releaseYear + ", cast=" + cast + ", directors=" + directors + ", genre=" + genre
				+ ", imdbRating=" + imdbRating + "]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		if(genre.equals(MovieGenre.THRILLERS) || genre.equals(MovieGenre.HORROR)) {
			return false;
		}
		return true;
	}

}
