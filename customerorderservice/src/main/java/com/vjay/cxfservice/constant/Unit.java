package com.vjay.cxfservice.constant;

public enum Unit {

	KG("KG"),
	LITRE("Litre"),
	NUMBER("Number"); 
	
	private Unit(String name) {
		this.name=name;
	}
	private String name;
	
	
	public String getName() {
		return name;
	}
	
	
	
}
