package io.thrill.bookmark;

import io.thrill.bookmark.entity.Bookmark;
import io.thrill.bookmark.entity.User;
import io.thrill.bookmark.service.BookmarkService;
import io.thrill.bookmark.service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
	private static User users[];
	private static Bookmark bookmarks[][];
	
	private static void loadData() {
		DataStore.loadData();
		users = UserService.getInstance().getUsers();
		bookmarks = BookmarkService.getInstance().getBookmark();
	}
	
	private static void printUsers() {
		
		for(User user: users) {
			System.out.println(user);
		}
	}
	
	private static void printBookmarks() {
		
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				System.out.println(bookmark); 
			}
		}
		
	}
	
	private static void startBookmark() {
		System.out.println("Start bookmarking");
		for(User user: users) {
			//View.bookmark(user, bookmarks);
			View.browse(user, bookmarks);
		}
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        loadData();
        //printBookmarks();
        //printUsers();  
        startBookmark();
   }
}
