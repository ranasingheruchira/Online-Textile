package com.jayasadha.user_management.util;

public class CommonConstants {

	/** Constant for url key of MySQL database */
	public static final String URL = "jdbc:mysql://localhost:3306/jayasadha";

	/** Constant for user name key of MySQL database */
	public static final String USERNAME = "root";

	/** Constant for password key of MySQL database */
	public static final String PASSWORD = "rbr2373";

	/** Constant for driver name key of MySQL database */
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	
	
	/** Constants for SQL queries */
	public static final String INSERT_CUSTOMER = "insert into user values(0,?,?,?,?,?,?,?,?,?,?,current_date())";

	public static final String VALIDATE_CREDENTIALS = "select * from user where username = ? and password = ? and type != ?";

	public static final String GET_CUSTOMER = "select * from user where username = ? and password = ?";

	public static final String GET_PROFILE = "select * from user where userId = ? and type = ?";

	public static final String UPDATE_PROFILE = "update user set fName=?,lName=?,phone=?,email=?,addrLine1=?,addrLine2=?,addrLine3=?,username=?,password=? where userId=?";

	public static final String DEACTIVATE_CUSTOMER = "update user set type=? where userId=?";

	public static final String VALIDATE_EMAIL = "select * from user where email = ? and type = ?";

	public static final String GET_CONTACT = "select phone from user where email = ?";

	public static final String VALIDATE_PHONE = "select * from user where phone = ?";

	public static final String UPDATE_PASSWORD = "update user set password=? where phone=?";

	public static final String GET_TOTAL = "select count(userId) from user where type = ?";

	public static final String GET_INACTIVE_CUSTOMER_IDS = "SELECT *FROM itp.Inactive_Customers";

	public static final String DELETE_INACTIVE_CUSTOMERS = "delete from user where userId = ?";

	public static final String INSERT_DELETED_CUSTOMER = "insert into deleted_customers values(0,?,?,?,?,?,?,?,?,?,?,?,?)";	

	public static final String GET_JOB = "select * from xyz where eid = ?";
	
}
