package io.thrill.bookmark.entity;

import io.thrill.bookmark.service.BookmarkService;
import junit.framework.TestCase;

public class WeblinkTest extends TestCase {

	public void testIsKidFriendlyEligible() {
		BookmarkService bookMarkService = BookmarkService.getInstance();
		// Test 1. Erotic in url - false
		WebLink weblink1 = bookMarkService.createwebLink(2000,"Taming Tiger Part 2","http://www.javaworld.com/article/2072759/erotic/taming-tiger--part-2.html","http://www.javaworld.com");
		boolean isKidfriendly = weblink1.isKidFriendlyEligible();
		assertFalse("For erotic in url, isKidFriendly must return false", isKidfriendly);
		
		// Test 2. Erotic present in title -- false
		weblink1 = bookMarkService.createwebLink(2000,"Erotic Tiger Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
		isKidfriendly = weblink1.isKidFriendlyEligible();
		assertFalse("For erotic in title, isKidFriendly must return false", isKidfriendly);
		
		// Test 3. Adult in url ,but not in host part- true
		weblink1 = bookMarkService.createwebLink(2000,"Taming Tiger Part 2","http://www.javaworld.com/article/2072759/adult/taming-tiger--part-2.html","http://www.javaworld.com");
		isKidfriendly = weblink1.isKidFriendlyEligible();
		assertTrue("For adult in url but not in host, isKidFriendly must return true", isKidfriendly);
		
		
		// Test 4. Adult in host -- false
		weblink1 = bookMarkService.createwebLink(2000,"Taming Tiger Part 2","http://www.javaworld.com/article/2072759/java/taming-tiger--part-2.html","http://www.adultworld.com");
		isKidfriendly = weblink1.isKidFriendlyEligible();
		assertFalse("For adult in host, isKidFriendly must return false", isKidfriendly);
		
		// Test 5. adult in title -- true
		weblink1 = bookMarkService.createwebLink(2000,"Taming an Adult Tiger Part 2","http://www.javaworld.com/article/2072759/java/taming-tiger--part-2.html","http://www.javaworld.com");
		isKidfriendly = weblink1.isKidFriendlyEligible();
		assertTrue("For adult in title, isKidFriendly must return true", isKidfriendly);
		
	}

}
