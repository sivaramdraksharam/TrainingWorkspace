package io.thrill.bookmark.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.thrill.bookmark.model.Bookmark;

@Transactional
@Repository
public class BookmarkDaoHImpl implements BookmarkDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Bookmark getBookmark(Long id) {
		List<Bookmark> bookmarkList = entityManager.createQuery("From Bookmark a where a.id = ?", Bookmark.class)
				.setParameter(1, id).getResultList();
		return (bookmarkList.size() > 0) ? bookmarkList.get(0) : null;
	}

	public Map<String, List<Bookmark>> getBookmarks() {
		Map<String, List<Bookmark>> bookmarks = new HashMap<>();
		String hqlBook = "FROM Book as bk order by bk.id desc";
		List<Bookmark> books = entityManager.createQuery(hqlBook, Bookmark.class).setMaxResults(3).getResultList();

		String hqlMovie = "FROM Movie";
		List<Bookmark> movies = entityManager.createQuery(hqlMovie, Bookmark.class).setMaxResults(3).getResultList();

		String hqlWeblink = "FROM WebLink";
		List<Bookmark> weblink = entityManager.createQuery(hqlWeblink, Bookmark.class).setMaxResults(3).getResultList();
		
		
		bookmarks.put("books", books);
		bookmarks.put("movies", movies);
		bookmarks.put("weblinks", weblink);

		return bookmarks;
	}



	@Override
	public Bookmark saveBookmark(Bookmark bookmark) {
		entityManager.persist(bookmark);
		return bookmark;
	}

	@Override
	public List<Bookmark> getBookmarkByType(String type) {
		List<Bookmark> list = new ArrayList<>(); 
		String hql = "";
		if("books".equalsIgnoreCase(type))
			hql = "FROM Book";
		else if ("weblinks".equalsIgnoreCase(type)) 
			hql = "FROM Weblink";		
		else if ("movies".equalsIgnoreCase(type)) 
			hql = "FROM Movie"; 
		else
			 return list;
		
		return entityManager.createQuery(hql, Bookmark.class).getResultList();
	}



}
