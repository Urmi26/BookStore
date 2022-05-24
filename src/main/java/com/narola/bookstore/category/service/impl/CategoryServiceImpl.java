package com.narola.bookstore.category.service.impl;

import java.util.List;
import com.narola.bookstore.category.dao.ICategoryDAO;
import com.narola.bookstore.category.model.Categorry;
import com.narola.bookstore.category.service.ICategoryService;
import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.exception.DatabaseException;
import com.narola.bookstore.utility.DAOFactory;
import jakarta.servlet.http.HttpServletRequest;

public class CategoryServiceImpl implements ICategoryService {

	@Override
	public void addCategory(String categoryName, HttpServletRequest request) {
		try {
			ICategoryDAO categoryDAO = DAOFactory.getInstence().getCategoryDAO();
			categoryDAO.insertQry(categoryName);
		} catch (DatabaseException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	@Override
	public void deleteCategory(int categoryId, HttpServletRequest req) {
		try {
			ICategoryDAO categoryDAO = DAOFactory.getInstence().getCategoryDAO();
			categoryDAO.deleleQry(categoryId);
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Exception when deleting data.", e);
		}
	}

	@Override
	public List<Categorry> searchCategorys(String categoryName) {
		try {
			ICategoryDAO categoryDAO = DAOFactory.getInstence().getCategoryDAO();
			return categoryDAO.searchByCategoryName(categoryName);
		} catch (Exception e) {
			throw new ApplicationException("Oops, Exception when Search Category data.", e);
		}
	}

	@Override
	public List<Categorry> getAllCategoryDetails() {
		try {
			ICategoryDAO categoryDAO = DAOFactory.getInstence().getCategoryDAO();
			return categoryDAO.getAllCategorry();
		} catch (Exception e) {
			throw new ApplicationException("Oops, Exception when all Category Details.", e);
		}
	}

	@Override
	public Categorry getUpdateDataFetchByID(int categoryId) {
		try {
			ICategoryDAO categoryDAO = DAOFactory.getInstence().getCategoryDAO();
			return categoryDAO.getUpdateDataFetchById(categoryId);
		} catch (Exception e) {
			throw new ApplicationException("Oops, Exception when Data fetching", e);
		}
	}

	@Override
	public void updateCategoryData(Categorry category, HttpServletRequest request) {
		try {
			ICategoryDAO categoryDAO = DAOFactory.getInstence().getCategoryDAO();
			categoryDAO.updateQry(category);
		} catch (Exception e) {
			throw new ApplicationException("Oops, Exception when update category data", e);
		}
	}

}
