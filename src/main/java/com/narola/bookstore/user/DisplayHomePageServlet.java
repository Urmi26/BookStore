package com.narola.bookstore.user;

import java.io.IOException;
import com.narola.bookstore.book.service.IBookService;
import com.narola.bookstore.utility.Constant;
import com.narola.bookstore.utility.ServiceFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DisplayHomePageServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			IBookService iBookService =  ServiceFactory.getInstence().getBookService();
			request.setAttribute("listOfCategory", iBookService.getAllCategory());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomePage.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			request.setAttribute(Constant.ERROR, e.getMessage());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Errorpage.jsp");
			requestDispatcher.forward(request, response);
		}
	}


}
