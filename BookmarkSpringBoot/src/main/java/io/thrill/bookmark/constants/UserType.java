package io.thrill.bookmark.constants;

public enum UserType {

	USER 	("user"),
	EDITOR ("editor"),
	CHEIF_EDITOR ("cheifeditor");
	
	private String name;

	private UserType (String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
