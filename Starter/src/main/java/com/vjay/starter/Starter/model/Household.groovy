package com.vjay.starter.Starter.model

import com.vjay.starter.Starter.constants.HouseholdCategory

class Household extends ShopItem{
	
	String brand;
	HouseholdCategory category;
	
	
	@Override
	public boolean isKidHazardous() {
		return true;
	}
	
}
