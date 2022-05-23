package com.narola.bookstore.book.dao;

import java.util.List;
import com.narola.bookstore.book.model.Book;
import com.narola.bookstore.category.model.Categorry;
import com.narola.bookstore.exception.DatabaseException;
import com.narola.bookstore.msbookformat.model.MasterBookFormat;

public interface IBookDAO {
	List<Book> getAllBooks() throws DatabaseException;

	int insertQry(Book book) throws DatabaseException;

	int deleteQry(int bookId) throws DatabaseException;

	Book getBookByID(int bookId) throws DatabaseException;

	List<Integer> getListofMasterBookID(int bookId) throws DatabaseException;

	Book getBookInfoByID(int bookId) throws DatabaseException;

	int updateQry(Book book) throws DatabaseException;

	List<Book> searchBookName(String bookNameStr) throws DatabaseException;

	List<Book> searchCategoryId(int categoryId) throws DatabaseException;

	List<Categorry> getListOfCategory() throws DatabaseException;

	List<MasterBookFormat> getListOfMasterBookFormat() throws DatabaseException;

	List<MasterBookFormat> getListOfBookFormatForBookId(int bookId) throws DatabaseException;

	List<Integer> getListOfMsBookId(int bookId) throws DatabaseException;

	void insertQryOfMsBookId(Book book) throws DatabaseException;

	void deleteQryofMsBookID(int bookId, int msBookId) throws DatabaseException;

	Book displayBookDetails(int bookId) throws DatabaseException;

}
