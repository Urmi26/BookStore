package com.narola.bookstore.book.controller;

import java.io.IOException;
import java.util.List;
import com.narola.bookstore.book.model.Book;
import com.narola.bookstore.book.service.IBookService;
import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.utility.Constant;
import com.narola.bookstore.utility.ServiceFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@MultipartConfig
public class BookUpdateActionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		try {
			IBookService iBookService = ServiceFactory.getInstence().getBookService();

			int bookId = Integer.parseInt(request.getParameter("bookId"));
			String bookName = request.getParameter("bookName");
			String authorname = request.getParameter("authorName");
			String description = request.getParameter("description");
			Double amount = Double.parseDouble(request.getParameter("bookAmount"));
			int categoryId = Integer.parseInt(request.getParameter("bookCategoryId"));
			String publisherName = request.getParameter("publisherName");

			Book book = new Book(bookId, bookName, authorname, description, amount, categoryId, publisherName);
			String[] masterBookIdChecked = request.getParameterValues("msBookId");

			List<Integer> masterBookId = iBookService.getListOfMsBookId(bookId);
			iBookService.updateBook(book, masterBookId, masterBookIdChecked, request);
			response.sendRedirect(request.getContextPath() + Constant.BOOK_DISPLAY_URL);

		} catch (ApplicationException e) {
			request.setAttribute(Constant.ERROR, e.getMessage());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Errorpage.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
