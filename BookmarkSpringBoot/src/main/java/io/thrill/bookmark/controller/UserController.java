package io.thrill.bookmark.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.thrill.bookmark.model.Bookmark;
import io.thrill.bookmark.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userSerive;
	
	//@CrossOrigin(origins= "http://localhost:8080")
	@PostMapping("/validateUser")
	public Map<String, Object>  validateUser(@RequestBody Map<String, Object> userParam){
		Long userId = Long.parseLong((String) userParam.get("id"));  
		String password = (String) userParam.get("password"); 
		return userSerive.validateUser(userId,password);
		
	}
	
	//@CrossOrigin(origins= "http://localhost:8080")
	@PostMapping("/setKidFriendlyStatus")
	public Map<String, Object> setKidFriendlyStatus(@RequestBody Map<String, Object> userParam) {
		Long userId = Long.parseLong((String) userParam.get("userId"));
		Long bookmarkId = Long.parseLong((String) userParam.get("bookmarkId"));
		return userSerive.setKidFriendlyStatus(userId, bookmarkId);
	}
	
	//@CrossOrigin(origins= "http://localhost:8080")
	@PostMapping("/share")
	public  Map<String, Object> share(@RequestBody Map<String, Object> userParam) {
		Long userId = Long.parseLong((String) userParam.get("userId"));
		Long bookmarkId = Long.parseLong((String) userParam.get("bookmarkId"));
		return userSerive.share(userId,bookmarkId);
		
	}
	
	//@CrossOrigin(origins= "http://localhost:8080")
	@PostMapping("/saveBookmark")
	public Map<String, Object> saveUserBookmark(@RequestBody Map<String, Object> requestParam) {
		Map<String, Object> response = new HashMap<>();

		Long userId = Long.parseLong((String) requestParam.get("userId"));
		Long bookmarkId = Long.parseLong((String) requestParam.get("bookmarkId"));
		boolean resp = userSerive.saveUserBookmark(userId, bookmarkId);
		response.put("result", resp);
		return response;
	}
	
	@RequestMapping("/getUserBookmark/{userIdStr}")
	public List<Bookmark> getUserBookmark(@PathVariable  String userIdStr){
		Long userId = Long.parseLong(userIdStr);
		//System.out.println(userSerive.getUserBookmark(userId));
		return userSerive.getUserBookmark(userId);   
	}
	
}
