package com.narola.bookstore.utility;

import com.narola.bookstore.book.service.IBookService;
import com.narola.bookstore.book.service.Impl.BookServiceImpl;
import com.narola.bookstore.category.service.ICategoryService;
import com.narola.bookstore.category.service.impl.CategoryServiceImpl;
import com.narola.bookstore.msbookformat.service.IMasterBookService;
import com.narola.bookstore.msbookformat.service.Impl.MasterBookServiceImpl;

public class ServiceFactory {

	private static ServiceFactory DAO_HELPER = null;
	public IBookService iBookService = null;
	public ICategoryService iCategoryService = null;
	public IMasterBookService iMasterBookService = null;

	public static ServiceFactory getInstence() {
		if (DAO_HELPER == null) {
			DAO_HELPER = new ServiceFactory();
		}
		return DAO_HELPER;
	}

	public IBookService getBookService() {
		return new BookServiceImpl();
	}

	public ICategoryService getCategoryService() {
		return new CategoryServiceImpl();
	}

	public IMasterBookService getMasterBookFormatService() {
		return new MasterBookServiceImpl();
	}

}
