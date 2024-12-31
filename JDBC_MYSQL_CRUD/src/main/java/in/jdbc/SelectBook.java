package in.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectBook {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_USERNAME = "root";
	private static final String DB_PWD = "root";
	private static final String SELECT_SQL = "SELECT *FROM BOOKS ";

	public static void main(String[] args) throws Exception {
		// Step 1- Load and Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Step 2- Create DB Connection
		Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PWD);
		// Step 3- Create Statement
		Statement st = conn.createStatement();
		// Step 4- Execute Query
		ResultSet rs = st.executeQuery(SELECT_SQL);
		// Step 5- Process Result
		while (rs.next()) {
			int bookId = rs.getInt("BOOK_ID");
			String bookName = rs.getString("BOOK_NAME");
			Double bookPrice = rs.getDouble("BOOK_PRICE");
			System.out.println("Book_ID:" + bookId);
			System.out.println("Book_Name:" + bookName);
			System.out.println("Book_Price:" + bookPrice);
		}

		// Step 6- Close Connection
		conn.close();

	}

}