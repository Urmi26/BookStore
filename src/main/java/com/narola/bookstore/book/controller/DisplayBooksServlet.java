package com.narola.bookstore.book.controller;

import java.io.IOException;
import com.narola.bookstore.book.service.IBookService;
import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.utility.ServiceFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DisplayBooksServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		try {
			IBookService iBookService = ServiceFactory.getInstence().getBookService();
			request.setAttribute("listOfBook", iBookService.getListOfBooks());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Book-List.jsp");
			requestDispatcher.forward(request, response);
		} catch (ApplicationException e) {
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Book-List.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}