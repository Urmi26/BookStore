package com.narola.bookstore.msbookformat.controller;

import java.io.IOException;
import com.narola.bookstore.msbookformat.model.MasterBookFormat;
import com.narola.bookstore.msbookformat.service.IMasterBookService;
import com.narola.bookstore.utility.ServiceFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MasterBookFormatUpdateActionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String msBookName = request.getParameter("msBookName");
			int msBookId = Integer.parseInt(request.getParameter("msBookId"));
			
			if (msBookName == null || msBookName.trim().isEmpty()) {
				request.setAttribute("errorMsg", "Please enter valid category name");
				request.setAttribute("MasterBook", new MasterBookFormat(Integer.parseInt(msBookName)));
				RequestDispatcher rd = request.getRequestDispatcher("Master-book-update.jsp");
				rd.forward(request, response);
				
			} else {
				IMasterBookService iMasterBookService = ServiceFactory.getInstence().getMasterBookFormatService();
				MasterBookFormat masterBookFormat = new MasterBookFormat(msBookId, msBookName);
				iMasterBookService.updateMasterBookFormat(masterBookFormat, request, response);
				
			}
		} catch (Exception e) {
			request.setAttribute("ErrorMessage", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("Master-book-update.jsp");
			rd.forward(request, response);
		}

	}

}
