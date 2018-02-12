package io.thrill.bookmark.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.thrill.bookmark.model.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User getUser(Long userid) {
		String hql = "FROM User as a where a.id=?";
		List<User> resultset = entityManager.createQuery(hql, User.class).setParameter(1, userid).getResultList();
		User user = (resultset.size() > 0) ? resultset.get(0) : null;
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User as a where a.id=?";
		return entityManager.createQuery(hql, User.class).getResultList();
	}

	@Override
	public User saveUser(User user) {
		System.out.println("Commiting user:"+user);
		entityManager.persist(user);
		entityManager.flush();
		return getUser(user.getId());  
	}

	

}
