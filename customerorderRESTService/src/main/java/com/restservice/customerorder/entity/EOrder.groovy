package com.restservice.customerorder.entity

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

import groovy.transform.Canonical

@Canonical
@Entity
@Table(name="Orders")
class EOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orderid")
	Integer orderId
	
	@Column(name="customerid")
	Integer customerId;
	
	//@Column(name="")
	@OneToMany(  
		cascade=CascadeType.ALL
		//orphanRemoval=true	
		, fetch = FetchType.EAGER
	)
	Set<EOrderLine> eorderLines = [] 
	
}
