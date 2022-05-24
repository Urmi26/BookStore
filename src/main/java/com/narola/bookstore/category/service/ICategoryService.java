package com.narola.bookstore.category.service;

import java.util.List;
import com.narola.bookstore.category.model.Categorry;
import com.narola.bookstore.exception.ApplicationException;
import jakarta.servlet.http.HttpServletRequest;

public interface ICategoryService {

	void addCategory(String categoryName, HttpServletRequest request) throws ApplicationException;

	void deleteCategory(int categoryId, HttpServletRequest req) throws ApplicationException;

	List<Categorry> searchCategorys(String categoryName) throws ApplicationException;

	List<Categorry> getAllCategoryDetails() throws ApplicationException;

	Categorry getUpdateDataFetchByID(int categoryId) throws ApplicationException;

	void updateCategoryData(Categorry category, HttpServletRequest request) throws ApplicationException;
}
