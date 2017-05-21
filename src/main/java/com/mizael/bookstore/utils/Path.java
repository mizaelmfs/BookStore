package com.mizael.bookstore.utils;

public class Path {

	///////////////////////////////////////////////////////////////
	// ROOT PATH
	///////////////////////////////////////////////////////////////

	public static final String ALL = "/**";

	public static final String PUBLIC_ROOT_PATH =  "/public";

	public static final String PRIVATE_ROOT_PATH =  "/private";

	///////////////////////////////////////////////////////////////
	// PRIVATE PATHS
	///////////////////////////////////////////////////////////////

	public static final String BOOK_PATH = PRIVATE_ROOT_PATH + "/book";

	public static final String USER_PATH = PRIVATE_ROOT_PATH + "/user";
	
	public static final String SALE_PATH = PRIVATE_ROOT_PATH + "/sale";

	///////////////////////////////////////////////////////////////
	// PUBLIC PATHS
	///////////////////////////////////////////////////////////////
	
	public static final String HOME_PATH = PUBLIC_ROOT_PATH + "/";

	public static final String LOGIN_PATH = PUBLIC_ROOT_PATH + "/login";

	public static final String LOGOUT_PATH = PUBLIC_ROOT_PATH + "/logout";
	
	public static final String ACCONT_PATH = PUBLIC_ROOT_PATH + "/accont";
}
