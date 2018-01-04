package io.thrill.bookmark.entity;

import io.thrill.bookmark.constants.MovieGenre;
import io.thrill.bookmark.service.BookmarkService;
import junit.framework.TestCase;

public class MovieTest extends TestCase {

	public void testIsKidFriendlyEligible() {
		// Test 1. Thriller Genre must return false
		BookmarkService bookMarkService = BookmarkService.getInstance();
		Movie movie = bookMarkService.createMovie(3000,"Citizen Kane","",1941, new String[] {"Orson Welles,Joseph Cotten"},new String[] {"Orson Welles"},MovieGenre.THRILLERS,8.5);
		boolean isKidFriendly = movie.isKidFriendlyEligible();
		assertFalse("Thriller movie must retun false", isKidFriendly);
		// Test 2. Thriller Genre must return false
		movie = bookMarkService.createMovie(3000,"Citizen Kane","",1941, new String[] {"Orson Welles,Joseph Cotten"},new String[] {"Orson Welles"},MovieGenre.HORROR,8.5);
		isKidFriendly = movie.isKidFriendlyEligible();
		assertFalse("Horror movie must retun false", isKidFriendly);
		
	}

}
