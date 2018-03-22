package io.thrill.bookmark.model;

import java.io.Serializable;

import javax.persistence.Column;

//@Embeddable
public class UserBookmarkId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="userid")
	private Long userId;
	
	@Column(name="bookmarkid")
	private Long bookmarkId;
	
	public Long getUser() {
		return userId;
	}
	public void setUser(Long user) {
		this.userId = user;
	}
	public Long getBookmark() {
		return bookmarkId;
	}
	public void setBookmark(Long bookmark) {
		this.bookmarkId = bookmark;
	}
}
