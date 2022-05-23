package com.narola.bookstore.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.narola.bookstore.exception.DatabaseException;

public class DBConnect {

	private static DBConnect DBConnect = null;
	private Connection con = null;
	private String dburl = null;
	private String dbname = null;
	private String username = null;
	private String password = null;

	public String getDburl() {
		return dburl;
	}

	public void setDburl(String dburl) {
		this.dburl = dburl;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static DBConnect getInstance() {
		if (DBConnect == null) {
			DBConnect = new DBConnect();
		}
		return DBConnect;
	}

	public void initializedConnection() throws DatabaseException{
		getConnection();
	}

	public Connection getConnection() throws DatabaseException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection(getDburl() + "/" + getDbname(), getUsername(), getPassword());
			}
		} catch (SQLException s) {
			s.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void closeResource(Statement statement) {
		closeResource(statement, null);
	}

	public static void closeResource(Statement statement, ResultSet resultSet) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
