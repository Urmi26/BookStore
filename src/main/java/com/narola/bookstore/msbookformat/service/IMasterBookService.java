package com.narola.bookstore.msbookformat.service;

import java.util.List;
import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.msbookformat.model.MasterBookFormat;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IMasterBookService {
	
	List<MasterBookFormat> getAllMasterBookData() throws ApplicationException;
	
	void addMasterBookFormat(String msbookformatName,HttpServletRequest request, HttpServletResponse response) throws ApplicationException;
	
	void deleteMasterBookFormat(int msBookId, HttpServletRequest request, HttpServletResponse response) throws ApplicationException;
	
	List<MasterBookFormat> searchMasterBookByName(String msBookName) throws ApplicationException;
	
	void updateMasterBookFormat(MasterBookFormat masterBookFormat, HttpServletRequest request, HttpServletResponse response) throws ApplicationException;
	
	MasterBookFormat getUpdateDataFetchOfMsBookId(int msBookId) throws ApplicationException;

}
