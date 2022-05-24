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
		if (iBookService == null) {
			iBookService = new BookServiceImpl();
		}
		return iBookService;
	}

	public ICategoryService getCategoryService() {
		if (iCategoryService == null) {
			iCategoryService = new CategoryServiceImpl();
		}
		return iCategoryService;
	}

	public IMasterBookService getMasterBookFormatService() {
		if (iMasterBookService == null) {
			iMasterBookService = new MasterBookServiceImpl();
		}
		return iMasterBookService;
	}

}
