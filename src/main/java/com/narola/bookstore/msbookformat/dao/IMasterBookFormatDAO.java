package com.narola.bookstore.msbookformat.dao;

import java.util.List;

import com.narola.bookstore.exception.DatabaseException;
import com.narola.bookstore.msbookformat.model.MasterBookFormat;

public interface IMasterBookFormatDAO {

	List<MasterBookFormat> getAllMSBook() throws DatabaseException;

	int insertQry(String msbookformatName) throws DatabaseException;

	int deleteQry(int msBookId) throws DatabaseException;

	int updateQry(MasterBookFormat masterBookFormat) throws DatabaseException;

	MasterBookFormat updateOfDataFetchQry(int msBookId) throws DatabaseException;

	List<MasterBookFormat> searchMasterBookName(String msBookName) throws DatabaseException;

}
