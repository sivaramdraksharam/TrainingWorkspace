package io.thrill.bookmark.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import io.thrill.bookmark.constants.BookGenre;
import io.thrill.bookmark.partner.Sharable;

@Entity
@Table(name = "books")
@PrimaryKeyJoinColumn(name="id") 
public class Book extends Bookmark  implements Sharable{
	
	@Column(name="publicationyear")
	private Integer publicationYear;
	
	@Column(name="publisher")
	private String publisher;
	
	@Column(name="author")
	private String author;
	
	@Enumerated(EnumType.STRING)
	@Column(name="genre")
	private BookGenre genre;
	
	@Column(name="amazonrating")
	private Double amazonRating;

	public Integer getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		System.out.println("Calling author Getter");
		return author;
	}

	public void setAuthor(String author) {
		System.out.println("Calling author Setter");
		this.author = author;
	}
	
	//@Enumerated(EnumType.STRING)
	public BookGenre getGenre() {
		return genre;
	}

	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}

	public Double getAmazonRating() {
		return amazonRating;
	}

	public void setAmazonRating(Double amazonRating) {
		this.amazonRating = amazonRating;
	}

	@Override
	public String toString() {
		return "Books [id=" + getId() + ", title=" + getTitle() + ", publicationYear=" + publicationYear + ", publisher="
				+ publisher + ", author=" + author + ", genre=" + genre + ", amazonRating=" + amazonRating
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	@Override
	public boolean isKidFriendlyEligible() {
		if(genre.equals(BookGenre.PHILOSOPHY) || genre.equals(BookGenre.SELF_HELP)) {
			return false;
		}
		return true;
	}
	
	
	@Override	
	public String getData() {		
		StringBuilder builder = new StringBuilder();
		builder.append("<response>");
		builder.append("<type>Book</type>");
		builder.append("<title>").append(getTitle()).append("/title");
		builder.append("<author>").append(author).append("/author");
		builder.append("<publicationYear>").append(publicationYear).append("/publicationYear");		
		builder.append("<publisher>").append(publisher).append("/publisher");
		builder.append("<genre>").append(genre).append("/genre");
		builder.append("</response>");
		return builder.toString();
	}
}
