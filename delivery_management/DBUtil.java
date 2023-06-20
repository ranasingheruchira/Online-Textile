package com.jayasadha.delivery_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static String url = "jdbc:mysql://localhost:3306/jayasadha";
	private static String user = "root";
	private static String password = "rbr2373";
	private static Connection con; //construct a database connection variable called 'con'
	
	// This works according to singleton pattern
    private DBUtil() {
    }
    
	
	public static Connection getConnection() throws SQLException {
		
		if (con == null || con.isClosed()) {
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			
			
			
		}
		
		catch(Exception e)
		{
			System.out.println("DB Connection is Failed!");
		}
		
		
		}
		return con;
	}
	
	
}
