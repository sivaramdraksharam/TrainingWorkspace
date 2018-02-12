package io.thrill.bookmark.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name="Userbookmark")
public class UserBookmark {
	
	@EmbeddedId
	private UserBookmarkId id;
	
	@Column(name="groupname")
	private String group;

	public UserBookmarkId getId() {
		return id;
	}

	public void setId(UserBookmarkId id) {
		this.id = id;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	

	

}
