package com.narola.bookstore.msbookformat.validation;

import com.narola.bookstore.msbookformat.model.MasterBookFormat;
import com.narola.bookstore.utility.Constant;
import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class MSBookFormatValidationFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain arg3)
			throws IOException, ServletException {
		System.out.println("In MSBookFormatValidationFilter");
		String msBookName = req.getParameter("msBookName");
		HttpServletRequest request = (HttpServletRequest) req;
		String url = request.getRequestURI();
		boolean isErrorExist = false;

		if (msBookName == null || msBookName.trim().isEmpty()) {
			req.setAttribute("errorMsgOfMsBookName", "Please enter valid master book name");
			isErrorExist = true;
		}
		if (url.equals(request.getContextPath() + Constant.MASTER_BOOK_FORMAT_UPDATE_URL)) {
			String msBookID = req.getParameter("msBookId");

			if (msBookID == null || msBookID.trim().isEmpty() || Integer.parseInt(msBookID) == 0) {
				req.setAttribute("errorMsgOfMsBookId", "Please check your Master Book ID");
				isErrorExist = true;
			}
		}

		if (isErrorExist) {
			if (url.equals(request.getContextPath() + Constant.MASTER_BOOK_FORMAT_ADD_URL)) {
				RequestDispatcher rd = req.getRequestDispatcher("Master-book-form.jsp");
				rd.forward(req, resp);
			}
			if (url.equals(request.getContextPath() + Constant.MASTER_BOOK_FORMAT_UPDATE_URL)) {
				int msBookId = 0;
				String msBookID = req.getParameter("msBookId");
				if (msBookID != null && !msBookID.trim().isEmpty() && Integer.parseInt(msBookID) != 0) {
					msBookId = Integer.parseInt(msBookID);
				}
				req.setAttribute("MasterBook", new MasterBookFormat(msBookId));
				RequestDispatcher rd = req.getRequestDispatcher("Master-book-update.jsp");
				rd.forward(req, resp);
			}
		} else {
			arg3.doFilter(req, resp);
		}
	}
}