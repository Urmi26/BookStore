package com.narola.bookstore.category.controller;

import java.io.IOException;
import com.narola.bookstore.category.service.ICategoryService;
import com.narola.bookstore.utility.Constant;
import com.narola.bookstore.utility.ServiceFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CategoryDeleteActionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			ICategoryService iCategoryService = ServiceFactory.getInstence().getCategoryService();
			iCategoryService.deleteCategory(Integer.parseInt(req.getParameter("categoryId")), req);
			res.sendRedirect(req.getContextPath() + Constant.CATEGORY_DISPLAY_URL);
		} catch (Exception e) {
			req.setAttribute(Constant.ERROR, e.getMessage());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Errorpage.jsp");
			requestDispatcher.forward(req, res);
		}
	}
}
