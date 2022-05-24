package com.narola.bookstore.book.service.Impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.narola.bookstore.book.dao.IBookDAO;
import com.narola.bookstore.book.model.Book;
import com.narola.bookstore.book.service.IBookService;
import com.narola.bookstore.category.model.Categorry;
import com.narola.bookstore.exception.ApplicationException;
import com.narola.bookstore.exception.DatabaseException;
import com.narola.bookstore.msbookformat.model.MasterBookFormat;
import com.narola.bookstore.utility.Constant;
import com.narola.bookstore.utility.DAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class BookServiceImpl implements IBookService {

	public void addBook(Book book, HttpServletRequest request, HttpServletResponse response) {
		try {
			String url = request.getServletContext().getRealPath("/").concat("Book-Image");
			File parentImgFolder = new File(url);
			IBookDAO bookDAO = DAOFactory.getInstence().getBookDAO();
			int bookID = bookDAO.insertQry(book);

			if (bookID != 0) {
				if (!parentImgFolder.exists()) {
					parentImgFolder.mkdir();
				}
				url = url + "\\" + String.valueOf(bookID);
				File bookImgFolder = new File(url);
				if (!bookImgFolder.exists()) {
					bookImgFolder.mkdir();
				}
				for (Part part : request.getParts()) {
					if (part.getName().equals("bookImage")) {
						part.write(url + "\\" + part.getSubmittedFileName());
					}
				}
			}
			if (bookID > 0) {
				response.sendRedirect(request.getContextPath() + Constant.BOOK_DISPLAY_URL);
			} else {
				throw new ApplicationException("Sorry, Data is not submitted");
			}
		} catch (DatabaseException | ServletException | IOException e) {
			throw new ApplicationException("Oops, Something went wrong..", e);
		}
	}

	@Override
	public List<Categorry> getAllCategory() throws ApplicationException {
		try {
			IBookDAO bookDAO = DAOFactory.getInstence().getBookDAO();
			return bookDAO.getListOfCategory();
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Something went wrong..", e);
		}
	}

	@Override
	public List<MasterBookFormat> getAllMasterBookFormat() throws ApplicationException {
		try {
			IBookDAO bookDAO = DAOFactory.getInstence().getBookDAO();
			return bookDAO.getListOfMasterBookFormat();
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Something went wrong..", e);
		}
	}

	@Override
	public Book getBookAllDetails(int bookId) throws ApplicationException {
		try {
			IBookDAO bookDAO = DAOFactory.getInstence().getBookDAO();
			return bookDAO.displayBookDetails(bookId);
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Something went wrong..", e);
		}
	}

	@Override
	public void deletebook(int bookId, HttpServletRequest request, HttpServletResponse response) {
		try {
			IBookDAO bookDAO = DAOFactory.getInstence().getBookDAO();

			bookDAO.deleteQry(bookId);

			if (bookId != 0) {
				response.sendRedirect(request.getContextPath() + Constant.BOOK_DISPLAY_URL);
			} else {
				throw new ApplicationException("Delete can't Records");
			}

		} catch (DatabaseException | IOException e) {

			throw new ApplicationException("Oops, Something went wrong..", e);
		}
	}

	@Override
	public List<Book> searchBooks(String bookName) throws ApplicationException {
		try {
			IBookDAO bookDAO = DAOFactory.getInstence().getBookDAO();
			return bookDAO.searchBookName(bookName);
		} catch (DatabaseException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	@Override
	public Book getBookId(int bookId, HttpServletRequest request) throws ApplicationException {
		try {
			IBookDAO bookDAO = DAOFactory.getInstence().getBookDAO();

			String path = request.getServletContext().getRealPath("/").concat("Book-Image");
			File parentImgFolder = new File(path);

			if (!parentImgFolder.exists()) {
				parentImgFolder.mkdir();
			}
			path = path + "\\" + bookId;
			File bookImgFolder = new File(path);
			if (!bookImgFolder.exists()) {
				bookImgFolder.mkdir();
			}
			File file = new File(path);
			String[] imgNames = file.list();

			String s = request.getContextPath().concat("/Book-Image/") + bookId + "/";
			List<String> imgPaths = new ArrayList<>();
			for (String imgName : imgNames) {
				imgPaths.add(s + imgName);
			}
			Book bookImage = new Book();
			bookImage = bookDAO.getBookByID(bookId);
			bookImage.setImagesPathList(imgPaths);
			return bookImage;
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Something went wrong..", e);
		}
	}

	@Override
	public List<Integer> getListOfMsBookId(int bookId) throws ApplicationException {
		try {
			IBookDAO bookDAO = DAOFactory.getInstence().getBookDAO();
			return bookDAO.getListofMasterBookID(bookId);
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Something went wrong..", e);
		}
	}

	@Override
	public void updateBook(Book book, List<Integer> msBookId, String[] msBookIdChecked, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			IBookDAO bookDAO = DAOFactory.getInstence().getBookDAO();

			for (String s : msBookIdChecked) {

				if (msBookId.contains(Integer.parseInt(s))) {
					System.out.println("match : " + s);
				} else {
					Book bk = new Book();
					bk.setBookId(book.getBookId());
					MasterBookFormat masterBookFormat = new MasterBookFormat();
					masterBookFormat.setMsBookId(Integer.parseInt(s));
					bk.setMasterBookFormat(masterBookFormat);
					addMasterBookFormat(bk);
				}
			}
			for (Integer i : msBookId) {
				if (!Arrays.asList(msBookIdChecked).contains(i.toString())) {
					deleteMasterBookFormat(book.getBookId(), i);
				}
			}
			String path = request.getServletContext().getRealPath("/").concat("Book-Image");
			File parentImgFolder = new File(path);

			if (!parentImgFolder.exists()) {
				parentImgFolder.mkdir();
			}

			path = path + "\\" + book.getBookId();
			File bookImgFolder = new File(path);
			if (!bookImgFolder.exists()) {
				bookImgFolder.mkdir();
			}

			for (Part part : request.getParts()) {
				if (part.getName().equals("bookImage")) {
					if (!part.getSubmittedFileName().isEmpty()) {
						part.write(path + "\\" + part.getSubmittedFileName());
					}
				}
			}

			int status = bookDAO.updateQry(book);

			if (status > 0) {
				response.sendRedirect(request.getContextPath() + Constant.BOOK_DISPLAY_URL);
			} else {
				throw new ApplicationException("record cann't updated..");
			}

		} catch (DatabaseException | ServletException | IOException e) {
			throw new ApplicationException("Oops, Something went wrong..", e);
		}
	}

	@Override
	public Book getBookInformationById(int bookId, HttpServletRequest request) throws ApplicationException {
		try {
			IBookDAO bookDAO = DAOFactory.getInstence().getBookDAO();
			String path = request.getServletContext().getRealPath("/").concat("Book-Image");
			path = path + "\\" + bookId;
			File file = new File(path);
			String[] imgNames = file.list();
			List<String> imgPaths = new ArrayList<>();
			String str = request.getContextPath().concat("/Book-Image/") + bookId + "/";

			for (String imgName : imgNames) {
				imgPaths.add(str + imgName);
			}
			Book book = new Book();
			book = bookDAO.getBookInfoByID(bookId);
			book.setImagesPathList(imgPaths);

			return book;
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Something went wrong..", e);
		}
	}

	@Override
	public List<Book> searchCategoryById(int categoryId) throws ApplicationException {
		try {
			IBookDAO bookDAO = DAOFactory.getInstence().getBookDAO();
			return bookDAO.searchCategoryId(categoryId);
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Something went wrong..", e);
		}
	}

	@Override
	public List<Book> getListOfBooks() throws ApplicationException {
		try {
			IBookDAO bookDAO = DAOFactory.getInstence().getBookDAO();
			return bookDAO.getAllBooks();
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Something went wrong..", e);
		}
	}

	@Override
	public void addMasterBookFormat(Book book) {
		try {
			IBookDAO bookDAO = DAOFactory.getInstence().getBookDAO();
			bookDAO.insertQryOfMsBookId(book);
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Something went wrong..", e);
		}
	}

	@Override
	public void deleteMasterBookFormat(int bookId, int msBookId) throws ApplicationException {
		try {
			IBookDAO bookDAO = DAOFactory.getInstence().getBookDAO();
			bookDAO.deleteQryofMsBookID(bookId, msBookId);
		} catch (DatabaseException e) {
			throw new ApplicationException("Oops, Something went wrong..", e);
		}
	}

	@Override
	public void deleteImage(HttpServletRequest request, HttpServletResponse response) {
		try {
			String image = request.getParameter("imageName");
			image = image.substring(31);

			String path = request.getServletContext().getRealPath("/").concat("Book-Image");
			path = path + "\\" + request.getParameter("bookId") + "\\" + image;
			File bookImgFolder = new File(path);

			if (!bookImgFolder.exists()) {
				throw new ApplicationException("Folder is not available");
			}
			bookImgFolder = new File(path);
			bookImgFolder.delete();
			response.sendRedirect(request.getContextPath() + Constant.BOOK_DISPLAY_URL);
		} catch (DatabaseException | IOException e) {
			throw new ApplicationException("Oops, Something went wrong..", e);
		}
	}
}
