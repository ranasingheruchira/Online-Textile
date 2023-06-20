package com.jayasadha.return_refund_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRequestDBU {
	
	public boolean deleteRequest(int requestID) throws SQLException{
		
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		
		String query = "delete from returnrequest where requestid=?";
		
		PreparedStatement ps;
			
		ps = con.prepareStatement(query);
		ps.setInt(1, requestID);
		return ps.execute();
			
	}

}
