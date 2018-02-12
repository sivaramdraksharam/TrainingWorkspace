package io.thrill.bookmark.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.thrill.bookmark.model.Bookmark;
import io.thrill.bookmark.service.BookmarkService;

@RestController
@RequestMapping("/book")
public class BookMarkController {

	@Autowired
	private BookmarkService bookmarkService;

	@RequestMapping("/getAll")
	public Map<String, List<Bookmark>> getAllbooks() {
		return bookmarkService.getBookmarks();
	}	
	
	@RequestMapping("/getBookmarkByType/{type}")
	public List<Bookmark> getBookmarkByType(@PathVariable String type){
		return bookmarkService.getBookmarkByType(type);
	}
	
	

}
