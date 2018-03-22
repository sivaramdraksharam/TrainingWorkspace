package com.restservice.customerorder.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import com.restservice.customerorder.constant.Unit
import groovy.transform.Canonical

@Canonical
@Entity
@Table(name="Product")
class EProduct {
	@Id
	@Column(name="prdid")
	String prdId
	
	@Column(name="productname")  
	String productName
	
	@Column(name="unitlistprice")
	BigDecimal unitListprice
	
	@Column(name="manufacturer")
	String manufacturer
	
	@Column(name="unit")
	Unit unit;
	
}
