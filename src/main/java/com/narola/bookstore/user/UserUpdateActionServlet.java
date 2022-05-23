package com.narola.bookstore.user;

import java.io.IOException;

import com.narola.bookstore.address.Address;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@MultipartConfig
public class UserUpdateActionServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			int addressId=Integer.parseInt(request.getParameter("addressId"));
			
			Address address = new Address();
			address.setAddressId(addressId);
			address.setAddressLine1(request.getParameter("addressLine1"));
			address.setAddressLine2(request.getParameter("addressLine2"));
			address.setLandmark(request.getParameter("landmark"));
			address.setState(request.getParameter("state"));
			address.setPincode(Integer.parseInt(request.getParameter("pincode")));
			address.setCity(request.getParameter("city"));
			address.setAddressType(request.getParameter("addressType"));
			address.setMobile(Long.parseLong(request.getParameter("mobile")));
					
			User user = new User();
			user.setUserType(Integer.parseInt(request.getParameter("userType")));
			user.setUserId(Integer.parseInt(request.getParameter("userId")));
			user.setFirstName(request.getParameter("firstName"));
			user.setLastName(request.getParameter("lastName"));
			user.setAddressId(addressId);
			user.setContact(Long.parseLong(request.getParameter("contact")));
			user.setEmailId(request.getParameter("emailId"));
			user.setPassword(request.getParameter("password"));
			user.setAddress(address);
			
			int status = UserDAO.updateQry(user);
			
			if(status>0)
			{
				System.out.println("Your data Successfully Submitted");
				response.sendRedirect(request.getContextPath() + "/HomePageOfUser");
			}else {
				System.out.println("Sorry, Data is not saved");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
