package com.narola.bookstore.user;

import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.utility.Constant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String emailId = request.getParameter("emailId");
			Matcher m2 = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(emailId);
			String no = "1";
			boolean isErrorExist = false;
			int randomcode;

			if (emailId == null || emailId.trim().isEmpty() || !m2.matches()) {
				request.setAttribute("errorMsgOfEmail", "Please enter valid E-mail");
				isErrorExist = true;
			}

			if (isErrorExist) {
				request.setAttribute("No", no);
				RequestDispatcher rd = request.getRequestDispatcher("Sign_Up.jsp");
				rd.forward(request, response);
			} else {
				Random rand = new Random();
				randomcode = rand.nextInt(999999);
				System.out.println(randomcode);
				int status = UserDAO.insertQry(emailId, randomcode);

				if (status > 0) {
					no = no.concat("2");
					request.setAttribute("No", no);
					request.setAttribute("emailId", emailId);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("Sign_up.jsp");
					requestDispatcher.forward(request, response);
				} else {
					throw new ApplicationException("Your data has been not submitted");
				}
			}
		} catch (Exception e) {
			request.setAttribute(Constant.ERROR, e.getMessage());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Sign_up.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
