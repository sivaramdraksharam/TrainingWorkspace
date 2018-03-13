package com.vjay.jercyapp.constants;

public enum HouseholdCategory {
	
	KITCHEN_UTIL("Kichen Utility"),
	SOAP_WASHINGPOWDER("Soap/Drycleaner/Washingpowder");
	
	
	private HouseholdCategory(String category) {
		this.category = category;
	}
	
	private String category;

	public String getCategory() {
		return category;
	}
	
}
