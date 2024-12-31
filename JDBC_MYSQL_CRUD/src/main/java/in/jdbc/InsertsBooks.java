package in.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

// Taking input from User and perform insert operation using Prepared Statement 
public class InsertsBooks {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "root";
	private static final String INSERT_SQL = "INSERT INTO BOOKS VALUES(?,?,?)";

	public static void main(String[] args) throws Exception {
		// Taking user inputs
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Book Id");
		int id = sc.nextInt();
		System.out.println("Enter the Book Name");
		String name = sc.next();
		System.out.println("Enter the Book Price");
		double price = sc.nextDouble();
		// Step 1- Load and Register Driver
		// Class.forName("com.mysql.cj.jdbc.Driver");
		// Step 2- Get DB Connection
		Connection conn = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		System.out.println(conn);
		// Step 3- Create Statement
		PreparedStatement ps = conn.prepareStatement(INSERT_SQL);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setDouble(3, price);
		// Step 4- Execute Query
		int i = ps.executeUpdate();
		// Step 5- Process Result
		System.out.println("Rows effected :" + i);
		// Step 6- Close Connection
		conn.close();

	}

}
