package com.narola.bookstore.user;

import java.io.IOException;
import com.narola.bookstore.book.service.IBookService;
import com.narola.bookstore.book.service.Impl.BookServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserUpdateFromServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			IBookService iBookService = new BookServiceImpl();
			HttpSession session = request.getSession(true);
			User user = (User) session.getAttribute("user");
			int userId = user.getUserId();

			User user1 = UserDAO.getUserByID(userId);

			request.setAttribute("listOfCategory", iBookService.getAllCategory());
			request.setAttribute("userForm", user1);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("User-update.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
