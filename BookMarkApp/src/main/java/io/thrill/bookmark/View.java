package io.thrill.bookmark;

import java.util.Iterator;

import io.thrill.bookmark.constants.KidFriendlyStatus;
import io.thrill.bookmark.constants.UserType;
import io.thrill.bookmark.controller.BookmarkController;
import io.thrill.bookmark.entity.Bookmark;
import io.thrill.bookmark.entity.User;
import io.thrill.bookmark.partner.Sharable;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println(user.getEmail() + " has bookmarked below...");
		int bookMarkCount = 0;
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				boolean decison = decideIftoBookmark();
				if (decison) {
					if (bookMarkCount < DataStore.USER_BOOKMARK_LIMIT) {
						System.out.println(bookmark);
						BookmarkController.getInstance().saveUserBookmark(user,
								bookmark);
						bookMarkCount++;
					}
				}
				//Editor Approving bookmark
				if (user.getUserType().equals(UserType.EDITOR)|| user.getUserType().equals(UserType.CHEIF_EDITOR)) {
					System.out.println("Editor now starts approving the Bookmarks");
					if (bookmark.isKidFriendlyEligible() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String decision = decideifToApprove();
						BookmarkController.getInstance().setKidFriendlyStatus(user,decision,bookmark);
					}else{
						if(!bookmark.isKidFriendlyEligible())
							System.out.println("This bookmark is not eligible to mark kidfriendly :"+bookmark);
					}
				}
				
				//Sharing BookMark
				if(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED) && bookmark instanceof Sharable){
					boolean isSharable = decideOnShare();
					if(isSharable){
						BookmarkController.getInstance().share(user,bookmark);
					}
				}
				
				
			}
		}
	}

	public static boolean decideIftoBookmark() {
		return (Math.random() < 0.6) ? true : false;
	}
	
	public static boolean decideOnShare() {
		return (Math.random() < 0.6) ? true : false;
	}

	public static String decideifToApprove() {
		return (Math.random() < 0.5) ? KidFriendlyStatus.REJECTED : (Math
				.random() > 0.8) ? KidFriendlyStatus.UNKNOWN
				: KidFriendlyStatus.APPROVED;
	}

	public static void bookmark(User user, Bookmark[][] bookmarks) {
		System.out.println(user.getEmail() + " is bookmark...");
		for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
			int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPE_COUNT);
			int bmkOffset = (int) (Math.random() * DataStore.COUNT_PER_BOOKMARK);
			Bookmark bookmark = bookmarks[typeOffset][bmkOffset];
			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
			System.out.println(bookmark);
		}
	}
}
