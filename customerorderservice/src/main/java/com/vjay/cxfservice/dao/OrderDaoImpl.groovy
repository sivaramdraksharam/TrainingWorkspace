package com.vjay.cxfservice.dao

import java.util.List

import org.hibernate.HibernateException
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import com.vjay.customerorder.order.OrderLine
import com.vjay.cxfservice.constant.Unit
import com.vjay.cxfservice.entity.EOrder
import com.vjay.cxfservice.entity.EOrderLine
import com.vjay.cxfservice.entity.EProduct
import com.vjay.cxfservice.entity.TestTable

@Transactional
@Repository
class OrderDaoImpl implements OrderDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<TestTable> getOrder(BigInteger orderId) {
		Session session = sessionFactory.openSession()
		List result = session.createQuery("From TestTable",TestTable.class).getResultList()
		return result
	}

	@Override
	public int addOrder(EOrder order) {
		Session session = sessionFactory.getCurrentSession()
		/*EProduct prd1 = new EProduct();
		 prd1.unit = Unit.NUMBER;
		 prd1.manufacturer = "Some manufacturor"
		 prd1.prdId = "PRD001" 
		 prd1.productName = "Some name"
		 prd1.unitListprice = 10.00
		 EOrderLine orderline1 = new EOrderLine();
		 orderline1.product = prd1
		 orderline1.quantity = 10
		 orderline1.unitSaleprice = 9.75
		 //orderline1.lineId = lineid
		 EOrder orderobj = new EOrder();
		 orderobj.customerId = 1000
		 orderobj.eorderLines<<orderline1*/ 

		Integer orderid =session.save(order)
		order.eorderLines.each{
			Integer lineid = (Integer)session.save(it);
			println "new key:"+lineid
			session.saveOrUpdate(it.product)
		}
		return orderid;
	}

	@Override
	public EOrder getOrderById(Integer id) {
		Session session = sessionFactory.getCurrentSession()
		List list = session.createQuery("From EOrder a where a.orderId = "+id,EOrder.class).getResultList()
		return list.get(0);
	}

	@Override
	public EProduct getProduct(String prdId) {
		Session session = sessionFactory.getCurrentSession()
		List list = session.createQuery("From EProduct a where a.prdId = "+prdId,EProduct.class).getResultList()
		return list.get(0);
	}

	@Override
	public List<EOrder> getOrders(Integer customerId) {
		Session session = sessionFactory.getCurrentSession()
		List list = session.createQuery("From EOrder a where a.customerId = "+customerId,EOrder.class).getResultList()
		return list;
	}

	@Override
	public boolean deleteOrderLine(int orderId, String productId) {
		Session session = sessionFactory.getCurrentSession();
		List<EOrder> olist = session.createQuery("From EOrder a where a.orderId = $orderId", EOrder.class).getResultList();
		EOrder orderObj = olist?.get(0)
		List<EOrderLine> lineItems = []
		lineItems.addAll(orderObj.eorderLines)  
		lineItems.removeAll{
			it.product.prdId.equals(productId)
		}
		orderObj.eorderLines = lineItems
		
		try {
			if(lineItems.size()!=0)
				session.persist(orderObj)
			else
				session.delete(orderObj) 	    
			return true;  
		}catch(HibernateException exp) {  
			exp.printStackTrace();
			return false;
		}catch(Exception exp) {
			println "Other Exception:$exp.getMessage()"
			return false;
		}
	}

	@Override
	public boolean deleteOrder(int orderId) {
		Session session = sessionFactory.getCurrentSession();
		List<EOrder> orderlist = session.createQuery("From EOrder a where a.orderId = $orderId", EOrder.class).getResultList();
		session.delete(orderlist.get(0))  
		
		try {
			session.delete(orderlist.get(0))
			//session.flush();    
			return true;
		}catch(HibernateException exp) {
			exp.printStackTrace();  
			return false;
		}catch(Exception exp) {
			exp.printStackTrace(); 
	//		println "Other Exception:$exp.getMessage()"
			return false;
		}
		
	} 
}
