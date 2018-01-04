package io.thrill.bookmark.dao;

import io.thrill.bookmark.DataStore;
import io.thrill.bookmark.entity.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUser();
	}
}
