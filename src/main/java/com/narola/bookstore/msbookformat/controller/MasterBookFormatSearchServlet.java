package com.narola.bookstore.msbookformat.controller;

import java.io.IOException;
import java.util.List;

import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.msbookformat.model.MasterBookFormat;
import com.narola.bookstore.msbookformat.service.IMasterBookService;
import com.narola.bookstore.utility.Constant;
import com.narola.bookstore.utility.ServiceFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MasterBookFormatSearchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			IMasterBookService iMasterBookService = ServiceFactory.getInstence().getMasterBookFormatService();
			String msBookName = request.getParameter("msBookName");
			if (msBookName == null || msBookName.isEmpty()) {
				throw new ApplicationException("Master Book Name can't be empty");
			} else {
				List<MasterBookFormat> searchMasterBookName = iMasterBookService.searchMasterBookByName(msBookName);
				request.setAttribute("listOfMasterBook", searchMasterBookName);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Master-book-view.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute(Constant.ERROR, e.getMessage());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Errorpage.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
