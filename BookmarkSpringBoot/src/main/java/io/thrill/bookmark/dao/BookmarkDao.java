package io.thrill.bookmark.dao;

import java.util.List;
import java.util.Map;

import io.thrill.bookmark.model.Bookmark;

public interface BookmarkDao {
	
	public Bookmark getBookmark(Long id);
	public List<Bookmark> getBookmarkByType(String type);
	public Map<String, List<Bookmark>> getBookmarks();
	public Bookmark saveBookmark(Bookmark bookmark);
	
}
