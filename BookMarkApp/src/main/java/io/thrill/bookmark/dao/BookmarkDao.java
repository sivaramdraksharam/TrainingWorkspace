package io.thrill.bookmark.dao;

import io.thrill.bookmark.DataStore;
import io.thrill.bookmark.entity.Bookmark;
import io.thrill.bookmark.entity.UserBookmark;

public class BookmarkDao {

	public Bookmark[][] getBookmarks(){
		return DataStore.getBookMarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
}
