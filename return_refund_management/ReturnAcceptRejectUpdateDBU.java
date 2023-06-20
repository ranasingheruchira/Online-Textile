package com.jayasadha.return_refund_management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReturnAcceptRejectUpdateDBU {
	
	public boolean updateStatus(int requestID, String status, String emp_note) throws SQLException {
		
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		
		String query = "update returnrequest set emp_note=?,status=? where requestID=?"; 
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, emp_note);
		ps.setString(2, status);
		ps.setInt(3, requestID);
		
		return ps.execute();
		
	}
	
	public boolean addToOrder(String address1, String address2, String address3, int cusID, int orderID) throws SQLException{
		
		Date date = new Date(System.currentTimeMillis());
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		String orderType = "Returned";
		
		String query = "insert into jayasadha.order(Order_date,Address_Line_1,Address_Line_2,Address_Line_3,CustomerID,orderType,orderID) values(?,?,?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		
		ps.setDate(1, date);
		ps.setString(2, address1);
		ps.setString(3, address2);
		ps.setString(4, address3);
		ps.setInt(5, cusID);
		ps.setString(6, orderType);
		ps.setInt(7, orderID);
		
		return ps.execute();
		
	}
	
	public boolean addToOrderContain(int orderID, int itemID) throws SQLException {
		
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		
		String query = "insert into ordercontain(iteID,orderid,quantity) values(?,?,?)";	
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setInt(1, itemID);
		ps.setInt(2, orderID);
		ps.setInt(3, 1);
		
		return ps.execute();
		
		
	}

}
