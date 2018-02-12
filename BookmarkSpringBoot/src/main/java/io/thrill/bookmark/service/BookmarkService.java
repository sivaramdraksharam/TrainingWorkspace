package io.thrill.bookmark.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.thrill.bookmark.dao.BookmarkDao;
import io.thrill.bookmark.model.Bookmark;

@Service
public class BookmarkService {

	@Autowired
	private BookmarkDao bookmarkDao;
	
	

	public Map<String, List<Bookmark>> getBookmarks() {
		return bookmarkDao.getBookmarks();
	}



	public List<Bookmark> getBookmarkByType(String type) {
		return bookmarkDao.getBookmarkByType(type);
	}

}
