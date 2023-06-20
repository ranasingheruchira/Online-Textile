package com.jayasadha.shoppingcart_orderhandling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartUpdateDBU {

	public boolean cartUpdate(int upOrDown, int cusID, int itemID) throws SQLException {
		
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		
		String queryPlus = "update cart set quantity=(quantity+1) where cusID=? and itemid=?";
		String queryMinus = "update cart set quantity=(quantity-1) where cusID=? and itemid=?";
		
		if(upOrDown ==1) {
			
			PreparedStatement ps = con.prepareStatement(queryPlus);
			ps.setInt(1,cusID);
			ps.setInt(2, itemID);
			return ps.execute();
					
		}
		else {
			PreparedStatement ps = con.prepareStatement(queryMinus);
			ps.setInt(1,cusID);
			ps.setInt(2,itemID);
			return ps.execute();
		}
		
		
		
	}
	
}
