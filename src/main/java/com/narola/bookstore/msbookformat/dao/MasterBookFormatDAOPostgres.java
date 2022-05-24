package com.narola.bookstore.msbookformat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.narola.bookstore.exception.DatabaseException;
import com.narola.bookstore.msbookformat.model.MasterBookFormat;
import com.narola.bookstore.utility.DBConnect;

public class MasterBookFormatDAOPostgres implements IMasterBookFormatDAO {

	public List<MasterBookFormat> getAllMSBook() throws DatabaseException {
		List<MasterBookFormat> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Connection con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("SELECT * FROM master_book");
			rs = ps.executeQuery();
			while (rs.next()) {
				int msBookId = rs.getInt("msBookId");
				String msBookName = rs.getString("msBookName");
				Date createdOn = rs.getDate("createdOn");
				Date updatedOn = rs.getDate("updatedOn");

				list.add(new MasterBookFormat(msBookId, msBookName, createdOn, updatedOn));
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when Display Master Book details", e);
		} finally {
			DBConnect.closeResource(ps, rs);
		}
		return list;
	}

	public int insertQry(String msbookformatName) throws DatabaseException {
		Connection con = null;
		PreparedStatement ps = null;
		int status = 0;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("INSERT INTO master_book(msBookName) VALUES(?)");
			ps.setString(1, msbookformatName);
			status = ps.executeUpdate();
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when entering Master Book details", e);
		} finally {
			DBConnect.closeResource(ps);
		}
		return status;
	}

	public int deleteQry(int msBookId) throws DatabaseException {
		int status = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("DELETE FROM master_book WHERE msBookId=?");

			ps.setInt(1, msBookId);
			status = ps.executeUpdate();
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when deleting  Master Book details", e);
		} finally {
			DBConnect.closeResource(ps);
		}
		return status;
	}

	public int updateQry(MasterBookFormat masterBookFormat) throws DatabaseException {
		int status = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("UPDATE master_book SET msBookName=? WHERE msBookId=? ");
			ps.setString(1, masterBookFormat.getMsBookName());
			ps.setInt(2, masterBookFormat.getMsBookId());
			status = ps.executeUpdate();
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when updating Master Book details", e);
		} finally {
			DBConnect.closeResource(ps);
		}
		return status;
	}

	public MasterBookFormat updateOfDataFetchQry(int msBookId) throws DatabaseException {
		Connection con = null;
		PreparedStatement ps = null;
		MasterBookFormat masterBookFormat = null;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("SELECT msBookId,msBookName FROM master_book WHERE msBookId=?");
			ps.setInt(1, msBookId);
			ResultSet rs = ps.executeQuery();
			masterBookFormat = new MasterBookFormat();
			if (rs.next()) {
				masterBookFormat.setMsBookId(rs.getInt(1));
				masterBookFormat.setMsBookName(rs.getString(2));
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when show the Master Book by Id details", e);
		} finally {
			DBConnect.closeResource(ps);
		}
		return masterBookFormat;
	}

	public List<MasterBookFormat> searchMasterBookName(String msBookName) throws DatabaseException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MasterBookFormat> searchMasterBookName = new ArrayList<>();

		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("SELECT * FROM master_book WHERE msBookName =?");
			ps.setString(1, msBookName);
			rs = ps.executeQuery();
			if (rs.next()) {
				int msBookId = rs.getInt(1);
				String msBookname = rs.getString(2);
				Date createdOn = rs.getDate(3);
				Date updatedOn = rs.getDate(4);
				searchMasterBookName.add(new MasterBookFormat(msBookId, msBookname, createdOn, updatedOn));
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when show the  Master Book by Name details", e);
		} finally {
			DBConnect.closeResource(ps, rs);
		}
		return searchMasterBookName;
	}
}
