package com.narola.bookstore.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.narola.bookstore.utility.DBConnect;

public class AddressDAO {
	
	public static int insertQry(Address address) {
		Connection con = null;
		PreparedStatement stmt = null;
		int status = 0;

		try {
			con = DBConnect.getInstance().getConnection();
			stmt = con.prepareStatement("INSERT INTO address(address_Line1,address_Line2,landmark,state,pincode,city,address_type) VALUES(?,?,?,?,?,?,?)", stmt.RETURN_GENERATED_KEYS);

			stmt.setString(1, address.getAddressLine1());
			stmt.setString(2, address.getAddressLine2());
			stmt.setString(3, address.getLandmark());
			stmt.setString(4, address.getState());
			stmt.setInt(5, address.getPincode());
			stmt.setString(6, address.getCity());
			stmt.setString(7, address.getAddressType());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				status = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeResource(stmt);
		}

		return status;
	}
	
	public static void updateQry(Address address)
	{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		String Update = "update adress set address_Line1=?,address_Line2=?,landmark=?,state=?,pincode=?,city=?,address_type=? where addressID=?";		
		try
		{
			con = DBConnect.getInstance().getConnection();
			preparedStatement = con.prepareStatement(Update);
			preparedStatement.setString(1, address.getAddressLine1());
			preparedStatement.setString(2, address.getAddressLine2());
			preparedStatement.setString(3, address.getLandmark());
			preparedStatement.setString(4, address.getState());
			preparedStatement.setInt(5, address.getPincode());
			preparedStatement.setString(6, address.getCity());
			preparedStatement.setString(7, address.getAddressType());
			preparedStatement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
