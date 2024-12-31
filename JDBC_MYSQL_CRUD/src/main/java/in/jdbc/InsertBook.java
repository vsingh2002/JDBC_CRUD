package in.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertBook {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "root";
	private static final String INSERT_SQL = "INSERT INTO BOOKS VALUES(4,'GoLang',5000)";

	public static void main(String[] args) throws Exception {
		// Step 1- Load and register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Step 2- Get DB Connection
		Connection conn = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		// Step 3- Create Statement
		Statement st = conn.createStatement();
		// Step 4- Execute Query
		int i = st.executeUpdate(INSERT_SQL);
		// Step 5- Process Result
		System.out.println("Records inserted :" + i);
		// Step 6- Close Connection
		conn.close();
	}
}