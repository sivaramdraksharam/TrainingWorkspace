package io.thrill.bookmark.controller;

import io.thrill.bookmark.entity.Bookmark;
import io.thrill.bookmark.entity.User;
import io.thrill.bookmark.service.BookmarkService;

public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();
	private BookmarkController() {}
	public static BookmarkController getInstance() {
		return instance;
	}
	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkService.getInstance().saveUserBookmark(user, bookmark);
		
	}
	public void setKidFriendlyStatus(User user, String decision, Bookmark bookmark) {
		BookmarkService.getInstance().setKidFriendlyStatus(user,decision,bookmark);
	}
	public void share(User user, Bookmark bookmark) {
		BookmarkService.getInstance().share(user,bookmark);
		
	}
}
