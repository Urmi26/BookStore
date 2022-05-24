package com.narola.bookstore.book.dao;

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
import com.narola.bookstore.msbookformat.model.MasterBookFormat;
import com.narola.bookstore.utility.DBConnect;

public class BookDAOMysql implements IBookDAO {

	public List<Book> getAllBooks() throws DatabaseException {
		List<Book> listOfBook = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = DBConnect.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(
					"SELECTt b.*,c.categoryName FROM book b left join category c on b.categoryId=c.categoryId");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int bookId = resultSet.getInt("bookId");
				String bookname = resultSet.getString("bookName");
				String authorName = resultSet.getString("authorName");
				String description = resultSet.getString("description");
				Double amount = Double.parseDouble(resultSet.getString("amount"));
				int categoryId = resultSet.getInt("categoryId");
				String publisherName = resultSet.getString("publisherName");
				Date createdOn = resultSet.getDate("createdOn");
				Date updatedOn = resultSet.getDate("updatedOn");

				Categorry category = new Categorry();
				category.setCategoryName(resultSet.getString("categoryName"));

				listOfBook.add(new Book(bookId, bookname, authorName, description, amount, categoryId, publisherName,
						createdOn, updatedOn, category));
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when display all book details", e);
		} finally {
			DBConnect.closeResource(preparedStatement, resultSet);
		}
		return listOfBook;
	}

	public int insertQry(Book book) throws DatabaseException {
		int autoGeneratedId = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PreparedStatement ps1 = null;
		String bookInsertQry = "insert into book(bookName,authorName,description,amount,categoryId,publisherName) values(?,?,?,?,?,?)";
		String bookFormatInsertQry = "insert into book_format(bookId,msBookId) values(?,?)";
		try {

			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement(bookInsertQry, ps.RETURN_GENERATED_KEYS);
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getAuthorName());
			ps.setString(3, book.getDescription());
			ps.setDouble(4, book.getAmount());
			ps.setInt(5, book.getCategoryId());
			ps.setString(6, book.getPublisherName());
			ps.execute();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				autoGeneratedId = rs.getInt(1);
			}

			if (autoGeneratedId > 0) {
				for (int i = 0; i < book.masterBookFormat.getMsBookIdList().length; i++) {
					if (i != book.masterBookFormat.getMsBookIdList().length) {
						ps1 = con.prepareStatement(bookFormatInsertQry);
						ps1.setInt(1, autoGeneratedId);
						ps1.setInt(2, Integer.parseInt(book.masterBookFormat.getMsBookIdList()[i]));
						ps1.execute();
					}
				}
			}

		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when entering book and book_format details", e);
		} finally {
			DBConnect.closeResource(ps);
		}
		return autoGeneratedId;
	}

	public int deleteQry(int bookId) throws DatabaseException {
		int status = 0;
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("DELETE FROM book WHERE bookId=?");
			ps.setInt(1, bookId);
			status = ps.executeUpdate();
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when deleting book details", e);
		} finally {
			DBConnect.closeResource(ps);
		}
		return status;
	}

	public Book getBookByID(int bookId) throws DatabaseException {
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
			throw new DatabaseException("Exceptions when show book by ID details", e);
		} finally {
			DBConnect.closeResource(ps);
		}
		return book;
	}

	public List<Integer> getListofMasterBookID(int bookId) throws DatabaseException {
		List<Integer> listofFormat = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement(
					"SELECT f.msBookId FROM book b, book_format f WHERE b.bookId=? and b.bookId=f.bookId");
			ps.setInt(1, bookId);
			rs = ps.executeQuery();

			listofFormat = new ArrayList<>();
			while (rs.next()) {
				int msBookId = rs.getInt(1);
				listofFormat.add(msBookId);
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when show book and book format data details", e);
		} finally {
			DBConnect.closeResource(ps);
		}
		return listofFormat;
	}

	public Book getBookInfoByID(int bookId) throws DatabaseException {
		Book book = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement(
					"select b.*, c.categoryName from book b, category c where b.bookId = ? and b.categoryId = c.categoryId;");
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
				book.setCreatedOn(rs.getDate(8));
				book.setUpdatedOn(rs.getDate(9));

				Categorry cat = new Categorry();
				cat.setCategoryName(rs.getString(10));
				book.setCat(cat);

				List<MasterBookFormat> masterBookFormat = getListOfBookFormatForBookId(book.getBookId());
				book.setMasterBookFormatt(masterBookFormat);
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when show book information by Id details", e);
		} finally {
			DBConnect.closeResource(ps, rs);
		}
		return book;
	}

	public int updateQry(Book book) {
		Connection con = null;
		PreparedStatement ps = null;
		String bookdataUpdate = "UPDATE book b SET b.bookName=?,b.authorName=?,b.description=?,b.amount=?,b.categoryId=?,b.publisherName=? WHERE b.bookId=?";
		int status = 0;

		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement(bookdataUpdate);
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getAuthorName());
			ps.setString(3, book.getDescription());
			ps.setDouble(4, book.getAmount());
			ps.setInt(5, book.getCategoryId());
			ps.setString(6, book.getPublisherName());
			ps.setInt(7, book.getBookId());
			status = ps.executeUpdate();

		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when updating book details", e);
		} finally {
			DBConnect.closeResource(ps);
		}
		return status;
	}

	public List<Book> searchBookName(String bookNameStr) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> searchBookName = new ArrayList<>();

		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement(
					"SELECT b.*,c.categoryName FROM book b, category c WHERE b.bookName =? and b.categoryId=c.categoryId");
			ps.setString(1, bookNameStr);
			rs = ps.executeQuery();

			while (rs.next()) {
				int bookId = rs.getInt(1);
				String bookName = rs.getString(2);
				String authorName = rs.getString(3);
				String description = rs.getString(4);
				int amount = rs.getInt(5);
				int categoryId = rs.getInt(6);
				String publisherName = rs.getString(7);
				Date createdOn = rs.getDate(8);
				Date updatedOn = rs.getDate(9);

				Categorry category = new Categorry();
				category.setCategoryName(rs.getString("categoryName"));

				searchBookName.add(new Book(bookId, bookName, authorName, description, amount, categoryId,
						publisherName, createdOn, updatedOn, category));
			}

		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when searching book by Book Name details", e);
		} finally {
			DBConnect.closeResource(ps, rs);
		}
		return searchBookName;
	}

	public List<Book> searchCategoryId(int categoryId) throws DatabaseException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> searchBookName = new ArrayList<>();

		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement(
					"SELECT b.*,c.categoryName FROM book b, category c WHERE b.categoryId =? and b.categoryId=c.categoryId");
			ps.setInt(1, categoryId);
			rs = ps.executeQuery();

			while (rs.next()) {
				int bookId = rs.getInt(1);
				String bookName = rs.getString(2);
				String authorName = rs.getString(3);
				String description = rs.getString(4);
				int amount = rs.getInt(5);
				int categoryid = rs.getInt(6);
				String publisherName = rs.getString(7);
				Date createdOn = rs.getDate(8);
				Date updatedOn = rs.getDate(9);

				Categorry category = new Categorry();
				category.setCategoryName(rs.getString("categoryName"));
				searchBookName.add(new Book(bookId, bookName, authorName, description, amount, categoryid,
						publisherName, createdOn, updatedOn, category));
			}

		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when searching category by Id details", e);
		} finally {
			DBConnect.closeResource(ps, rs);
		}
		return searchBookName;
	}

	public List<Categorry> getListOfCategory() throws DatabaseException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Categorry> category = new ArrayList<>();
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("SELECT * FROM category");
			rs = ps.executeQuery();

			while (rs.next()) {
				category.add(new Categorry(Integer.parseInt(rs.getString("categoryId")), rs.getString("categoryName")));
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when show category details", e);
		} finally {
			DBConnect.closeResource(ps, rs);
		}

		return category;
	}

	public List<MasterBookFormat> getListOfMasterBookFormat() throws DatabaseException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MasterBookFormat> masterBookFormat = new ArrayList<>();
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("SELECT * FROM master_book");
			rs = ps.executeQuery();

			while (rs.next()) {
				int msBookId = Integer.parseInt(rs.getString("msBookId"));
				String msBookName = rs.getString("msBookName");

				masterBookFormat.add(new MasterBookFormat(msBookId, msBookName));
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when show master book details", e);
		} finally {
			DBConnect.closeResource(ps, rs);
		}
		return masterBookFormat;
	}

	public List<MasterBookFormat> getListOfBookFormatForBookId(int bookId) throws DatabaseException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MasterBookFormat> masterBookFormat = new ArrayList<>();
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement(
					"SELECT bf.msBookId, mb.msBookName FROM mydb.book_format bf, master_book mb where bf.bookId=? and mb.msBookId=bf.msbookId");
			ps.setInt(1, bookId);
			rs = ps.executeQuery();

			while (rs.next()) {
				int msBookId = Integer.parseInt(rs.getString(1));
				String msBookName = rs.getString(2);
				masterBookFormat.add(new MasterBookFormat(msBookId, msBookName));
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when show book format and master book by book Id details", e);
		} finally {
			DBConnect.closeResource(ps, rs);
		}

		return masterBookFormat;
	}

	public List<Integer> getListOfMsBookId(int bookId) throws DatabaseException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Integer> listOfmsBookId = new ArrayList<>();
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("SELECT msBookId FROM book_format where bookId=?");
			ps.setInt(1, bookId);
			rs = ps.executeQuery();

			while (rs.next()) {
				int msBookId = Integer.parseInt(rs.getString("msBookId"));
				listOfmsBookId.add(msBookId);
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when show book format details", e);
		} finally {
			DBConnect.closeResource(ps, rs);
		}
		return listOfmsBookId;
	}

	public void insertQryOfMsBookId(Book book) throws DatabaseException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("insert into book_format(bookId,msBookId) values(?,?)");
			ps.setInt(1, book.getBookId());
			ps.setInt(2, book.getMasterBookFormat().getMsBookId());
			ps.execute();

		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when entering book format details", e);
		} finally {
			DBConnect.closeResource(ps);
		}
	}

	public void deleteQryofMsBookID(int bookId, int msBookId) throws DatabaseException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement("DELETE FROM book_format WHERE bookId=? and msBookId=?");
			ps.setInt(1, bookId);
			ps.setInt(2, msBookId);
			ps.executeQuery();

		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when deleting book format details", e);
		} finally {
			DBConnect.closeResource(ps);
		}
	}

	public Book displayBookDetails(int bookId) throws DatabaseException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		try {
			con = DBConnect.getInstance().getConnection();
			ps = con.prepareStatement(
					"select b.*,c.categoryName from book b, category c where b.bookId=? and b.categoryId=c.categoryId");
			ps.setInt(1, bookId);
			rs = ps.executeQuery();

			book = new Book();
			if (rs.next()) {
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthorName(rs.getString(3));
				book.setDescription(rs.getString(4));
				book.setAmount(rs.getInt(5));
				book.setCategoryId(rs.getInt(6));
				book.setPublisherName(rs.getString(7));
				book.setCreatedOn(rs.getDate(8));
				book.setUpdatedOn(rs.getDate(9));

				Categorry cat = new Categorry();
				cat.setCategoryName(rs.getString(10));
				book.setCat(cat);

				List<MasterBookFormat> masterBookFormat = getListOfBookFormatForBookId(book.getBookId());
				book.setMasterBookFormatt(masterBookFormat);
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Exceptions when show book and category by ID details", e);
		} finally {
			DBConnect.closeResource(ps, rs);
		}
		return book;
	}
}