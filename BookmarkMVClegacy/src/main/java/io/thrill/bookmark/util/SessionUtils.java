package io.thrill.bookmark.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionUtils {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		try{
			System.out.println("Give Current Session");
			
			return sessionFactory.getCurrentSession();
		}catch(Exception e){
			System.out.println("throws Exception.Create new Session:"+e.getMessage());
			return sessionFactory.openSession();
		}
	}
}
