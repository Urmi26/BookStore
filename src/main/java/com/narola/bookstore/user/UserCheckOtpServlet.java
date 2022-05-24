package com.narola.bookstore.user;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.narola.bookstore.book.service.IBookService;
import com.narola.bookstore.book.service.Impl.BookServiceImpl;
import com.narola.bookstore.exception.ApplicationException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserCheckOtpServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			IBookService iBookService = new BookServiceImpl();
			String userID = request.getParameter("userId");
			if (userID == null || userID.trim().isEmpty()) {
				String otpstr = request.getParameter("otp");
				String emailId = request.getParameter("email");
				String no = "12";
				boolean isErrorExist = false;

				if (otpstr == null || otpstr.trim().isEmpty()) {
					request.setAttribute("errorMsgOfOtp", "Please enter valid OTP");
					isErrorExist = true;
				}

				if (isErrorExist) {
					request.setAttribute("No", no);
					RequestDispatcher rd = request.getRequestDispatcher("Sign_up.jsp");
					rd.forward(request, response);
				} else {
					try {
						int otp = Integer.parseInt(otpstr);
						int userId = UserDAO.userCheckOtp(emailId, otp);

						if (userId > 0) {
							no = no.concat("3");
							request.setAttribute("userId", userId);
							request.setAttribute("No", no);
							RequestDispatcher requestDispatcher = request.getRequestDispatcher("Sign_up.jsp");
							requestDispatcher.forward(request, response);
						} else {
							throw new ApplicationException("Your data has been not submitted");
						}
					} catch (ApplicationException e) {
						e.printStackTrace();
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("Sign_up.jsp");
						requestDispatcher.forward(request, response);
					}
				}
			} else {
				String password = request.getParameter("password");
				String pwd = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,8}$";
				Pattern pattern3 = Pattern.compile(pwd);
				Matcher m3 = pattern3.matcher(password);
				boolean isErrorExist = false;

				if (password == null || password.trim().isEmpty() || !m3.matches()) {
					request.setAttribute("errorMsgOfPassword", "Please enter valid Password");
					isErrorExist = true;
				}

				if (isErrorExist) {
					request.setAttribute("No", "123");
					RequestDispatcher rd = request.getRequestDispatcher("Sign_up.jsp");
					rd.forward(request, response);
				} else {

					int status = UserDAO.updateQryOfPassword(Integer.parseInt(userID), password);
					if (status > 0) {
						request.setAttribute("listOfCategory", iBookService.getAllCategory());
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomePage.jsp");
						requestDispatcher.forward(request, response);
					} else {
						throw new ApplicationException("Your data has been not Updatted");
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Sign_up.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
