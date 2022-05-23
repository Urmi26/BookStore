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

public class CategoryUpdateActionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ICategoryService iCategoryService = ServiceFactory.getInstence().getCategoryService();
			String categoryId = request.getParameter("categoryId");
			int categoryID = Integer.parseInt(categoryId);
			String categoryName = request.getParameter("categoryName");
			Categorry category = new Categorry(categoryID, categoryName);
			
			iCategoryService.updateCategoryData(category, request, response);

		} catch (Exception e) {
			request.setAttribute("ErrorMessage", e.getMessage());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Category-update.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
