package com.jayasadha.inventory_management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

public class ShopDButil {
	
	
	
	
	private static Connection con = null;
	private static Statement stat = null;
	private static ResultSet rs = null;
	
	
	
	
	public static boolean Insert(String iTName, String iTPrice, String iTImage) {
		boolean isSuccess = false;
		
		try {
				
			con = ConnectionDB.getConnection();
			stat = (Statement) con.createStatement();
				
				String sql ="insert into shop values (0,'"+iTName+"','"+iTPrice+"','"+iTImage+"')";
			
			
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
	
	
public static List<Shop> getid() {
		
		
		ArrayList<Shop> odd = new ArrayList<>();
		
		try {
			
			con = ConnectionDB.getConnection();
			stat = (Statement) con.createStatement();
			
			String sql= "select * from shop where ITID= (Select max(itID) from shop) ";
		
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				int itID = rs.getInt(1);
				String itName  = rs.getString(2);
				String itPrice = rs.getString(3);
				String itImage = rs.getString(4);
				
				
    			Shop o = new Shop(itID, itName, itPrice, itImage);
				odd.add(o);
				
			}
		}
			
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return odd;
	}




}
