package com.narola.bookstore.user;

import java.io.IOException;
import com.narola.bookstore.book.service.IBookService;
import com.narola.bookstore.book.service.Impl.BookServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserPlaceOrderFromServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			IBookService iBookService = new BookServiceImpl();
			int items = Integer.parseInt(request.getParameter("totalItemsOfPlaceOrder"));
			String totalAmount = request.getParameter("totalAmountOfPlaceOrder");

			request.setAttribute("listOfCategory", iBookService.getAllCategory());
			request.setAttribute("Items", items);
			request.setAttribute("TotalAmount", totalAmount);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Place-Order.jsp");
			requestDispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Place-Order.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
