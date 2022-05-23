package com.narola.bookstore.category.dao;

import java.util.List;

import com.narola.bookstore.category.model.Categorry;
import com.narola.bookstore.exception.DatabaseException;

public interface ICategoryDAO {

	List<Categorry> getAllCategorry() throws DatabaseException;
	
	int insertQry(String categoryName) throws DatabaseException;
	
	int deleleQry(int categoryid) throws DatabaseException;
	
	int updateQry(Categorry category) throws DatabaseException;
	
	Categorry getUpdateDataFetchById(int catategoryid) throws DatabaseException;
	
	List<Categorry> searchByCategoryName(String categoryName) throws DatabaseException;
}
