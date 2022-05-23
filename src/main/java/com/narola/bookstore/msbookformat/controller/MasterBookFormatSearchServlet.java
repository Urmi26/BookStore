package com.narola.bookstore.msbookformat.controller;

import java.io.IOException;
import java.util.List;
import com.narola.bookstore.msbookformat.model.MasterBookFormat;
import com.narola.bookstore.msbookformat.service.IMasterBookService;
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
			List<MasterBookFormat> searchMasterBookName = iMasterBookService
					.searchMasterBookByName(request.getParameter("msBookName"));

			request.setAttribute("listOfMasterBook", searchMasterBookName);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Master-book-view.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("ErrorMessage", e.getMessage());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Master-book-search.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
