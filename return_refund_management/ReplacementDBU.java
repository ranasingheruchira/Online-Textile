package com.jayasadha.return_refund_management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReplacementDBU {
	
	public ArrayList<Replacement> getReplacementList(double maxPrice) throws SQLException{
		
		DBConnection dbc =new DBConnection();
		Connection con = dbc.getConnection();
		
		String query = "select * from shop where itprice<="+"'"+maxPrice+"'";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		String name;
		double price;
		int id;
		String image;
		
		Replacement replacement;
		ArrayList<Replacement> repList = new ArrayList<Replacement> ();
		
		while(rs.next()) {
			
			name = rs.getString("itname");
			price =  rs.getDouble("itprice");
			id = rs.getInt("itid");
			image = rs.getString("itimage");
			
			replacement = new Replacement(price,name,id,image);
			
			repList.add(replacement);
			
		}
		
		return repList;
		
	}
	

}
