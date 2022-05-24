package com.narola.bookstore.msbookformat.service.Impl;

import java.io.IOException;
import java.util.List;
import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.exception.DatabaseException;
import com.narola.bookstore.msbookformat.dao.IMasterBookFormatDAO;
import com.narola.bookstore.msbookformat.model.MasterBookFormat;
import com.narola.bookstore.msbookformat.service.IMasterBookService;
import com.narola.bookstore.utility.Constant;
import com.narola.bookstore.utility.DAOFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MasterBookServiceImpl implements IMasterBookService {

	@Override
	public List<MasterBookFormat> getAllMasterBookData() throws ApplicationException {
		try {
			IMasterBookFormatDAO masterBookFormatDAO = DAOFactory.getInstence().getMasterBookFormatDAO();
			return masterBookFormatDAO.getAllMSBook();
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops,Something went wrong..", e);
		}
	}

	@Override
	public void addMasterBookFormat(String msbookformatName, HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {
		try {
			IMasterBookFormatDAO masterBookFormatDAO = DAOFactory.getInstence().getMasterBookFormatDAO();
			int status = masterBookFormatDAO.insertQry(msbookformatName);

			if (status > 0) {
				response.sendRedirect(request.getContextPath() + Constant.MASTER_BOOK_FORMAT_DISPLAY_URL);
			} else {
				throw new ApplicationException("Data con't be submited");
			}
		} catch (IOException | DatabaseException e) {
			throw new ApplicationException("Oops,Something went wrong..", e);
		}
	}

	@Override
	public void deleteMasterBookFormat(int msBookId, HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {
		try {
			IMasterBookFormatDAO masterBookFormatDAO = DAOFactory.getInstence().getMasterBookFormatDAO();
			int status = masterBookFormatDAO.deleteQry(msBookId);

			if (status > 0) {
				response.sendRedirect(request.getContextPath() + Constant.MASTER_BOOK_FORMAT_DISPLAY_URL);
			} else {
				throw new ApplicationException("Data can't be deleted..");
			}
		} catch (IOException | DatabaseException e) {
			throw new ApplicationException("Oops,Something went wrong..", e);
		}
	}

	@Override
	public List<MasterBookFormat> searchMasterBookByName(String msBookName) throws ApplicationException {
		try {
			IMasterBookFormatDAO masterBookFormatDAO = DAOFactory.getInstence().getMasterBookFormatDAO();
			return masterBookFormatDAO.searchMasterBookName(msBookName);

		} catch (DatabaseException e) {
			throw new ApplicationException("Oops,Something went wrong..", e);
		}
	}

	@Override
	public void updateMasterBookFormat(MasterBookFormat masterBookFormat, HttpServletRequest request,
			HttpServletResponse response) throws ApplicationException {
		try {
			IMasterBookFormatDAO masterBookFormatDAO = DAOFactory.getInstence().getMasterBookFormatDAO();
			int status = masterBookFormatDAO.updateQry(masterBookFormat);
			if (status > 0) {
				response.sendRedirect(request.getContextPath() + Constant.MASTER_BOOK_FORMAT_DISPLAY_URL);
			} else {
				throw new ApplicationException("Data can't be updated");
			}
		} catch (IOException | DatabaseException e) {
			throw new ApplicationException("Oops,Something went wrong..", e);
		}
	}

	@Override
	public MasterBookFormat getUpdateDataFetchOfMsBookId(int msBookId) throws ApplicationException {
		try {
			IMasterBookFormatDAO masterBookFormatDAO = DAOFactory.getInstence().getMasterBookFormatDAO();
			return masterBookFormatDAO.updateOfDataFetchQry(msBookId);
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops,Something went wrong..", e);
		}
	}

}
