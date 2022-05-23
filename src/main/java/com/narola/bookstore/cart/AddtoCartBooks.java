package com.narola.bookstore.cart;

import java.io.IOException;
import com.narola.bookstore.user.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddtoCartBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String bookId = request.getParameter("bookId");
		HttpSession session=request.getSession(false);
		User user = (User) session.getAttribute("user");
		int userId=user.getUserId();
				
		int qty = CartDAO.checkbookselectedOrnot(Integer.parseInt(bookId));
		System.out.println(qty);
		int status=0;
		if(qty==0)
		{
			status = CartDAO.insetQry(Integer.parseInt(bookId),userId);	
		}else {
			status = CartDAO.updateQry(Integer.parseInt(bookId), qty + 1);
		}
		if(status>0)
		{
			response.sendRedirect(request.getContextPath() + "/DisplaySelectedBook");
		}else {
			System.out.println("record can't inserted");
		}
		
	}
}
