package io.thrill.bookmark.entity;

import io.thrill.bookmark.constants.BookGenre;
import io.thrill.bookmark.service.BookmarkService;
import junit.framework.TestCase;

public class BookTest extends TestCase {

	public void testIsKidFriendlyEligible() {
		BookmarkService bookMarkService = BookmarkService.getInstance();
		
		// Test 1. Philosophy book must return false		
		Book book = bookMarkService.createBook(4000,"Walden",1854,"Wilder Publications",new String[] {"Henry David Thoreau"},BookGenre.PHILOSOPHY,4.3);
		boolean iskidfriendly = book.isKidFriendlyEligible();
		assertFalse("Philosophy book must return false",iskidfriendly);
		
		// Test 2. Self interest book must return false
		book = bookMarkService.createBook(4000,"Walden",1854,"Wilder Publications",new String[] {"Henry David Thoreau"},BookGenre.SELF_HELP,4.3);
		iskidfriendly = book.isKidFriendlyEligible();
		assertFalse("Self interest book must return false",iskidfriendly); 
	}

}
