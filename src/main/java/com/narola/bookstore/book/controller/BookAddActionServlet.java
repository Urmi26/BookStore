package com.narola.bookstore.book.controller;

import java.io.IOException;

import com.narola.bookstore.book.model.Book;
import com.narola.bookstore.book.service.IBookService;
import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.msbookformat.model.MasterBookFormat;
import com.narola.bookstore.utility.ServiceFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@MultipartConfig
public class BookAddActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			IBookService iBookService = ServiceFactory.getInstence().getBookService();
			Book book = new Book();
			book.setBookName(request.getParameter("bookName"));
			book.setAuthorName(request.getParameter("authorName"));
			book.setDescription(request.getParameter("description"));
			book.setAmount(Double.parseDouble(request.getParameter("bookAmount")));
			book.setCategoryId(Integer.parseInt(request.getParameter("bookCategoryId")));
			book.setPublisherName(request.getParameter("publisherName"));
			MasterBookFormat masterBookFormat = new MasterBookFormat();
			masterBookFormat.setMsBookIdList((request.getParameterValues("msBookId")));
			book.setMasterBookFormat(masterBookFormat);
			iBookService.addBook(book, request, response);
		} catch (ApplicationException e) {
			request.setAttribute("ErrorMessage", e.getMessage());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Book-Form.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
