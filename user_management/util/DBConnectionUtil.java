package com.jayasadha.user_management.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {

	private static Connection connect;

	// This works according to singleton pattern
	private DBConnectionUtil() {
	}

	public static Connection getDBConnection() throws SQLException, ClassNotFoundException {

		if (connect == null || connect.isClosed()) {

			Class.forName(CommonConstants.DRIVER_NAME);
			connect = DriverManager.getConnection(CommonConstants.URL, CommonConstants.USERNAME,
					CommonConstants.PASSWORD);
		}

		return connect;
	}
	
}
