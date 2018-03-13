package com.vjay.starter.Starter.schedular;

import java.sql.SQLException

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component;

import com.vjay.starter.Starter.dao.InventoryDao;
import com.vjay.starter.Starter.model.InventoryItems
import com.vjay.starter.Starter.model.Shipment
import com.vjay.starter.Starter.model.ShopItem
import com.vjay.starter.Starter.util.MailerUtil

import groovy.text.SimpleTemplateEngine
import groovy.xml.MarkupBuilder

@Component
@PropertySource("classpath:mailtext.properties")
public class ScheduledJobs {
	
	@Autowired
	Environment env;
	
	@Autowired
	InventoryDao inveDao;


	//@Scheduled(fixedRate=5000L)
	public void removeOldStock() {
		try {
			List<Shipment> shipmentList = inveDao.getShipmentList()
			println "List obtained:$shipmentList" 
			Date today = new Date()
			List itemsRemovable = shipmentList.findAll({ item->
				today >= item.renewalDate && item.invStatus ==1 
			}).collect({it.batchId})
			if(!itemsRemovable.isEmpty()) {
				println "Items to be removed:$itemsRemovable"
				inveDao.removeInvbyBid(itemsRemovable)
				inveDao.updateShipmentStatus(itemsRemovable,2048)
			}else
				println "No item to be removed"
		}catch(SQLException ex) {
			println "Logging SQlEception:${ex.getMessage()}"
		}catch(Exception exp) {
			println "Logging Eception:${exp.getMessage()}"
		}
	}
	
	@Scheduled(fixedRate=5000L)
	public void alert4InvItem() {
		try {
			List<InventoryItems> shopItems = inveDao.getInventoryList() 
			List<InventoryItems> collectedItems = shopItems.groupBy{it.itemId} // Grouping based on itemid
					.collect{it.value.sum()} //Summation of Grouped arrays
					.findAll{InventoryItems item -> item.availableQty<=10}
			
							
			String mailBody =  env.getProperty("alert_Mail")
			
			//Constructing Table content
			StringWriter tableContent = new StringWriter()
			MarkupBuilder htmlBuilder = new MarkupBuilder(tableContent)
			htmlBuilder.setDoubleQuotes(true)
			 htmlBuilder.table(style : 'border:1px solid black'){
				tr{
					th 'itemId'
					th 'Product name'
					th 'Price'
					th 'Quantity'
				}
				tr{
					collectedItems.each{
						td it.itemId
						td it.itemName
						td it.price
						td it.availableQty
					}	
				}
			}
			
			///genrating mailcontent using simple Template 
			def binding = [
				tableContent : tableContent.toString()
				]
			
			String response = new SimpleTemplateEngine()
				.createTemplate(mailBody)
				.make(binding)
				
			println "Final response : $response" 
			MailerUtil.sendMail("dhoniramana@gmail.com", response) 
					
		}catch(SQLException ex) {
			println "Logging SQlEception:${ex.getMessage()}"
		}catch(Exception exp) {
			println "Logging Eception:${exp.getMessage()}"
		}
	}



}
