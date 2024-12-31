package in.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteBook {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "root";
	private static final String DELETE_SQL = "DELETE FROM BOOKS WHERE BOOK_ID =4";

	public static void main(String[] args) throws Exception {
		// Step 1- Load and Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Step 2- Get DB Connection
		Connection conn = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		// Step 3- Create Statement
		Statement st = conn.createStatement();
		// Step 4- Execute Query
		int rowsEffected = st.executeUpdate(DELETE_SQL);
		// Step 5- Process Result
		System.out.println("Delete rows:" + rowsEffected);
		// Step 6- Close Connection
		conn.close();

	}

}
