package com.jayasadha.shoppingcart_orderhandling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewCartDBU {
	
	public ArrayList<ViewCart> getViewCartList(int customerID) throws SQLException{
		
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		
		String query = "select * from viewCart where cusID =?";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, customerID);
		
		ResultSet rs = ps.executeQuery();
		
		//adding items to list
		
		ArrayList<ViewCart> list = new ArrayList<ViewCart>();
		ViewCart vc;
		
		int cusID;
		int itemID;
		String itemName;
		double itemPrice;
		String itemImage;
		int itemQuantitty;
		
		while(rs.next()) {
			
			cusID = rs.getInt(1);
			itemID = rs.getInt(2);
			itemName = rs.getString(3);
			itemPrice = rs.getDouble(4);
			itemImage = rs.getString(5);
			itemQuantitty = rs.getInt(6);
			
			vc = new ViewCart(cusID,itemID,itemName,itemPrice,itemImage,itemQuantitty);
			
			list.add(vc);
			
		}
		
		return list;
		
		
	}

}
