package io.thrill.bookmark.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import io.thrill.bookmark.constants.Gender;
import io.thrill.bookmark.constants.UserType;

@Entity
@Table(name="Users")
public class User  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4198185837371177330L;

	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name="email")
	private String email;
	
	@Column(name="usertype")
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "Userbookmark",			
			joinColumns = { @JoinColumn(name = "userid")},
			inverseJoinColumns = {@JoinColumn(name="bookmarkid")}
			)
	private Set<Bookmark> bookmarkList = new HashSet<>();

	
	public void setId(Long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", gender=" + gender + ", email=" + email + ", userType=" + userType + "]";
	}
	public Set<Bookmark> getBookmarkList() {
		return bookmarkList;
	}
	public void setBookmarkList(Set<Bookmark> bookmarkList) {
		this.bookmarkList = bookmarkList;
	}

	public void addBookmark(Bookmark bookmark){
		this.bookmarkList.add(bookmark);
	}

	
	
		
}
