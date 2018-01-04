package io.thrill.bookmark.entity;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;

import io.thrill.bookmark.constants.BookGenre;
import io.thrill.bookmark.partner.Sharable;

public class Book extends Bookmark implements Sharable{
	private int publicationYear;
	private String publisher;
	private String[] author;
	private String genre;
	private double amazonRating;

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String[] getAuthor() {
		return author;
	}

	public void setAuthor(String[] author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getAmazonRating() {
		return amazonRating;
	}

	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}

	@Override
	public String toString() {
		return "Book [publicationYear=" + publicationYear + ", publisher=" + publisher + ", author="
				+ Arrays.toString(author) + ", genre=" + genre + ", amazonRating=" + amazonRating + "]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		if(genre.equals(BookGenre.PHILOSOPHY) || genre.equals(BookGenre.SELF_HELP)) {
			return false;
		}
		return true;
	}

	public String getData() {		
		StringBuilder builder = new StringBuilder();
		builder.append("<response>");
		builder.append("<type>Book</type>");
		builder.append("<title>").append(getTitle()).append("/title");
		builder.append("<author>").append(StringUtils.join(author, ",")).append("/author");
		builder.append("<publicationYear>").append(publicationYear).append("/publicationYear");		
		builder.append("<publisher>").append(publisher).append("/publisher");
		builder.append("<genre>").append(genre).append("/genre");
		builder.append("</response>");
		return builder.toString();
	}
	
	
}
