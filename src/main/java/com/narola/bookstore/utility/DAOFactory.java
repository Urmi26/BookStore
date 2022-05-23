package com.narola.bookstore.utility;

import com.narola.bookstore.book.dao.BookDAOMysql;
import com.narola.bookstore.book.dao.BookDAOPostgres;
import com.narola.bookstore.book.dao.IBookDAO;
import com.narola.bookstore.category.dao.CategoryDAOMysql;
import com.narola.bookstore.category.dao.CategoryDAOPostgres;
import com.narola.bookstore.category.dao.ICategoryDAO;
import com.narola.bookstore.msbookformat.dao.IMasterBookFormatDAO;
import com.narola.bookstore.msbookformat.dao.MasterBookFormatDAOMysql;
import com.narola.bookstore.msbookformat.dao.MasterBookFormatDAOPostgres;
import com.narola.bookstore.exception.ApplicationException;

public class DAOFactory {
	
	private static DAOFactory DAO_HELPER = null;
	public static String MYSQL = "MYSQL";
	public static String POSTGRES = "POSTGRES";
	
	public IBookDAO BookDAO = null;
	public ICategoryDAO categoryDAO = null;
	public IMasterBookFormatDAO IMasterBookFormatDAO = null;
	
	public static DAOFactory getInstence() {
		if(DAO_HELPER == null) {
			DAO_HELPER = new DAOFactory();
		}
		return DAO_HELPER;
	}
	
	public IBookDAO getBookDAO() {
		return BookDAO;
	}
	public ICategoryDAO getCategoryDAO() {
		return categoryDAO;
	}
	public IMasterBookFormatDAO getMasterBookFormatDAO() {
		return IMasterBookFormatDAO;
	}
		
	public void init(String daoType) throws ApplicationException{
		if(daoType.equals(MYSQL)) {
			BookDAO = new BookDAOMysql();
			categoryDAO = new CategoryDAOMysql();
			IMasterBookFormatDAO = new MasterBookFormatDAOMysql();
			
		}else if(daoType.equals(POSTGRES)) {
			BookDAO = new BookDAOPostgres();
			categoryDAO = new CategoryDAOPostgres();
			IMasterBookFormatDAO = new MasterBookFormatDAOPostgres();
			
		}else {
			throw new ApplicationException("Type is not supported yet"); 
		}
	}
}
