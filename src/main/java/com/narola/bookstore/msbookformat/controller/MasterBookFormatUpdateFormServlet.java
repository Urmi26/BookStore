package com.narola.bookstore.msbookformat.controller;

import java.io.IOException;

import com.narola.bookstore.msbookformat.service.IMasterBookService;
import com.narola.bookstore.utility.ServiceFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MasterBookFormatUpdateFormServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			IMasterBookService iMasterBookService = ServiceFactory.getInstence().getMasterBookFormatService();
			String msBookID = request.getParameter("msBookId");
			int msBookId = Integer.parseInt(msBookID);
			request.setAttribute("MasterBook", iMasterBookService.getUpdateDataFetchOfMsBookId(msBookId));
			RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath() + "/DisplayMSBooks");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("Master-book-list.jsp");
			rd.forward(request, response);
		}
	}

}
