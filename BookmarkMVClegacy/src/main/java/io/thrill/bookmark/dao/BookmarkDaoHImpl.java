package io.thrill.bookmark.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.thrill.bookmark.model.Bookmark;
import io.thrill.bookmark.util.SessionUtils;

@Transactional
@Repository
public class BookmarkDaoHImpl implements BookmarkDao {

	//private SessionFactory sessionFactory;
	@Autowired
	private SessionUtils sessionUtil;
	
	public Bookmark getBookmark(Long id) {
		Session session = sessionUtil.getSession();
		List<Bookmark> bookmarkList = session.createQuery("From Bookmark a where a.id =" + id, Bookmark.class)
				.getResultList();
		return (bookmarkList.size() > 0) ? bookmarkList.get(0) : null;
	}

	public Map<String, List<Bookmark>> getBookmarks() {
		Session session = sessionUtil.getSession();

		Map<String, List<Bookmark>> bookmarks = new HashMap<>();

		String hqlBook = "FROM Book as bk order by bk.id desc";
		List<Bookmark> books = session.createQuery(hqlBook, Bookmark.class).setMaxResults(3).getResultList();

		String hqlMovie = "FROM Movie";
		List<Bookmark> movies = session.createQuery(hqlMovie, Bookmark.class).setMaxResults(3).getResultList();

		String hqlWeblink = "FROM WebLink";
		List<Bookmark> weblink = session.createQuery(hqlWeblink, Bookmark.class).setMaxResults(3).getResultList();

		bookmarks.put("books", books);
		bookmarks.put("movies", movies);
		bookmarks.put("weblinks", weblink);

		return bookmarks;
	}

	@Override
	public Bookmark saveBookmark(Bookmark bookmark) {
		Session session = sessionUtil.getSession();
		session.persist(bookmark);
		return bookmark;
	}

	@Override
	public List<Bookmark> getBookmarkByType(String type) {
		Session session = sessionUtil.getSession();

		List<Bookmark> list = new ArrayList<>();
		String hql = "";
		if ("books".equalsIgnoreCase(type))
			hql = "FROM Book";
		else if ("weblinks".equalsIgnoreCase(type))
			hql = "FROM Weblink";
		else if ("movies".equalsIgnoreCase(type))
			hql = "FROM Movie";
		else
			return list;

		return session.createQuery(hql, Bookmark.class).getResultList();
	}

}
