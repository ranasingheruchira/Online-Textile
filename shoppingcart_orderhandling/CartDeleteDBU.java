package com.jayasadha.shoppingcart_orderhandling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartDeleteDBU {
	
	public boolean deleteItemFromCart(int itemID, int cusID) throws SQLException {
	
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		
		String query = "delete from cart where itemid=? and cusid=?";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,itemID);
		ps.setInt(2, cusID);
		
		return ps.execute();
		
	}

}
