package com.jayasadha.shoppingcart_orderhandling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddToCartDBU {
	
	public boolean addToCart(int cusID, int ItemID) throws SQLException {
		
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		
		String query = "insert into cart(cusid,itemid) values(?,?)";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setInt(1, cusID);
		ps.setInt(2, ItemID);
		
		return ps.execute();
		
	}

}
