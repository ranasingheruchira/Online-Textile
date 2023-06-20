package com.jayasadha.return_refund_management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class AdminViewReturnRequestListDBU {
	
	private int requestID;
	private Date requestDate;
	private String requestStatus;
	private int customerID;
	private String cusFname;
	private String cusLname;
	private String cusEmail;
	private String cusPhone;
	private String cusAddress1;
	private String cusAddress2;
	private String cusAddress3;
	private int orderID;
	private Date orderDate;
	private Date deliveryDate;
	private int itemID;
	private String itemName;
	private double itemPrice;
	private String itemImage;
	private int reolacementID;
	private String replacementName;
	private double replacementPrice;
	private String replacementImage;
	private String cusReason;
	private String empNote;
	private String evidenceImage;
	
	public ArrayList<ViewAllReturn> getAdminReturnListData() throws SQLException{
		
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		
		String query = "select * from allreturnrequest";
		
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		//adding date into view all return 
		
		ViewAllReturn var;
		ArrayList<ViewAllReturn> list = new ArrayList<ViewAllReturn>();
		
		while(rs.next()) {
			
			  requestID= rs.getInt(1);
			  requestDate= rs.getDate(2);
			  requestStatus= rs.getString(3);
			  customerID= rs.getInt(4);
			  cusFname= rs.getString(5);
			  cusLname= rs.getString(6);
			  cusEmail = rs.getString(7);
			  cusPhone= rs.getString(8);
			  cusAddress1= rs.getString(9);
			  cusAddress2= rs.getString(10);
			  cusAddress3= rs.getString(11);
			  orderID= rs.getInt(12);
			  orderDate= rs.getDate(13);
			  deliveryDate= rs.getDate(14);
			  itemID= rs.getInt(15);
			  itemName= rs.getString(16);
			  itemPrice= rs.getDouble(17);
			  itemImage= rs.getString(18);
			  reolacementID= rs.getInt(19);
			  replacementName= rs.getString(20);
			  replacementPrice= rs.getDouble(21);
			  replacementImage= rs.getString(22);
			  cusReason= rs.getString(23);
			  empNote= rs.getString(24);
			  evidenceImage= rs.getString(25);
			
			  var = new ViewAllReturn(requestID,requestDate,requestStatus,customerID,cusFname,
					  cusLname,cusEmail,cusPhone,cusAddress1,cusAddress2,
					  cusAddress3,orderID,orderDate,deliveryDate,itemID,itemName,
					  itemPrice,itemImage,reolacementID,replacementName,replacementPrice,
					  replacementImage,cusReason,empNote,evidenceImage);
			  
			  list.add(var);
			
		}
		
		return list;
		
	}
	
	public ArrayList<ViewAllReturn> getAdminReturnListData(String status) throws SQLException{
		
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		
		String query = "select * from allreturnrequest where RequestStatus="+"'"+status+"'";
		
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		//adding date into view all return 
		
		ViewAllReturn var;
		ArrayList<ViewAllReturn> list = new ArrayList<ViewAllReturn>();
		
		while(rs.next()) {
			
			  requestID= rs.getInt(1);
			  requestDate= rs.getDate(2);
			  requestStatus= rs.getString(3);
			  customerID= rs.getInt(4);
			  cusFname= rs.getString(5);
			  cusLname= rs.getString(6);
			  cusEmail = rs.getString(7);
			  cusPhone= rs.getString(8);
			  cusAddress1= rs.getString(9);
			  cusAddress2= rs.getString(10);
			  cusAddress3= rs.getString(11);
			  orderID= rs.getInt(12);
			  orderDate= rs.getDate(13);
			  deliveryDate= rs.getDate(14);
			  itemID= rs.getInt(15);
			  itemName= rs.getString(16);
			  itemPrice= rs.getDouble(17);
			  itemImage= rs.getString(18);
			  reolacementID= rs.getInt(19);
			  replacementName= rs.getString(20);
			  replacementPrice= rs.getDouble(21);
			  replacementImage= rs.getString(22);
			  cusReason= rs.getString(23);
			  empNote= rs.getString(24);
			  evidenceImage= rs.getString(25);
			
			  var = new ViewAllReturn(requestID,requestDate,requestStatus,customerID,cusFname,
					  cusLname,cusEmail,cusPhone,cusAddress1,cusAddress2,
					  cusAddress3,orderID,orderDate,deliveryDate,itemID,itemName,
					  itemPrice,itemImage,reolacementID,replacementName,replacementPrice,
					  replacementImage,cusReason,empNote,evidenceImage);
			  
			  list.add(var);
			
		}
		
		return list;
		
	}
	
	public ArrayList<ViewAllReturn> getAdminReturnListData(int srequestid) throws SQLException{
		
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		
		String query = "select * from allreturnrequest where RequestID=?";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, srequestid);
		ResultSet rs = ps.executeQuery();
		
		//adding date into view all return 
		
		ViewAllReturn var;
		ArrayList<ViewAllReturn> list = new ArrayList<ViewAllReturn>();
		
		while(rs.next()) {
			
			  requestID= rs.getInt(1);
			  requestDate= rs.getDate(2);
			  requestStatus= rs.getString(3);
			  customerID= rs.getInt(4);
			  cusFname= rs.getString(5);
			  cusLname= rs.getString(6);
			  cusEmail = rs.getString(7);
			  cusPhone= rs.getString(8);
			  cusAddress1= rs.getString(9);
			  cusAddress2= rs.getString(10);
			  cusAddress3= rs.getString(11);
			  orderID= rs.getInt(12);
			  orderDate= rs.getDate(13);
			  deliveryDate= rs.getDate(14);
			  itemID= rs.getInt(15);
			  itemName= rs.getString(16);
			  itemPrice= rs.getDouble(17);
			  itemImage= rs.getString(18);
			  reolacementID= rs.getInt(19);
			  replacementName= rs.getString(20);
			  replacementPrice= rs.getDouble(21);
			  replacementImage= rs.getString(22);
			  cusReason= rs.getString(23);
			  empNote= rs.getString(24);
			  evidenceImage= rs.getString(25);
			
			  var = new ViewAllReturn(requestID,requestDate,requestStatus,customerID,cusFname,
					  cusLname,cusEmail,cusPhone,cusAddress1,cusAddress2,
					  cusAddress3,orderID,orderDate,deliveryDate,itemID,itemName,
					  itemPrice,itemImage,reolacementID,replacementName,replacementPrice,
					  replacementImage,cusReason,empNote,evidenceImage);
			  
			  list.add(var);
			
		}
		
		return list;
		
	}
	
	
	//search by phone
	
	public ArrayList<ViewAllReturn> getAdminReturnListDataSearchByPhone(String phone) throws SQLException{
		
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		
		String query = "select * from allreturnrequest where CusPhone="+"'"+phone+"'";
		
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		//adding date into view all return 
		
		ViewAllReturn var;
		ArrayList<ViewAllReturn> list = new ArrayList<ViewAllReturn>();
		
		while(rs.next()) {
			
			  requestID= rs.getInt(1);
			  requestDate= rs.getDate(2);
			  requestStatus= rs.getString(3);
			  customerID= rs.getInt(4);
			  cusFname= rs.getString(5);
			  cusLname= rs.getString(6);
			  cusEmail = rs.getString(7);
			  cusPhone= rs.getString(8);
			  cusAddress1= rs.getString(9);
			  cusAddress2= rs.getString(10);
			  cusAddress3= rs.getString(11);
			  orderID= rs.getInt(12);
			  orderDate= rs.getDate(13);
			  deliveryDate= rs.getDate(14);
			  itemID= rs.getInt(15);
			  itemName= rs.getString(16);
			  itemPrice= rs.getDouble(17);
			  itemImage= rs.getString(18);
			  reolacementID= rs.getInt(19);
			  replacementName= rs.getString(20);
			  replacementPrice= rs.getDouble(21);
			  replacementImage= rs.getString(22);
			  cusReason= rs.getString(23);
			  empNote= rs.getString(24);
			  evidenceImage= rs.getString(25);
			
			  var = new ViewAllReturn(requestID,requestDate,requestStatus,customerID,cusFname,
					  cusLname,cusEmail,cusPhone,cusAddress1,cusAddress2,
					  cusAddress3,orderID,orderDate,deliveryDate,itemID,itemName,
					  itemPrice,itemImage,reolacementID,replacementName,replacementPrice,
					  replacementImage,cusReason,empNote,evidenceImage);
			  
			  list.add(var);
			
		}
		
		return list;
		
	}
	
	public ArrayList<ViewAllReturn> getAdminReturnListDataSearchByFName(String name) throws SQLException{
		
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		
		String query = "select * from allreturnrequest where CusFname="+"'"+name+"'";
		
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		//adding date into view all return 
		
		ViewAllReturn var;
		ArrayList<ViewAllReturn> list = new ArrayList<ViewAllReturn>();
		
		while(rs.next()) {
			
			  requestID= rs.getInt(1);
			  requestDate= rs.getDate(2);
			  requestStatus= rs.getString(3);
			  customerID= rs.getInt(4);
			  cusFname= rs.getString(5);
			  cusLname= rs.getString(6);
			  cusEmail = rs.getString(7);
			  cusPhone= rs.getString(8);
			  cusAddress1= rs.getString(9);
			  cusAddress2= rs.getString(10);
			  cusAddress3= rs.getString(11);
			  orderID= rs.getInt(12);
			  orderDate= rs.getDate(13);
			  deliveryDate= rs.getDate(14);
			  itemID= rs.getInt(15);
			  itemName= rs.getString(16);
			  itemPrice= rs.getDouble(17);
			  itemImage= rs.getString(18);
			  reolacementID= rs.getInt(19);
			  replacementName= rs.getString(20);
			  replacementPrice= rs.getDouble(21);
			  replacementImage= rs.getString(22);
			  cusReason= rs.getString(23);
			  empNote= rs.getString(24);
			  evidenceImage= rs.getString(25);
			
			  var = new ViewAllReturn(requestID,requestDate,requestStatus,customerID,cusFname,
					  cusLname,cusEmail,cusPhone,cusAddress1,cusAddress2,
					  cusAddress3,orderID,orderDate,deliveryDate,itemID,itemName,
					  itemPrice,itemImage,reolacementID,replacementName,replacementPrice,
					  replacementImage,cusReason,empNote,evidenceImage);
			  
			  list.add(var);
			
		}
		
		return list;
		
	}
	
	

}
