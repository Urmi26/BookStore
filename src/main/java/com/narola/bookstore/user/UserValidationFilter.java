package com.narola.bookstore.user;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.narola.bookstore.utility.Constant;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class UserValidationFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		RequestDispatcher rd = null;
		System.out.println("InFilter");
		String userId = request.getParameter("userId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		String contact = request.getParameter("contact");
		String no = "^[0-9]{10}$";
		Pattern pattern1 = Pattern.compile(no);
		Matcher m1 = pattern1.matcher(contact);

		String emailId = request.getParameter("emailId");
		String email = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern2 = Pattern.compile(email);
		Matcher m2 = pattern2.matcher(emailId);
		System.out.println(m2.matches());

		String password = request.getParameter("password");
		String pwd = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,8}$";
		Pattern pattern3 = Pattern.compile(pwd);
		Matcher m3 = pattern3.matcher(password);

		String addressId = request.getParameter("addressId");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String landmark = request.getParameter("landmark");
		String state = request.getParameter("state");
		String pincode = request.getParameter("pincode");
		String city = request.getParameter("city");
		String addressType = request.getParameter("addressType");

		String mobile = request.getParameter("mobile");
		String no1 = "^[0-9]{10}$";
		Pattern pattern4 = Pattern.compile(no1);
		Matcher m4 = pattern4.matcher(mobile);

		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI();
		boolean isErrorExist = false;

		if (userId == null || userId.trim().isEmpty()) {
			request.setAttribute("errorMsgOfUserId", "Please check userId");
			isErrorExist = true;
		}
		if (firstName == null || firstName.trim().isEmpty()) {
			request.setAttribute("errorMsgOfFirstname", "Please enter valid First Name");
			isErrorExist = true;
		}
		if (lastName == null || lastName.trim().isEmpty()) {
			request.setAttribute("errorMsgOflastName", "Please enter valid Last Name");
			isErrorExist = true;
		}
		if (contact == null || contact.trim().isEmpty() || !m1.matches()) {
			request.setAttribute("errorMsgOfContact", "Please enter valid Contact No");
			isErrorExist = true;
		}
		if (emailId == null || emailId.trim().isEmpty() || !m2.matches()) {
			request.setAttribute("errorMsgOfEmail", "Please enter valid E-mail");
			isErrorExist = true;
		}
		if (password == null || password.trim().isEmpty() || !m3.matches()) {
			request.setAttribute("errorMsgOfPassword", "Please enter valid Password");
			isErrorExist = true;
		}
		if (addressId == null || addressId.trim().isEmpty()) {
			request.setAttribute("errorMsgOfAddressId", "Please check addressId");
			isErrorExist = true;
		}
		if (addressLine1 == null || addressLine1.trim().isEmpty()) {
			request.setAttribute("errorMsgOfAddressLine1", "Please enter valid First Name");
			isErrorExist = true;
		}
		if (addressLine2 == null || addressLine2.trim().isEmpty()) {
			request.setAttribute("errorMsgOfAddressLine2", "Please enter valid Last Name");
			isErrorExist = true;
		}
		if (landmark == null || landmark.trim().isEmpty()) {
			request.setAttribute("errorMsgOfLandMark", "Please enter valid LasdMark");
			isErrorExist = true;
		}
		if (state == null || state.trim().isEmpty()) {
			request.setAttribute("errorMsgOfState", "Please select valid state");
			isErrorExist = true;
		}
		if (pincode == null || pincode.trim().isEmpty() || pincode.length() != 6) {
			request.setAttribute("errorMsgOfPincode", "Please enter valid pincode");
			isErrorExist = true;
		}
		if (city == null || city.trim().isEmpty()) {
			request.setAttribute("errorMsgOfCity", "Please enter valid city");
			isErrorExist = true;
		}
		if (addressType == null || addressType.trim().isEmpty()) {
			request.setAttribute("errorMsgOfAddressType", "Please enter valid AddressType(example : Home, Office)");
			isErrorExist = true;
		}
		if (mobile == null || mobile.trim().isEmpty() || !m4.matches()) {
			request.setAttribute("errorMsgOfMobileNo", "Please enter valid Mobile No");
			isErrorExist = true;
		}

		if (isErrorExist) {
			if (url.equals(req.getContextPath() + Constant.USER_UPDATE_URL)) {
				rd = request.getRequestDispatcher("User-update.jsp");
				rd.forward(request, response);
			}

		} else {
			chain.doFilter(request, response);
		}

	}
}
