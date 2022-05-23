package com.narola.bookstore.utility;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

public class StartOnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			String dbType = getServletContext().getInitParameter("DB-IN-USE");
			DAOFactory.getInstence().init(dbType);
			
			DBConnect.getInstance().setDburl(getServletContext().getInitParameter(dbType + "_dburl"));
			DBConnect.getInstance().setDbname(getServletContext().getInitParameter(dbType + "_dbname"));
			DBConnect.getInstance().setUsername(getServletContext().getInitParameter(dbType + "_username"));
			DBConnect.getInstance().setPassword(getServletContext().getInitParameter(dbType + "_password"));
			DBConnect.getInstance().initializedConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
