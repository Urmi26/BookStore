package com.narola.bookstore.user;

import java.io.IOException;
import com.narola.bookstore.book.service.IBookService;
import com.narola.bookstore.book.service.Impl.BookServiceImpl;
import com.narola.bookstore.exception.ApplicationException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			IBookService iBookService = new BookServiceImpl();
			String emailId = request.getParameter("email");
			String password = request.getParameter("password");
			boolean isErrorMsg = false;

			if (emailId == null) {
				request.setAttribute("errorMsgOfEmailId", "Please Enter valid emailId");
				isErrorMsg = true;
			}
			if (password == null) {
				request.setAttribute("errorMsgOfPassword", "Please Enter valid password");
				isErrorMsg = true;
			}

			if (isErrorMsg) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(request, response);
			} else {

				User user = UserDAO.checkUserIdandPassword(emailId, password);
				if (user != null) {

					HttpSession session = request.getSession();
					session.setAttribute("user", user);

					if (user.getUserType() == 1) {
						request.setAttribute("listOfCategory", iBookService.getAllCategory());
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomePage.jsp");
						requestDispatcher.forward(request, response);
					} else if (user.getUserType() == 2) {
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdminHomePage.jsp");
						requestDispatcher.forward(request, response);
					}

				} else {
					request.setAttribute("errorMsgOfData", "Please Enter valid data, Your data has been not match !!");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
					requestDispatcher.forward(request, response);
					throw new ApplicationException("Data isn't Match ");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
