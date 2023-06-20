package com.jayasadha.inventory_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	
	private static String URL = "jdbc:mysql://localhost:3306/jayasadha";
	private static String username = "root";
	private static String password = "rbr2373";
	private static Connection con;
	
	//This works according to singelton pattern
	private ConnectionDB(){
	
	}
	
	public static Connection getConnection() throws SQLException{
		
		if(con == null || con.isClosed()){
		
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection(URL, username, password);
				
			}
			catch(Exception e){
				System.out.println("Databse is not connected successfully");
				e.printStackTrace();
			}
		
		}		
		return con;
	}

}
