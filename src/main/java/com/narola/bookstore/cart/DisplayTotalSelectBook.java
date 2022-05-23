package com.narola.bookstore.cart;

import java.io.IOException;
import java.util.List;
import com.narola.bookstore.book.service.IBookService;
import com.narola.bookstore.book.service.Impl.BookServiceImpl;
import com.narola.bookstore.user.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DisplayTotalSelectBook extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IBookService iBookService = new BookServiceImpl();

		try {
			HttpSession session = request.getSession(true);
			User user = (User) session.getAttribute("user");

			if (user == null) {
				String Message = "Your Shopping Cart is currently empty. To add Books in your Shopping Cart, start by searching or browsing through our "
						+ "book store. When a book interests you, click on Add to Cart button. Books in Shopping Cart always reflect the most recent price, displayed "
						+ "on their product pages.";

				request.setAttribute("isMessage", Message);
			} else {
				int userId = user.getUserId();
				List<Cart> listOfSelectedBook = CartDAO.getAllSelectedBooks(userId);
				request.setAttribute("listOfSelectedBook", listOfSelectedBook);
			}

			request.setAttribute("listOfCategory", iBookService.getAllCategory());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Add-To-Cart.jsp");
			requestDispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
