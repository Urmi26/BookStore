package com.narola.bookstore.msbookformat.controller;

import java.io.IOException;

import com.narola.bookstore.msbookformat.service.IMasterBookService;
import com.narola.bookstore.utility.ServiceFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MasterBookFormatAddActionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			IMasterBookService iMasterBookService = ServiceFactory.getInstence().getMasterBookFormatService();
			iMasterBookService.addMasterBookFormat(request.getParameter("msBookName"), request, response);
		} catch (Exception e) {
			request.setAttribute("ErrorMessage", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("Master-book-form.jsp");
			rd.forward(request, response);
		}
	}

}
