package com.vjay.starter.Starter.model;

import com.vjay.starter.Starter.constants.FoodCategory;

import groovy.transform.Canonical

@Canonical
public class Food extends ShopItem{
	
	FoodCategory category
	Date dateOfManufacture
	int noOfDayforExpiry

	@Override
	public boolean isKidHazardous() {
		return false;
	}	
}
