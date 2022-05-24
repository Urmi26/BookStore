package com.narola.bookstore.book.controller;

import java.io.IOException;
import com.narola.bookstore.book.model.Book;
import com.narola.bookstore.book.service.IBookService;
import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.utility.Constant;
import com.narola.bookstore.utility.ServiceFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BookUpdateFormServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			IBookService iBookService = ServiceFactory.getInstence().getBookService();
			Book book = iBookService.getBookId(Integer.parseInt(request.getParameter("bookId")), request);
			request.setAttribute("Book", book);
			request.setAttribute("msBookId", iBookService.getListOfMsBookId(book.getBookId()));
			request.setAttribute("listOfCategory", iBookService.getAllCategory());
			request.setAttribute("listOfMsBookFormat", iBookService.getAllMasterBookFormat());

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Book-update.jsp");
			requestDispatcher.forward(request, response);
		} catch (ApplicationException e) {
			request.setAttribute(Constant.ERROR, e.getMessage());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Errorpage.jsp");
			requestDispatcher.forward(request, response);

		}
	}
}
