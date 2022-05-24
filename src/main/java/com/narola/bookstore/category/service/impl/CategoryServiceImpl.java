package com.narola.bookstore.category.service.impl;

import java.io.IOException;
import java.util.List;
import com.narola.bookstore.category.dao.ICategoryDAO;
import com.narola.bookstore.category.model.Categorry;
import com.narola.bookstore.category.service.ICategoryService;
import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.exception.DatabaseException;
import com.narola.bookstore.utility.Constant;
import com.narola.bookstore.utility.DAOFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CategoryServiceImpl implements ICategoryService {

	@Override
	public void addCategory(String categoryName, HttpServletRequest request, HttpServletResponse response) {
		try {
			ICategoryDAO categoryDAO = DAOFactory.getInstence().getCategoryDAO();
			int status = categoryDAO.insertQry(categoryName);
			if (status > 0) {
				response.sendRedirect(request.getContextPath() + Constant.CATEGORY_DISPLAY_URL);
			} else {
				throw new ApplicationException("Sorry, Category Data is not saved.");
			}
		} catch (DatabaseException | IOException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	@Override
	public void deleteCategory(int categoryId, HttpServletRequest req, HttpServletResponse res) {
		try {
			ICategoryDAO categoryDAO = DAOFactory.getInstence().getCategoryDAO();
			int status = categoryDAO.deleleQry(categoryId);

			if (status > 0) {
				res.sendRedirect(req.getContextPath() + Constant.CATEGORY_DISPLAY_URL);
			} else {
				throw new ApplicationException("Record can't deleted");
			}
		} catch (DatabaseException | IOException e) {
			throw new ApplicationException("oops, Exception when deleting data.", e);
		}
	}

	@Override
	public List<Categorry> searchCategorys(String categoryName) {
		try {
			ICategoryDAO categoryDAO = DAOFactory.getInstence().getCategoryDAO();
			return categoryDAO.searchByCategoryName(categoryName);
		} catch (Exception e) {
			throw new ApplicationException("oops, Exception when Search Category data.", e);
		}
	}

	@Override
	public List<Categorry> getAllCategoryDetails() {
		try {
			ICategoryDAO categoryDAO = DAOFactory.getInstence().getCategoryDAO();
			return categoryDAO.getAllCategorry();
		} catch (Exception e) {
			throw new ApplicationException("oops, Exception when all Category Details.", e);
		}
	}

	@Override
	public Categorry getUpdateDataFetchByID(int categoryId) {
		try {
			ICategoryDAO categoryDAO = DAOFactory.getInstence().getCategoryDAO();
			return categoryDAO.getUpdateDataFetchById(categoryId);
		} catch (Exception e) {
			throw new ApplicationException("oops, Exception when Data fetching", e);
		}
	}

	@Override
	public void updateCategoryData(Categorry category, HttpServletRequest request, HttpServletResponse response) {
		try {
			ICategoryDAO categoryDAO = DAOFactory.getInstence().getCategoryDAO();
			int status = categoryDAO.updateQry(category);
			if (status > 0) {
				response.sendRedirect(request.getContextPath() + Constant.CATEGORY_DISPLAY_URL);
			} else {
				throw new ApplicationException("record cann't updated..");
			}
		} catch (Exception e) {
			throw new ApplicationException("oops, Exception when update category data", e);
		}
	}

}
