package com.narola.bookstore.book.validation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.narola.bookstore.book.model.Book;
import com.narola.bookstore.book.service.IBookService;
import com.narola.bookstore.utility.Constant;
import com.narola.bookstore.utility.ServiceFactory;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class BookValidationFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		IBookService iBookService = ServiceFactory.getInstence().iBookService;
		RequestDispatcher rd = null;
		System.out.println("InFilter");
		String bookName = request.getParameter("bookName");
		String authorName = request.getParameter("authorName");
		String description = request.getParameter("description");
		String amount = request.getParameter("bookAmount");
		String categoryId = request.getParameter("bookCategoryId");
		String publisherName = request.getParameter("publisherName");
		String msBookId = request.getParameter("msBookId");

		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI();
		System.out.println(url);
		System.out.println(url.equals(req.getContextPath() + Constant.BOOK_UPDATE_URL));
		System.out.println(req.getContextPath() + Constant.BOOK_UPDATE_URL);

		boolean isErrorExist = false;

		if (bookName == null || bookName.trim().isEmpty()) {
			request.setAttribute("errorMsgOfBookname", "Please enter valid Book Name");
			isErrorExist = true;
		}
		if (authorName == null || authorName.trim().isEmpty()) {
			request.setAttribute("errorMsgOfAuthorName", "Please enter valid Author Name");
			isErrorExist = true;
		}
		if (description == null || description.trim().isEmpty()) {
			request.setAttribute("errorMsgOfDescription", "Please enter Description");
			isErrorExist = true;
		}
		if (Double.parseDouble(amount) < 1 || amount == null || amount.trim().isEmpty()) {
			request.setAttribute("errorMsgOfAmount", "Please enter valid Amount at least 1 or more");
			isErrorExist = true;
		}
		if (Integer.parseInt(categoryId) == -1 || categoryId.trim().isEmpty()) {
			request.setAttribute("errorMsgOfBookCategoryId", "Please select one category");
			isErrorExist = true;
		}
		if (publisherName == null || publisherName.trim().isEmpty()) {
			request.setAttribute("errorMsgOfPublisherName", "Please enter valid publisher Name");
			isErrorExist = true;
		}
		if (msBookId == null || msBookId.trim().isEmpty()) {
			request.setAttribute("errorMsgOfMsbookId", "Please check Book Format at least one");
			isErrorExist = true;
		}
		for (Part part : req.getParts()) {
			if (part.getName().equals("bookImage")) {
				if (part.getSize() == 0) {
					request.setAttribute("errorMsgOfImage", "Please upload Image at least 1 or more");
					isErrorExist = true;
					break;
				}
			}
		}
		if (url.equals(req.getContextPath() + Constant.BOOK_UPDATE_URL)) {
			String bookID = request.getParameter("bookId");
			if (bookID == null || bookID.trim().isEmpty() || Integer.parseInt(bookID) == 0) {
				request.setAttribute("errorMsgOfBookId", "Please Check Your Book Id");
				isErrorExist = true;
			}
		}
		if (isErrorExist) {
			if (url.equals(req.getContextPath() + Constant.BOOK_ADD_URL)) {
				request.setAttribute("listOfCategory", iBookService.getAllCategory());
				request.setAttribute("listOfMsBookFormat", iBookService.getAllMasterBookFormat());
				rd = request.getRequestDispatcher("Book-Form.jsp");
				rd.forward(request, response);
			} else if (url.equals(req.getContextPath() + Constant.BOOK_UPDATE_URL)) {
				int bookId = 0;
				String bookID = request.getParameter("bookId");
				if (bookID != null && !bookID.trim().isEmpty() && Integer.parseInt(bookID) != 0) {
					bookId = Integer.parseInt(bookID);
				}
				Book book = new Book();
				request.setAttribute("bookId", bookId);
				request.setAttribute("bookName", bookName);
				request.setAttribute("authorName", authorName);
				request.setAttribute("description", description);
				request.setAttribute("amount", Integer.parseInt(amount));
				request.setAttribute("categoryId", Integer.parseInt(categoryId));
				request.setAttribute("publisherName", publisherName);
				request.setAttribute("msBookId", Integer.parseInt(msBookId));

				HttpServletRequest requ = (HttpServletRequest) request;
				String path = requ.getServletContext().getRealPath("/").concat("Book-Image");
				path = path + "\\" + bookId;

				File file = new File(path);
				String[] imgNames = file.list();

				List<String> imgPaths = new ArrayList<>();
				for (String imgName : imgNames) {
					imgPaths.add(imgName);
				}
				book.setImagesPathList(imgPaths);

				request.setAttribute("Book", book);
				request.setAttribute("listOfCategory", iBookService.getAllCategory());
				request.setAttribute("listOfMsBookFormat", iBookService.getAllMasterBookFormat());
				rd = request.getRequestDispatcher("Book-update.jsp");
				rd.forward(request, response);
			}
		} else {
			chain.doFilter(req, response);
		}

	}

}
