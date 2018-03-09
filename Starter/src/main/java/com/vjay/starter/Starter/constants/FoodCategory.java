package com.vjay.starter.Starter.constants;

public enum FoodCategory {
	VEGETARIAN("Vegetatian"),
	NON_VEGETARIAN("Non-Vegetarian"),
	VEGAN("Vegan");
	
	private FoodCategory(String type){
		this.foodCategory = type;
	}
	private String foodCategory;
	
	public String getFoodCategory() {
		return foodCategory;
	} 
	
	
	
}
