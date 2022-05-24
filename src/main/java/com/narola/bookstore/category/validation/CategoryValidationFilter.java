package com.narola.bookstore.category.validation;

import com.narola.bookstore.category.model.Categorry;
import com.narola.bookstore.utility.Constant;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class CategoryValidationFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain arg1)
			throws IOException, ServletException {
		System.out.println("InFilter");
		String categoryName = req.getParameter("categoryName");
		HttpServletRequest request = (HttpServletRequest) req;
		String url = request.getRequestURI();
		boolean isErrorExist = false;

		if (categoryName == null || categoryName.trim().isEmpty()) {
			req.setAttribute("errorMsgCategoryName", "Please enter valid category name");
			isErrorExist = true;
		}
		if (url.equals(request.getContextPath() + Constant.CATEGORY_UPDATE_URL)) {
			String categoryId = req.getParameter("categoryId");
			if (categoryId == null || categoryId.trim().isEmpty() || Integer.parseInt(categoryId) == 0) {
				req.setAttribute("errorMsgCategoryId", "Please Check your category Id is null");
				isErrorExist = true;
			}
		}
		if (isErrorExist) {
			if (url.equals(request.getContextPath() + Constant.CATEGORY_ADD_URL)) {
				RequestDispatcher rd = req.getRequestDispatcher("Category-form.jsp");
				rd.forward(req, resp);
			}
			if (url.equals(request.getContextPath() + Constant.CATEGORY_UPDATE_URL)) {
				int categoryId = 0;
				String categoryID = req.getParameter("categoryId");
				if (categoryID != null && !categoryID.trim().isEmpty() && Integer.parseInt(categoryID) != 0) {
					categoryId = Integer.parseInt(categoryID);
				}
				req.setAttribute("category", new Categorry(categoryId));
				RequestDispatcher rd = req.getRequestDispatcher("Category-update.jsp");
				rd.forward(req, resp);
			}
		} else {
			arg1.doFilter(req, resp);
		}
	}

}
