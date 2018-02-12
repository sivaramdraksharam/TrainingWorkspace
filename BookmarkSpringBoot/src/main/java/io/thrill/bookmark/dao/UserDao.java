package io.thrill.bookmark.dao;

import java.util.List;

import io.thrill.bookmark.model.User;

public interface UserDao {

	public User getUser(Long userId);
	public List<User> getAllUsers();
	public User saveUser(User user);
	
}
