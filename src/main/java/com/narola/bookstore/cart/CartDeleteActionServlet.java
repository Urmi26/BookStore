package com.narola.bookstore.cart;

import java.io.IOException;

import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.utility.Constant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CartDeleteActionServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cartId = request.getParameter("cartId");
		try {
			int cartID = Integer.parseInt(cartId);
			int status = CartDAO.deleteQry(cartID);
			if (status > 0) {
				response.sendRedirect(request.getContextPath() + Constant.BOOK_DISPLAY_SELECTED_URL);
			} else {
				throw new ApplicationException("Record can't deleted");
			}
		} catch (ApplicationException e) {
			request.setAttribute(Constant.ERROR, e.getMessage());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Add-To-Cart.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
