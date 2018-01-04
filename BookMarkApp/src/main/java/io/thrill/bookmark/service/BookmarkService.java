package io.thrill.bookmark.service;

import io.thrill.bookmark.dao.BookmarkDao;
import io.thrill.bookmark.entity.Book;
import io.thrill.bookmark.entity.Bookmark;
import io.thrill.bookmark.entity.Movie;
import io.thrill.bookmark.entity.User;
import io.thrill.bookmark.entity.UserBookmark;
import io.thrill.bookmark.entity.WebLink;


public class BookmarkService {
	private static BookmarkService instance = new BookmarkService();
	private static BookmarkDao dao = new BookmarkDao();
	private BookmarkService(){}
	
	public static BookmarkService getInstance(){
		return instance;
	} 
	
	public Movie createMovie(long id,String title,String profileUrl,int releaseYear,String[] cast,String[] directors,String genre,double imdbRating){
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setDirectors(directors);
		movie.setCast(cast);
		movie.setImdbRating(imdbRating);
		movie.setGenre(genre);
		
		return movie;
	}
	
	public Book createBook(long id,String title,int publicationYear,String publisher,String[] author,String genre,double amazonRating) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setPublisher(publisher);
		book.setPublicationYear(publicationYear);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);
		return book;
	}
	
	public WebLink createwebLink(long id,String title,String url,String host) {
		WebLink weblink = new WebLink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setHost(host);
		weblink.setUrl(url);
		return weblink;
	}
	
	public Bookmark[][] getBookmark(){
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {  
		// TODO Auto-generated method stub
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setBookmark(bookmark);
		userBookmark.setUser(user);
		dao.saveUserBookmark(userBookmark);
	}

	public void setKidFriendlyStatus(User user, String decision, Bookmark bookmark) {
		bookmark.setKidFriendlyStatus(decision);
		bookmark.setKidFriendlyMarkedBy(user);
		System.out.println(user.getFirstName()+" bookmarked the item :"+bookmark+" as "+ decision);
	}

	public void share(User user, Bookmark bookmark) {
		bookmark.setSharedByUser(user);
		if(bookmark instanceof Book){
			System.out.println(((Book)bookmark).getData());
		}else if (bookmark instanceof WebLink) {
			System.out.println(((WebLink)bookmark).getData());
		}
		
		System.out.println("The bookmark "+bookmark + " is shared by "+user.getEmail());
	}
}
