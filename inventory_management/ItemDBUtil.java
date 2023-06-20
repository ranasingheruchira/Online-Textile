package com.jayasadha.inventory_management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

public class ItemDBUtil {
	
	private static Connection con = null;
	private static Statement stat = null;
	private static ResultSet rs = null;
	
	
	
	
	
public static boolean validate(String Iname) {
		
		
		boolean isSuccess = false;
		
     
		
		//Validate
		try {
			
			con = ConnectionDB.getConnection();
			stat = (Statement) con.createStatement();
			
			String sql1 = "select * from item where ItemBrand ='"+Iname+"' or ItemCategory='"+Iname+"'";
			
			rs = stat.executeQuery(sql1);
			
			if(rs.next()) {
				
				isSuccess = true;
			}
			
			else {
				isSuccess = false;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}


public static List<Item> getitemDetail(String Iname) {
	
	
	ArrayList<Item> odd = new ArrayList<>();
	
	try {
		
		con = ConnectionDB.getConnection();
		stat = (Statement) con.createStatement();
		
		String sql= "select * from item where ItemBrand= '"+Iname+"' or ItemCategory='"+Iname+"'";
		
		rs = stat.executeQuery(sql);
		
		while(rs.next()) {
			int itemID = rs.getInt(1);
			String itemName  = rs.getString(2);
			String itemQuantity = rs.getString(3);
			String itemBrand = rs.getString(4);
			String itemCategory = rs.getString(5);
			String itemDescription = rs.getString(6);
			String itemColor = rs.getString(7);
			String itemPrice = rs.getString(8);
			String itemImage = rs.getString(9);
			
			Item o = new Item(itemID, itemName, itemQuantity, itemBrand, itemCategory, itemDescription, itemColor, itemPrice, itemImage);
			odd.add(o);
			
		}
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
		
	return odd;
}


	
	
	public static boolean InsertItem(String itemName, String itemQuantity, String itemBrand, String itemCategory,
			String itemDescription, String itemColor, String itemPrice,String itemImage) {
		
	boolean isSuccess = false;
	
	try {
			
		con = ConnectionDB.getConnection();
		stat = (Statement) con.createStatement();
			
			String sql ="insert into item values (0,'"+itemName+"','"+itemQuantity+"','"+itemBrand+"','"+itemCategory+"','"+itemDescription+"','"+itemColor+"','"+itemPrice+"','"+itemImage+"')";
		
		
			int rs = stat.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			
			else {
				isSuccess = false;
			}
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
	
			
			
		return isSuccess;
	}
	
	
public static List<Item> getID() {
		
		
		ArrayList<Item> odd = new ArrayList<>();
		
		try {
			
			con = ConnectionDB.getConnection();
			stat = (Statement) con.createStatement();
			
			String sql= "select * from item";
		
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				int itemID = rs.getInt(1);
				String itemName  = rs.getString(2);
				String itemQuantity = rs.getString(3);
				String itemBrand = rs.getString(4);
				String itemCategory = rs.getString(5);
				String itemDescription = rs.getString(6);
				String itemColor = rs.getString(7);
				String itemPrice = rs.getString(8);
				String itemImage = rs.getString(9);
				
    			Item o = new Item(itemID, itemName, itemQuantity, itemBrand, itemCategory, itemDescription, itemColor, itemPrice, itemImage);
				odd.add(o);
				
			}
		}
			
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return odd;
	}


public static boolean Updateitem(String ItemID, String ItemName, String ItemQuantity, String ItemBrand,
		String ItemCategory, String ItemDescription, String ItemColor, String ItemPrice, String ItemImage) {
	
	boolean isSuccess = false;

	
	try {
		
		con = ConnectionDB.getConnection();
		stat = (Statement) con.createStatement();
		
		String sql ="update item set ItemName = '"+ItemName+"',ItemQuantity ='"+ItemQuantity+"',ItemBrand ='"+ItemBrand+"',ItemCategory ='"+ItemCategory+"',ItemDescription ='"+ItemDescription+"',ItemColor = '"+ItemColor+"',ItemPrice = '"+ItemPrice+"',ItemImage = '"+ItemImage+"' "
				+ "where ItemID = '"+ItemID+"' ";
		
		
		int rs = stat.executeUpdate(sql);
		
		if(rs > 0) {
			isSuccess = true;
		}
		
		else {
			isSuccess = false;
		}
	}
	
	catch(Exception e){
		e.printStackTrace();
	}
	
	
	return isSuccess;
}



public static List<Item> getitemDetails(String itemId) {
	
	
	ArrayList<Item> odd = new ArrayList<>();
	
	try {
		
		con = ConnectionDB.getConnection();
		stat = (Statement) con.createStatement();
		
		String sql= "select * from item";
		
		rs = stat.executeQuery(sql);
		
		while(rs.next()) {
			int itemID = rs.getInt(1);
			String itemName  = rs.getString(2);
			String itemQuantity = rs.getString(3);
			String itemBrand = rs.getString(4);
			String itemCategory = rs.getString(5);
			String itemDescription = rs.getString(6);
			String itemColor = rs.getString(7);
			String itemPrice = rs.getString(8);
			String itemImage = rs.getString(9);
			
			Item o = new Item(itemID, itemName, itemQuantity, itemBrand, itemCategory, itemDescription, itemColor, itemPrice, itemImage);
			odd.add(o);
			
		}
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	
	return odd;
	
}



public static boolean Deleteitem(String ItemID) {
	
	boolean isSuccess = false;
	
	int convIID = Integer.parseInt(ItemID);
	
	try {
		
		con = ConnectionDB.getConnection();
		stat = (Statement) con.createStatement();
		
		String sql ="delete from item where ItemID = '"+convIID+"' ";
		
		int rs = stat.executeUpdate(sql);
		
		if(rs > 0) {
			isSuccess = true;
		}
		
		else {
			isSuccess = false;
		}
	}
	
	catch(Exception e){
		e.printStackTrace();
	}
	
	
	
	return isSuccess;
	
	
}





}
