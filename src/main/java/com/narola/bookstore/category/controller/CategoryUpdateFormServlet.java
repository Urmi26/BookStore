package com.narola.bookstore.category.controller;

import java.io.IOException;
import com.narola.bookstore.category.model.Categorry;
import com.narola.bookstore.category.service.ICategoryService;
import com.narola.bookstore.utility.ServiceFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CategoryUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ICategoryService iCategoryService = ServiceFactory.getInstence().getCategoryService();
			Categorry categorry = iCategoryService.getUpdateDataFetchByID(Integer.parseInt(request.getParameter("categoryId")));
			request.setAttribute("category", categorry);
			RequestDispatcher rd = request.getRequestDispatcher("Category-update.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Category-list.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
