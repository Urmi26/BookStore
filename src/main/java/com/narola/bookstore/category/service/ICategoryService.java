package com.narola.bookstore.category.service;

import java.util.List;
import com.narola.bookstore.category.model.Categorry;
import com.narola.bookstore.exception.ApplicationException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ICategoryService {

	void addCategory(String categoryName, HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException;

	void deleteCategory(int categoryId, HttpServletRequest req, HttpServletResponse res) throws ApplicationException;

	List<Categorry> searchCategorys(String categoryName) throws ApplicationException;

	List<Categorry> getAllCategoryDetails() throws ApplicationException;

	Categorry getUpdateDataFetchByID(int categoryId) throws ApplicationException;

	void updateCategoryData(Categorry category, HttpServletRequest request, HttpServletResponse response) throws ApplicationException;
}
