package com.narola.bookstore.cart;

import java.io.IOException;

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
			String cartId=request.getParameter("cartId");
			String quantity=request.getParameter("quantity");
			
			int status=CartDAO.updateQry(Integer.parseInt(cartId), Integer.parseInt(quantity));
			if (status > 0) {
				System.out.println("Updated..");
				response.sendRedirect(request.getContextPath() + "/DisplaySelectedBook");
			} else {
				System.out.println("record cann't updated..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
