package com.jayasadha.return_refund_management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReturnPlacementDBU {
	
	public void insertReturnRequest(int CustoemrID,String customerReason, int OrderID, int ItemID, int replacement,String evidenceImage) throws SQLException {
		
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		String Query = "insert into returnrequest(CustomerID,CusReason,requestDate,OrderID,ItemID,replacement,replacementImages) values(?,?,?,?,?,?,?)";
		
		Date current = new Date(System.currentTimeMillis());
		
		PreparedStatement ps = con.prepareStatement(Query);
		ps.setInt(1, CustoemrID);
		ps.setString(2,customerReason);
		ps.setDate(3,current);
		ps.setInt(4,OrderID);
		ps.setInt(5, ItemID);
		ps.setInt(6, replacement);
		ps.setString(7,evidenceImage);
		
		ps.execute();
		
	}
	

}
