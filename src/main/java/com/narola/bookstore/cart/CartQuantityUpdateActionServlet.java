package com.narola.bookstore.cart;

import java.io.IOException;

import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.utility.Constant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CartQuantityUpdateActionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			String cartId = request.getParameter("cartId");
			String quantity = request.getParameter("quantity");

			int status = CartDAO.updateQry(Integer.parseInt(cartId), Integer.parseInt(quantity));
			if (status > 0) {
				response.sendRedirect(request.getContextPath() + Constant.BOOK_DISPLAY_SELECTED_URL);
			} else {
				throw new ApplicationException("quantity cann't update..");
			}
		} catch (Exception e) {
			request.setAttribute(Constant.ERROR, e.getMessage());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Add-To-Cart.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
