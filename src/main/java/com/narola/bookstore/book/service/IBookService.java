package com.narola.bookstore.book.service;

import java.util.List;

import com.narola.bookstore.book.model.Book;
import com.narola.bookstore.category.model.Categorry;
import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.msbookformat.model.MasterBookFormat;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IBookService {

	void addBook(Book book, HttpServletRequest request, HttpServletResponse response);

	List<Categorry> getAllCategory() throws ApplicationException;

	List<MasterBookFormat> getAllMasterBookFormat() throws ApplicationException;

	Book getBookAllDetails(int bookId) throws ApplicationException;

	void deletebook(int bookId, HttpServletRequest request, HttpServletResponse response);

	List<Book> searchBooks(String bookName) throws ApplicationException;

	Book getBookId(int bookId, HttpServletRequest request) throws ApplicationException;

	List<Integer> getListOfMsBookId(int bookId) throws ApplicationException;

	void updateBook(Book book, List<Integer> msBookId, String[] msBookIdChecked, HttpServletRequest request,
			HttpServletResponse response) throws ApplicationException;

	Book getBookInformationById(int bookId, HttpServletRequest request) throws ApplicationException;

	List<Book> searchCategoryById(int categoryId) throws ApplicationException;

	List<Book> getListOfBooks() throws ApplicationException;

	void addMasterBookFormat(Book book) throws ApplicationException;

	void deleteMasterBookFormat(int bookId, int msBookId) throws ApplicationException;

	void deleteImage(HttpServletRequest request, HttpServletResponse response) throws ApplicationException;
}
