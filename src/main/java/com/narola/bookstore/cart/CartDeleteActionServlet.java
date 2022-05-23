package com.narola.bookstore.cart;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CartDeleteActionServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cartId = request.getParameter("cartId");
 		int cartID = Integer.parseInt(cartId);
		int status = CartDAO.deleteQry(cartID);
		if (status > 0) {
			System.out.println("Record Deleted...");
			response.sendRedirect(request.getContextPath() + "/DisplaySelectedBook");
		} else {
			System.out.println("Record can't deleted");
		}
	}

}
