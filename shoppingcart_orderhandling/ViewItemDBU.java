package com.jayasadha.shoppingcart_orderhandling;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ViewItemDBU {
	
	public ArrayList <Shop> getItemList() throws SQLException{
		
		//creating a db connection
		
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		
		String query ="select * from shop";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		//item attributes
		
			int ItemID;
			String ItemName;
			//int itemQuantitty;
			//String ItemBrand;
			//String ItmCategory;
			//String ItemDescription;
			//String ItemColour;
			double itemPrice;
			String itemImage;
		
			//Item item;
			
			Shop shop;
			
			//ArrayList<Item> list = new ArrayList<Item> ();
			 
			ArrayList<Shop> list = new ArrayList<Shop>();
			
		while(rs.next()) {
			
			ItemID= rs.getInt(1);
			ItemName = rs.getString(2);
			//itemQuantitty = rs.getInt(3);
			//ItemBrand = rs.getString(4);
			//ItmCategory = rs.getString(5);
			//ItemDescription = rs.getString(6);
			//ItemColour =rs.getString(7);
			itemPrice = rs.getDouble(3);
			itemImage = rs.getString(4);
			/*
			item = new Item(ItemID,ItemName,itemQuantitty,ItemBrand,ItmCategory,
					ItemDescription,ItemColour,itemPrice,itemImage);
			*/
			
			shop = new Shop(ItemID,ItemName,itemPrice,itemImage);
			
			//list.add(item);
			
			list.add(shop);
			
		}

		return list;
	}

}
