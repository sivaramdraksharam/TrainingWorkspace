package io.thrill.bookmark.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import io.thrill.bookmark.constants.KidFriendlyStatus;

@Entity
@Table(name = "bookmark")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Bookmark {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "profileurl")
	private String profileUrl;

	@Column(name = "kidfriendlystatus")
	private String kidFriendlyStatus = KidFriendlyStatus.UNKNOWN;

	@Column(name = "kidfriendlymarkedby")
	private Long kidFriendlyMarkedBy;

	@Column(name = "sharedbyuser")
	private Long sharedByUser;
	
	/*
	@JoinTable(
			name = "userbookmark",			
			joinColumns = { @JoinColumn(name = "bookmarkid")},
			inverseJoinColumns = {@JoinColumn(name="userid")}
			)
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "bookmarkList")
	private Set<User> userList = new HashSet<>();*/
	
	public String getKidFriendlyStatus() {
		return kidFriendlyStatus;
	}

	public void setKidFriendlyStatus(String kidFriendlyStatus) {
		this.kidFriendlyStatus = kidFriendlyStatus;
	}

	public Long getKidFriendlyMarkedBy() {
		return kidFriendlyMarkedBy;
	}

	public void setKidFriendlyMarkedBy(Long kidFriendlyMarkedBy) {
		this.kidFriendlyMarkedBy = kidFriendlyMarkedBy;
	}

	public Long getSharedByUser() {
		return sharedByUser;
	}

	public void setSharedByUser(Long sharedByUser) {
		this.sharedByUser = sharedByUser;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public abstract boolean isKidFriendlyEligible();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bookmark other = (Bookmark) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
}
