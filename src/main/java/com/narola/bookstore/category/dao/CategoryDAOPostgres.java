package com.narola.bookstore.category.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.narola.bookstore.category.model.Categorry;
import com.narola.bookstore.exception.DatabaseException;
import com.narola.bookstore.utility.DBConnect;

public class CategoryDAOPostgres implements ICategoryDAO {
	public List<Categorry> getAllCategorry() throws DatabaseException {
		List<Categorry> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("SELECT * FROM category");
			rs = ps.executeQuery();
			while (rs.next()) {
				int categoryId = rs.getInt("categoryId");
				String categoryname = rs.getString("categoryName");
				Date createdon = rs.getDate("createdon");
				Date updatedon = rs.getDate("updatedon");
				list.add(new Categorry(categoryId, categoryname, createdon, updatedon));
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when display Category Details" + e.getMessage());
		} finally {
			DBConnect.closeResource(ps, rs);
		}
		return list;
	}

	public int insertQry(String categoryName) throws DatabaseException {
		Connection con = null;
		PreparedStatement stmt = null;
		int status = 0;
		try {
			con = DBConnect.getInstance().getConnection();
			stmt = con.prepareStatement("INSERT INTO category(categoryName) VALUES(?)");
			stmt.setString(1, categoryName);
			status = stmt.executeUpdate();
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when entering Category details" + e.getMessage());
		} finally {
			DBConnect.closeResource(stmt);
		}
		return status;
	}

	public int deleleQry(int categoryid) throws DatabaseException {
		int status = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("DELETE FROM category WHERE categoryId=?");
			ps.setInt(1, categoryid);
			status = ps.executeUpdate();
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when Deleting Category details" + e.getMessage());
		} finally {
			DBConnect.closeResource(ps);
		}
		return status;
	}

	public int updateQry(Categorry category) throws DatabaseException {
		Connection con = null;
		PreparedStatement ps = null;

		int status = 0;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("UPDATE category SET categoryName=? WHERE categoryId=?");
			ps.setString(1, category.getCategoryName());
			ps.setInt(2, category.getCategoryId());
			status = ps.executeUpdate();
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when Updating Category details" + e.getMessage());
		} finally {
			DBConnect.closeResource(ps);
		}
		return status;
	}

	public Categorry getUpdateDataFetchById(int catategoryid) throws DatabaseException {
		Connection con = null;
		PreparedStatement ps = null;
		Categorry categorry = null;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("SELECT categoryId,categoryName FROM category WHERE categoryId=?");
			ps.setInt(1, catategoryid);
			ResultSet rs = ps.executeQuery();
			categorry = new Categorry();
			if (rs.next()) {
				categorry.setCategoryId(rs.getInt(1));
				categorry.setCategoryName(rs.getString(2));
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException(
					"Exceptions when get Update Category Data Fetch By Id details" + e.getMessage());
		} finally {
			DBConnect.closeResource(ps);
		}
		return categorry;
	}

	public List<Categorry> searchByCategoryName(String categoryName) throws DatabaseException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Categorry> searchCategoryName = new ArrayList<>();
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("SELECT * FROM category WHERE categoryName =?");
			ps.setString(1, categoryName);
			rs = ps.executeQuery();

			while (rs.next()) {
				int categoryId = rs.getInt(1);
				String CategorryName = rs.getString(2);
				Date createdon = rs.getDate(3);
				Date updatedon = rs.getDate(4);
				searchCategoryName.add(new Categorry(categoryId, CategorryName, createdon, updatedon));
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when show category data by Name details" + e.getMessage());
		} finally {
			DBConnect.closeResource(ps, rs);
		}
		return searchCategoryName;
	}
}
