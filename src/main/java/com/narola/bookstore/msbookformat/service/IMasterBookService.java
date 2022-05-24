package com.narola.bookstore.msbookformat.service;

import java.util.List;
import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.msbookformat.model.MasterBookFormat;
import jakarta.servlet.http.HttpServletRequest;

public interface IMasterBookService {

	List<MasterBookFormat> getAllMasterBookData() throws ApplicationException;

	void addMasterBookFormat(String msbookformatName, HttpServletRequest request) throws ApplicationException;

	void deleteMasterBookFormat(int msBookId, HttpServletRequest request) throws ApplicationException;

	List<MasterBookFormat> searchMasterBookByName(String msBookName) throws ApplicationException;

	void updateMasterBookFormat(MasterBookFormat masterBookFormat, HttpServletRequest request)
			throws ApplicationException;

	MasterBookFormat getUpdateDataFetchOfMsBookId(int msBookId) throws ApplicationException;

}
