package com.narola.bookstore.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.narola.bookstore.book.model.Book;
import com.narola.bookstore.category.model.Categorry;
import com.narola.bookstore.exception.DatabaseException;
import com.narola.bookstore.user.User;
import com.narola.bookstore.utility.DBConnect;

public class CartDAO {

	public static List<Cart> getAllSelectedBooks(int userID) {
		List<Cart> listOfselectedBook = new ArrayList<>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement(
					"select c.*,b.bookName,b.authorName,b.description,b.publisherName,cat.categoryName from cart c, book b, category cat where userId=? and c.bookId=b.bookId and b.categoryId=cat.categoryId");
			ps.setInt(1, userID);
			rs = ps.executeQuery();

			while (rs.next()) {
				int cartId = rs.getInt("cartId");
				int userId = rs.getInt("userId");
				User user = new User();
				user.setUserId(userId);

				int bookId = rs.getInt("bookId");
				int quantity = rs.getInt("quantity");
				double amount = rs.getDouble("amount");
				Date createdOn = rs.getDate("createdOn");

				String bookName = rs.getString("bookName");
				String authorName = rs.getString("authorName");
				String description = rs.getString("description");
				String publisherName = rs.getString("publisherName");

				String categoryName = rs.getString("categoryName");
				Categorry category = new Categorry();
				category.setCategoryName(categoryName);

				Book book = new Book();
				book.setBookId(bookId);
				book.setBookName(bookName);
				book.setAuthorName(authorName);
				book.setDescription(description);
				book.setPublisherName(publisherName);
				book.setCategory(category);

				listOfselectedBook.add(new Cart(cartId, user, quantity, amount, createdOn, book));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeResource(ps, rs);
		}
		return listOfselectedBook;
	}

	public static Book getBookByID(int bookId) throws DatabaseException {
		Book book = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("SELECT * FROM book WHERE bookId=?");
			ps.setInt(1, bookId);
			rs = ps.executeQuery();
			book = new Book(bookId);
			if (rs.next()) {
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthorName(rs.getString(3));
				book.setDescription(rs.getString(4));
				book.setAmount(rs.getInt(5));
				book.setCategoryId(rs.getInt(6));
				book.setPublisherName(rs.getString(7));
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when show book by ID details" + e.getMessage());
		} finally {
			DBConnect.closeResource(ps);
		}
		return book;
	}

	public static int insetQry(int bookid, int userId) {
		int status = 0;
		Connection con = null;
		PreparedStatement ps = null;
		Book book = getBookByID(bookid);// get the bookid of data

		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("insert into cart(userId,bookId,quantity,amount) values(?,?,?,?)");

			ps.setInt(1, userId);
			ps.setInt(2, book.getBookId());
			ps.setInt(3, 1);
			ps.setDouble(4, book.getAmount());
			status = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeResource(ps);
		}

		return status;
	}

	public static List<Cart> listofCartData() {
		List<Cart> listOfBookId = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("select * from cart");
			rs = ps.executeQuery();

			while (rs.next()) {
				int cartid = rs.getInt(1);
				int userid = rs.getInt(2);
				User user = new User();
				user.setUserId(userid);

				int book_id = rs.getInt(3);
				Book book = new Book();
				book.setBookId(book_id);

				int quantity = rs.getInt(4);
				int amount = rs.getInt(5);
				Date createdon = rs.getDate(6);

				listOfBookId.add(new Cart(cartid, user, book, quantity, amount, createdon));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfBookId;
	}

	public static int checkbookselectedOrnot(int bookId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int qty = 0;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("select quantity from cart where bookId=?");
			ps.setInt(1, bookId);
			rs = ps.executeQuery();

			if (rs.next()) {
				qty = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeResource(ps);
		}
		return qty;
	}

	public static int updateQry(int cartId, int quantity) {
		Connection con = null;
		PreparedStatement ps = null;
		int status = 0;

		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("UPDATE cart SET quantity=? WHERE cartId=?");
			ps.setInt(1, quantity);
			ps.setInt(2, cartId);
			status = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeResource(ps);
		}
		return status;
	}

	public static int deleteQry(int cartId) {
		int status = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("delete from cart where cartId=?");
			ps.setInt(1, cartId);
			status = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeResource(ps);
		}

		return status;
	}

}
