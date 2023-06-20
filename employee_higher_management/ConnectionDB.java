package com.jayasadha.employee_higher_management;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	
	private static String url = "jdbc:mysql://localhost:3306/jayasadha";
	private static String user = "root";
	private static String pass = "rbr2373";
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, pass);
			
		}
		catch(Exception e) {
			System.out.println("Database connection is unsuccessful!!!");
		}
		
		return con;
	}
}
