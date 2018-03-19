package com.vjay.cxfservice.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

import groovy.transform.Canonical

@Canonical
@Entity
@Table(name="OrderLine")
class EOrderLine {
	@Id
	@Column(name="lineid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer lineId;
	  
	@ManyToOne
	//@Column(name="product")
	@JoinColumn(name="prdid")
	EProduct product
	
	@Column(name="quantity")  
	int quantity
	
	@Column(name="unitsaleprice")
	BigDecimal unitSaleprice
		
}
