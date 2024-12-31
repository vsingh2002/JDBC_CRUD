
package in.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateBook {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_USERNAME = "root";
	private static final String DB_PWD = "root";
	private static final String UPDATE_SQL = "UPDATE books SET BOOK_NAME='C' WHERE BOOK_ID=1 ";

	public static void main(String[] args) throws Exception {
		// Step 1- Load and Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Step 2- Create DB Connection
		Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PWD);
		// Step 3- Create Statement
		Statement st = conn.createStatement();
		// Step 4- Execute Query
		int i = st.executeUpdate(UPDATE_SQL);
		// Step 5- Process Result
		System.out.println("Update Rows:" + i);
		// Step 6- Close Connection
		conn.close();

	}

}
