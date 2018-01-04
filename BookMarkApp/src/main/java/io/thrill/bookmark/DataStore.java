package io.thrill.bookmark;

import io.thrill.bookmark.constants.BookGenre;
import io.thrill.bookmark.constants.Gender;
import io.thrill.bookmark.constants.MovieGenre;
import io.thrill.bookmark.constants.UserType;
import io.thrill.bookmark.entity.Bookmark;
import io.thrill.bookmark.entity.User;
import io.thrill.bookmark.entity.UserBookmark;
import io.thrill.bookmark.service.BookmarkService;
import io.thrill.bookmark.service.UserService;
import io.thrill.bookmark.utils.IOUtil;

public class DataStore {
	
	public static final int USER_BOOKMARK_LIMIT = 5;

	public static final int COUNT_PER_BOOKMARK = 5;

	public static final int BOOKMARK_TYPE_COUNT = 3;

	public static final int TOTAL_USER_COUNT = 5;
	
	private static User[] user = new User[TOTAL_USER_COUNT];
	private static Bookmark[][] bookMarks = new Bookmark[BOOKMARK_TYPE_COUNT][COUNT_PER_BOOKMARK];
	private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];
	private static int bookmarkIndex = 0;
	public static void loadData() {
		loadUser();
		loadWebLinks();
		loadMovies();
		loadBooks();
	}	
	public static User[] getUser() {
		return user;
	}
	public static Bookmark[][] getBookMarks() {
		return bookMarks;
	}
	private static void loadUser() {
		UserService userService = UserService.getInstance();
		String data[] = new String[TOTAL_USER_COUNT];
		IOUtil.read(data, "User");
		int rowCount = 0;
		for(String row : data) {
			String[] userProp = row.split("\t");
			long id = Long.parseLong( userProp[0]);
			int gender = (userProp[5].equals("m")) ? Gender.MALE : (userProp[5].equals("f")) ? Gender.FEMALE : Gender.TRANSGENDER;
			String userType = userProp[6].equals("chiefeditor") ? UserType.CHEIF_EDITOR : userProp[6].equals("editor") ? UserType.EDITOR : UserType.USER; 
			user[rowCount++] =userService.createUser(id,userProp[1],userProp[2],userProp[3],userProp[4],gender,userType);
		}
	}
	
	private static void loadWebLinks() {
		BookmarkService bookMarkService = BookmarkService.getInstance();
		String data[] = new String[COUNT_PER_BOOKMARK];
		IOUtil.read(data, "WebLink");
		int rowCount = 0;
		for(String row : data) {
			String[] prop = row.split("\t");
			long id = Long.parseLong( prop[0]);
			bookMarks[0][rowCount] = bookMarkService.createwebLink(id,prop[1],prop[2],prop[3]);
			rowCount++;
		}
	}
	
	private static void loadMovies() {
		BookmarkService bookMarkService = BookmarkService.getInstance();
		String data[] = new String[COUNT_PER_BOOKMARK];
		IOUtil.read(data, "Movie");
		int rowCount = 0;
		for(String row : data) {
			String[] prop = row.split("\t");
			long id = Long.parseLong( prop[0]);
			String[] cast = prop[3].split(",");
			String[] directors = prop[4].split(",");
			bookMarks[1][rowCount] = bookMarkService.createMovie(id,prop[1],"",Integer.parseInt(prop[2]),cast,directors,prop[5],Double.parseDouble(prop[6]));
			rowCount++;
		}
	}
	
	private static void loadBooks() {
		BookmarkService bookMarkService = BookmarkService.getInstance();
		bookMarks[2][0] = bookMarkService.createBook(4000,"Walden",1854,"Wilder Publications",new String[] {"Henry David Thoreau"},BookGenre.PHILOSOPHY,4.3);
		bookMarks[2][1] = bookMarkService.createBook(4001,"Self-Reliance and Other Essays",1993,"Dover Publications",new String[] {"Ralph Waldo Emerson"},BookGenre.PHILOSOPHY,4.5);
		bookMarks[2][2] = bookMarkService.createBook(4002,"Light From Many Lamps",1988,"Touchstone",new String[] {"Lillian Eichler Watson"},BookGenre.PHILOSOPHY,5.0);
		bookMarks[2][3] = bookMarkService.createBook(4003,"Head First Design Patterns",2004,"O'Reilly Media",new String[] {"Eric Freeman,Bert Bates,Kathy Sierra,Elisabeth Robson"},BookGenre.TECHNICAL,4.5);
		bookMarks[2][4] = bookMarkService.createBook(4004,"Effective Java Programming Language Guide",2007,"Prentice Hall",new String[] {"Joshua Bloch"},BookGenre.TECHNICAL,4.9);
	}
	public static void add(UserBookmark userBookmark) {
		userBookmarks[bookmarkIndex] = userBookmark;
		bookmarkIndex++;
	}
}
