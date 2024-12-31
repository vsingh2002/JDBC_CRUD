package in.jdbc;

// Using PreparedStatement
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertsBook {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "root";
	private static final String INSERT_SQL = "INSERT INTO BOOKS VALUES(?,?,?)";

	public static void main(String[] args) throws Exception {
		// Step 1- Load and Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Step 2- Get DB Connection
		Connection conn = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		// Step 3- Create Statement
		PreparedStatement ps = conn.prepareStatement(INSERT_SQL);
		ps.setInt(1,5);
		ps.setString(2, "AWS");
		ps.setInt(3, 2000);
		// Step 4- Execute Query
		int count = ps.executeUpdate();
		// Step 5- Process Result
		System.out.println("Rows inserted:" + count);
		// Step 6- Close Connection
		conn.close();

	}

}