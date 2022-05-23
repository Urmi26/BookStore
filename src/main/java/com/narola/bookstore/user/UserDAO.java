package com.narola.bookstore.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.narola.bookstore.address.Address;
import com.narola.bookstore.utility.DBConnect;

public class UserDAO {
	
	public static User checkUserIdandPassword(String emailId, String password){
		User user=null;
//		boolean status=false;
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			con=DBConnect.getInstance().getConnection();
			stmt=con.prepareStatement("select * from user where emailId=? and password=?");
			stmt.setString(1, emailId);
			stmt.setString(2, password);
		//	status = stmt.execute();
			rs = stmt.executeQuery();
			if(rs.next()){
				int userid=rs.getInt(1);
				int usertype=rs.getInt(2);
				String firstName=rs.getString(3);
				String lastName=rs.getString(4);
				int addressId=rs.getInt(5);
				long mobno=rs.getLong(6);
				String emailID=rs.getString(7);
				String passwordd=rs.getString(8);
				int otp=rs.getInt(9);
				Date createdon=rs.getDate(10);
				Date updatedon=rs.getDate(11);
								
				user=new User(userid,usertype,firstName,lastName,addressId,mobno,emailID,passwordd,otp,createdon,updatedon);				
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBConnect.closeResource(stmt);
		}	
		return user;
	}
		
	public static int insertQry(String emailId, int otp) {
		int status = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBConnect.getInstance().getConnection();
			stmt = con.prepareStatement("INSERT INTO user(userType,emailId,otp) VALUES(?,?,?)");
			stmt.setInt(1, 1);
			stmt.setString(2,emailId);
			stmt.setInt(3, otp);
			status = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeResource(stmt);
		}
		return status;
	}
	
	public static int userCheckOtp(String emailId,int otp) {
		int userId=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("select userId from user where emailId=? and otp=?");
			ps.setString(1, emailId);
			ps.setInt(2, otp);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				userId=rs.getInt(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnect.closeResource(ps,rs);
		}
		return userId;
	}
	
	public static int updateQryOfPassword(int userId, String password)
	{
		int status=0;
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=DBConnect.getInstance().getConnection();
			ps=con.prepareStatement("UPDATE user u SET password=? WHERE u.userId=?");
			ps.setString(1, password);
			ps.setInt(2, userId);
			status=ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnect.closeResource(ps);
		}
		return status;
	}

	public static int deleteQry(int userId) {
		int status = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("DELETE FROM user WHERE userId=?");
			//DELETE FROM user, address using user inner join address on user.addressID = address.addressID and user.addressID=18;
			ps.setInt(1, userId);
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeResource(ps);
		}
		return status;
	}
	
	public static User getUserByID(int userId) {
		User user = null;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("SELECT u.*,a.* FROM user u, address a WHERE u.userId=? and u.addressID=a.addressID");
			//SELECT * FROM user WHERE userId=?;

			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			user = new User(userId);
			if (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUserType(rs.getInt(2));
				user.setFirstName(rs.getString(3));
				user.setLastName(rs.getString(4));
				user.setAddressId(rs.getInt(5));
				user.setContact(rs.getLong(6));
				user.setEmailId(rs.getString(7));
				user.setPassword(rs.getString(8));
				user.setOtp(rs.getInt(9));
				user.setCreatedOn(rs.getDate(10));
				user.setUpdatedOn(rs.getDate(11));
				
				Address address = new Address();
				address.setAddressId(rs.getInt(12));
				address.setAddressLine1(rs.getString(13));
				address.setAddressLine2(rs.getString(14));
				address.setLandmark(rs.getString(15));
				address.setState(rs.getString(16));
				address.setPincode(rs.getInt(17));
				address.setCity(rs.getString(18));
				address.setAddressType(rs.getString(19));
				address.setMobile(rs.getLong(20));
				address.setCreatedOn(rs.getDate(21));
				address.setUpdatedOn(rs.getDate(22));
				user.setAddress(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeResource(ps);
		}
		return user;
	}
	
	public static int updateQry(User user)
	{
		int status=0;
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=DBConnect.getInstance().getConnection();
			ps=con.prepareStatement("UPDATE user u, address a SET u.firstName=?,u.lastName=?,u.contact=?,u.emailId=?,u.password=?,a.address_Line1=?,a.address_Line2=?,a.landmark=?,a.state=?, a.pincode=?,a.city=?,a.address_type=?,a.MobileNo=? WHERE u.userId=? and u.addressID=a.addressID");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setLong(3, user.getContact());
			ps.setString(4, user.getEmailId());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getAddress().getAddressLine1());
			ps.setString(7, user.getAddress().getAddressLine2());
			ps.setString(8, user.getAddress().getLandmark());
			ps.setString(9, user.getAddress().getState());
			ps.setInt(10, user.getAddress().getPincode());
			ps.setString(11, user.getAddress().getCity());
			ps.setString(12, user.getAddress().getAddressType());
			ps.setLong(13, user.getAddress().getMobile());
			ps.setInt(14, user.getUserId());
			status=ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnect.closeResource(ps);
		}
		return status;
	}
	
	public static List<User> ListOfEIdandPassword() {
		List<User> listOfIdandPwd=new ArrayList<User>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=DBConnect.getInstance().getConnection();
			ps=con.prepareStatement("select emailId,password from user");
			rs=ps.executeQuery();
		
			while(rs.next()) {
				String emailId = rs.getString(1);
				String password = rs.getString(2);
				
				listOfIdandPwd.add(new User(emailId,password));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnect.closeResource(ps, rs);
		}
		return listOfIdandPwd;
	}
}
