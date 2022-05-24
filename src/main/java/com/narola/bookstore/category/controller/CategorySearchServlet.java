package com.narola.bookstore.category.controller;

import java.io.IOException;
import com.narola.bookstore.category.service.ICategoryService;
import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.utility.Constant;
import com.narola.bookstore.utility.ServiceFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CategorySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ICategoryService iCategoryService = ServiceFactory.getInstence().getCategoryService();
			String categoryName = request.getParameter("categoryName");
			if (categoryName == null || categoryName.isEmpty()) {
				throw new ApplicationException("Category Name cann't be empty");
			} else {
				request.setAttribute("listOfCategory", iCategoryService.searchCategorys(categoryName));
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Category-view.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute(Constant.ERROR, e.getMessage());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Errorpage.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
