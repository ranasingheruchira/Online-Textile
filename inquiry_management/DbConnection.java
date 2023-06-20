package com.jayasadha.inquiry_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private static Connection connect;

	 // This works according to singleton pattern
	private DbConnection() {
	}

	 public static Connection getDBConnection() throws SQLException, ClassNotFoundException {

	 if (connect == null || connect.isClosed()) {

	   Class.forName("com.mysql.jdbc.Driver");
	  connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jayasadha","root","rbr2373");
	  System.out.println("Success");
	}
	 else {
		 System.out.println("Unsuccess");
	 }

	 return connect;
	}
	 

}
