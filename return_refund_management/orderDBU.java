package com.jayasadha.return_refund_management;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class orderDBU {

	//getting all the orders into a data structure [order object] for the given user id
	
	public ArrayList <Orders> getOrdersList(int userID) throws SQLException{
		
		//getting a result set about the orders
		
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		String query = "select * from jayasadha.order where customerid=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, userID);
		
		ResultSet rs = ps.executeQuery();
		
		Orders order;
		ArrayList<Orders> orderList = new ArrayList <Orders>();
		
		//creating a list of Orders
		
		while(rs.next()) {

			order = new Orders(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getString(7),rs.getInt(8),rs.getString(10));
			
			orderList.add(order);
		}
		
		return orderList;
		
	}
	

}
