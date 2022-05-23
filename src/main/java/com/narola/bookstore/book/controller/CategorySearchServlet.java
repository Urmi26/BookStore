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

public class CategorySearchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			IBookService iBookService = ServiceFactory.getInstence().getBookService();
			String categoryId = request.getParameter("categoryId");
			if (categoryId == null || categoryId.isEmpty()) {
				throw new ApplicationException("Data isn't match");
		
			} else {
				request.setAttribute("listOfBook", iBookService.searchCategoryById(Integer.parseInt(categoryId)));
				request.setAttribute("listOfCategory", iBookService.getAllCategory());
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Book-Records.jsp");
				requestDispatcher.forward(request, response);
			}

		} catch (ApplicationException e) {
			request.setAttribute("ErrorMessage", e.getMessage());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Book-Search.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
