package io.thrill.bookmark.constants;

public enum Gender {
	MALE(0), FEMALE(1), TRANSGENDER(2);

	private Gender(int val) {
		this.setVal(val);
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	private int val;
}
