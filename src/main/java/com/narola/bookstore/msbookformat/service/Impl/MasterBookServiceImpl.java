package com.narola.bookstore.msbookformat.service.Impl;

import java.util.List;
import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.exception.DatabaseException;
import com.narola.bookstore.msbookformat.dao.IMasterBookFormatDAO;
import com.narola.bookstore.msbookformat.model.MasterBookFormat;
import com.narola.bookstore.msbookformat.service.IMasterBookService;
import com.narola.bookstore.utility.DAOFactory;
import jakarta.servlet.http.HttpServletRequest;

public class MasterBookServiceImpl implements IMasterBookService {

	@Override
	public List<MasterBookFormat> getAllMasterBookData() throws ApplicationException {
		try {
			IMasterBookFormatDAO masterBookFormatDAO = DAOFactory.getInstence().getMasterBookFormatDAO();
			return masterBookFormatDAO.getAllMSBook();
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Something went wrong.. ", e);
		}
	}

	@Override
	public void addMasterBookFormat(String msbookformatName, HttpServletRequest request) throws ApplicationException {
		try {
			IMasterBookFormatDAO masterBookFormatDAO = DAOFactory.getInstence().getMasterBookFormatDAO();
			masterBookFormatDAO.insertQry(msbookformatName);
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Something went wrong.. ", e);
		}
	}

	@Override
	public void deleteMasterBookFormat(int msBookId, HttpServletRequest request) throws ApplicationException {
		try {
			IMasterBookFormatDAO masterBookFormatDAO = DAOFactory.getInstence().getMasterBookFormatDAO();
			masterBookFormatDAO.deleteQry(msBookId);
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Something went wrong.. ", e);
		}
	}

	@Override
	public List<MasterBookFormat> searchMasterBookByName(String msBookName) throws ApplicationException {
		try {
			IMasterBookFormatDAO masterBookFormatDAO = DAOFactory.getInstence().getMasterBookFormatDAO();
			return masterBookFormatDAO.searchMasterBookName(msBookName);

		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Something went wrong.. ", e);
		}
	}

	@Override
	public void updateMasterBookFormat(MasterBookFormat masterBookFormat, HttpServletRequest request)
			throws ApplicationException {
		try {
			IMasterBookFormatDAO masterBookFormatDAO = DAOFactory.getInstence().getMasterBookFormatDAO();
			masterBookFormatDAO.updateQry(masterBookFormat);
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Something went wrong.. ", e);
		}
	}

	@Override
	public MasterBookFormat getUpdateDataFetchOfMsBookId(int msBookId) throws ApplicationException {
		try {
			IMasterBookFormatDAO masterBookFormatDAO = DAOFactory.getInstence().getMasterBookFormatDAO();
			return masterBookFormatDAO.updateOfDataFetchQry(msBookId);
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Something went wrong.. ", e);
		}
	}

}
