package io.thrill.bookmark.dao;

import java.util.List;



import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.thrill.bookmark.model.User;
import io.thrill.bookmark.util.SessionUtils;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionUtils sessionUtil;
	

	@Override
	public User getUser(Long userid) {
		Session session = sessionUtil.getSession();
		String hql = "FROM User as a where a.id= "+userid;
		
		List<User> resultset = session.createQuery(hql, User.class).getResultList();
		User user = (resultset.size() > 0) ? resultset.get(0) : null;
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		Session session = sessionUtil.getSession();
		String hql = "FROM User";
		return session.createQuery(hql, User.class).getResultList();
	}

	@Override
	public User saveUser(User user) {
		Session session = sessionUtil.getSession();
		System.out.println("Commiting user:"+user);
		session.persist(user);
		return getUser(user.getId());  
	}
	
	@Override
	public User saveUserBookmark(User user) {
		Session session = sessionUtil.getSession();
		System.out.println("Commiting user:"+user);
		session.saveOrUpdate(user);
		return user;
	}
	

}
