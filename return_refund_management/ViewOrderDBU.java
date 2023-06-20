package com.jayasadha.return_refund_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ViewOrderDBU {
	
	DBConnection dbc = new DBConnection();
	
	public ArrayList<ViewOrder> getViewOrderList(int orderID) throws SQLException{
		
		//creating a database connection
		
		Connection con = dbc.getConnection();
		Statement st =con.createStatement();
		
		String query_contain = "select * from ordercontain where OrderID="+orderID;
		String query_item = "select * from shop where itid =?";
		
		PreparedStatement pStatement = con.prepareStatement(query_item);
		pStatement.setInt(1, orderID);
		
		ResultSet rs = st.executeQuery(query_contain);
		ResultSet rs2;
		
		//creating ViewOrderList

		ViewOrder temp;
		ArrayList<ViewOrder> ViewOrderList = new ArrayList<ViewOrder> ();
		
		int ItemID;
		int returnCount;
		int quantity;
		double price;
		String imgLocation;
		String itemName;
		
		while(rs.next()) {
			
			//getting values from orderContains_query
			
			ItemID = rs.getInt(1);
			returnCount = rs.getInt(3);
			quantity = rs.getInt(4);
			
			//getting values from item_query
			
			pStatement.setInt(1, ItemID);
			rs2 = pStatement.executeQuery();
			rs2.next();
			
			price = rs2.getDouble(3);
			imgLocation = rs2.getString(4);
			itemName = rs2.getString(2);
			
			//adding values to View order
			
			temp = new ViewOrder(ItemID,itemName,imgLocation,price,quantity,returnCount);

			ViewOrderList.add(temp);
		}
		
		return ViewOrderList;
		
	}

}

