package io.thrill.bookmark.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.thrill.bookmark.constants.KidFriendlyStatus;
import io.thrill.bookmark.constants.UserType;
import io.thrill.bookmark.dao.BookmarkDao;
import io.thrill.bookmark.dao.UserDao;
import io.thrill.bookmark.model.Book;
import io.thrill.bookmark.model.Bookmark;
import io.thrill.bookmark.model.User;
import io.thrill.bookmark.model.WebLink;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BookmarkDao bookmarkDao;

	public Map<String, Object> validateUser(Long userId, String password) {
		User user = userDao.getUser(userId);
		Map<String, Object> response = new HashMap<>();
		if (user != null && user.getPassword().equals(password)) {
			response.put("validFlag", true);
			response.put("userDetail", user);
			response.put("responseMsg", "User verfied succesfully");
		} else {
			response.put("validFlag", false);
			response.put("responseMsg", "Invalid ID/ Password");
		}
		return response;
	}

	public Map<String, Object> setKidFriendlyStatus(Long userId, Long bookmarkId) {
		User user = userDao.getUser(userId);
		Map<String, Object> response = new HashMap<>();
		Bookmark bookmark = bookmarkDao.getBookmark(bookmarkId);

		bookmark.setKidFriendlyMarkedBy(userId);
		if (user.getUserType().equals(UserType.EDITOR)) {
			bookmark.setKidFriendlyStatus(KidFriendlyStatus.APPROVED);
			response.put("status", "Bookmark is marked as Approved");
		} else {
			bookmark.setKidFriendlyStatus(KidFriendlyStatus.REQUESTED);
			response.put("status", "Bookmark is requested for Approved");
		}

		bookmarkDao.saveBookmark(bookmark);
		response.put("bookmark", bookmark);
		return response;
	}

	public Map<String, Object> share(Long userId, Long bookmarkId) {
		Bookmark bookmark = bookmarkDao.getBookmark(bookmarkId);
		bookmark.setSharedByUser(userId);
		Map<String, Object> response = new HashMap<>();
		String shareData = null;
		if (bookmark instanceof Book) {
			shareData = ((Book) bookmark).getData();
		} else if (bookmark instanceof WebLink) {
			shareData = ((WebLink) bookmark).getData();
		}
		response.put("shareData", shareData);
		response.put("status", "Bookmar Shared Successfully");
		return response;

	}

	public boolean saveUserBookmark(Long userId, Long bookmarkId) {
		User user = userDao.getUser(userId);
		Bookmark bookmark = bookmarkDao.getBookmark(bookmarkId);
		System.out.println(bookmark);  
		System.out.println("User:"+user);  
		boolean status = false;
		if (user != null) {
			user.addBookmark(bookmark);
			System.out.println("result: "+userDao.saveUser(user));;
			
			status = true;
		}
		return status;
	}

	public List<Bookmark> getUserBookmark(Long userId) {
		User user = userDao.getUser(userId);
		System.out.println("UserResponser:"+user.getBookmarkList());
		List<Bookmark> response = new ArrayList<>();
		if(user != null)
			response.addAll(user.getBookmarkList());
 		
		return  response;
		
	}
}
