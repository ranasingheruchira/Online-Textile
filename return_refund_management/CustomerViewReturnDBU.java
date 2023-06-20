package com.jayasadha.return_refund_management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerViewReturnDBU {
	
	public ArrayList<ReturnRequest> getCustomerReturnRequests(int cusID) throws SQLException{
		
		//creating DBConnection
		
		DBConnection dbc  = new DBConnection();
		Connection con = dbc.getConnection();
		
		String query = "select * from returnrequest where CustomerID=?";
		String query2 = "select itname,itimage,itprice from shop where ITID=?";
		
		PreparedStatement ps  = con.prepareStatement(query);
		PreparedStatement ps2 = con.prepareStatement(query2);
		
		ps.setInt(1, cusID);
		
		ResultSet rs =  ps.executeQuery();
		ResultSet rs2;

		//setting values to the ArrayList
		
		ArrayList<ReturnRequest> list = new ArrayList<ReturnRequest>();
		
		ReturnRequest retreq;
		int RequestID;
		int CustomerID;
		String CustomerReason;
		String Emp_note;
		Date requestDate;
		String status;
		int orderID;
		int ItemID;
		int replacement;
		String relacementImage;
		
		String ItemImage;
		String ItemName;
		double ItemPrice;
		
		String Ret_ItemName;
		double Ret_ItemPrice;
		String Ret_ItemImage;
		
		while(rs.next()) {
			
			RequestID = rs.getInt(1);
			CustomerID =rs.getInt(2);
			CustomerReason = rs.getString(3);
			Emp_note = rs.getString(4);
			requestDate = rs.getDate(5);
			status = rs.getString(6);
			orderID = rs.getInt(7);
			ItemID = rs.getInt(8);
			replacement = rs.getInt(9);
			relacementImage = rs.getString(10);
			
			//getting item name and image from item table
			
			ps2.setInt(1,ItemID);
			rs2 = ps2.executeQuery();
			rs2.next();
			
			ItemImage = rs2.getString(2);
			ItemName = rs2.getString(1);
			ItemPrice = rs2.getDouble(3);
		
			ps2.setInt(1,replacement);
			rs2 = ps2.executeQuery();
			rs2.next();
			
			Ret_ItemName =rs2.getString(1);
			Ret_ItemPrice = rs2.getDouble(3);
			Ret_ItemImage = rs2.getString(2);
			
			retreq = new ReturnRequest(RequestID,CustomerID,CustomerReason,Emp_note,requestDate,
					status,orderID,ItemID,replacement,relacementImage,ItemImage,ItemName,ItemPrice,Ret_ItemImage,Ret_ItemName,Ret_ItemPrice);
			
			list.add(retreq);
			
		}
		
		return list;
		
	}
	
	//this method provides the relevant return request details for given request id;
	
	public ReturnRequest getRequestDetailsForID(int requestID) throws SQLException {
		
		ReturnRequest request;
		
		DBConnection dbc  = new DBConnection();
		Connection con = dbc.getConnection();
		
		String query = "select * from returnrequest where RequestID=?";
		String query2 = "select * from shop where itid=?";
		
		PreparedStatement ps = con.prepareStatement(query);
		PreparedStatement ps2 = con.prepareStatement(query2);
		
		ResultSet rs;
		ResultSet rs2;
		
		ps.setInt(1, requestID);
		rs = ps.executeQuery();
		rs.next();
		
		//setting value to ReturnRequest object
		
			int RequestID = rs.getInt(1);
			int CustomerID = rs.getInt(2) ;
			String CustomerReason = rs.getString(3);
			String Emp_note = rs.getString(4);
			Date requestDate = rs.getDate(5);
			String status = rs.getString(6);
			int orderID = rs.getInt(7);
			int ItemID = rs.getInt(8);
			int replacement = rs.getInt(9);
			String relacementImage = rs.getString(10);
			
			String ItemImage;
			String ItemName;
			double ItemPrice;
			
			String Ret_ItemName;
			double Ret_ItemPrice;
			String Ret_ItemImage;
			
			//to get the item details;
			
				ps2.setInt(1,ItemID);
				rs2 = ps2.executeQuery();
				rs2.next();
				
				ItemName = rs2.getString(2);
				ItemPrice = rs2.getDouble(3);
				ItemImage = rs2.getString(4);
				
			//getting replacement item details
				
				ps2.setInt(1,replacement);
				rs2 = ps2.executeQuery();
				rs2.next();
				
				Ret_ItemName = rs2.getString(2);
				Ret_ItemPrice = rs2.getDouble(3);
				Ret_ItemImage = rs2.getString(4);
				
			//setting values to the ReturnRequest;
				
			request = new ReturnRequest(RequestID,CustomerID,CustomerReason,Emp_note,requestDate,
					status,orderID,ItemID,replacement,relacementImage,ItemImage,ItemName,ItemPrice,	
					Ret_ItemImage,Ret_ItemName,Ret_ItemPrice);
			
			return request;
		
	}
		
}
