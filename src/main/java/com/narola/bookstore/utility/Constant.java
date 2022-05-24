package com.narola.bookstore.utility;

public class Constant {

	private Constant() {
		throw new IllegalStateException("Utility class");
	}
	public static final String ERROR = "ErrorMessage";
	public static final String BACKSLASH_URL_USED = "\\";

	public static final String CATEGORY_ADD_URL = "/AddCategory";
	public static final String CATEGORY_UPDATE_URL = "/UpdateCategory";
	public static final String CATEGORY_DISPLAY_URL = "/DisplayCategories";

	public static final String MASTER_BOOK_FORMAT_ADD_URL = "/AddMSBook";
	public static final String MASTER_BOOK_FORMAT_UPDATE_URL = "/UpdateMSBook";
	public static final String MASTER_BOOK_FORMAT_DISPLAY_URL = "/DisplayMSBooks";

	public static final String BOOK_ADD_URL = "/AddBook";
	public static final String BOOK_UPDATE_URL = "/UpdateBook";
	public static final String BOOK_DISPLAY_URL = "/DisplayBooks";
	public static final String BOOK_DISPLAY_SELECTED_URL = "/DisplaySelectedBook";

	public static final String ADMIN = "/AddBook";
	public static final String USER = "/HomePageOfUser";
	public static final String USER_UPDATE_URL = "/UserUpdateAction";

}
