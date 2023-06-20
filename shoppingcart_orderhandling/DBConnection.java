package com.jayasadha.shoppingcart_orderhandling;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private String username = "root";
	private String password = "rbr2373";
	private String url = "jdbc:mysql://localhost:3306/jayasadha";
	
	//public DBConnection() {}
	
	//this will executes a given query and returns a result set
	
	public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			return con;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

}
