package io.thrill.bookmark.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import io.thrill.bookmark.constants.KidFriendlyStatus;

@Entity
@Table(name = "Bookmark")
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

	
}
