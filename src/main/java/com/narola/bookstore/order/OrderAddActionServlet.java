package com.narola.bookstore.order;

import java.io.IOException;

import com.narola.bookstore.address.Address;
import com.narola.bookstore.user.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OrderAddActionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			User user1 = (User) session.getAttribute("user");
			if (user1 == null) {
				System.out.println("user null");
			} else {
				int userId = user1.getUserId();

				User user = new User();
				user.setUserId(userId);

				Address address = new Address();
				address.setAddressLine1(request.getParameter("addressLine1"));
				address.setAddressLine2(request.getParameter("addressLine2"));
				address.setLandmark(request.getParameter("landmark"));
				address.setState(request.getParameter("state"));
				address.setPincode(Integer.parseInt(request.getParameter("pincode")));
				address.setCity(request.getParameter("city"));
				address.setAddressType(request.getParameter("addresstype"));
				address.setMobile(Long.parseLong(request.getParameter("mobileNo")));

				Order order = new Order();
				order.setUser(user);
				order.setAddress(address);
				order.setTotalAmount(Double.parseDouble(request.getParameter("totalAmount")));

				int status = OrderDAO.insertQry(order);

				if (status > 0) {
					System.out.println("Your data Successfully Submitted");
					response.sendRedirect(request.getContextPath() + "/HomePageOfUser");

				} else {
					System.out.println("Your data Unsuccessfully Submitted");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
