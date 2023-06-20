package com.jayasadha.supplier_financial_management;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





public class supplierdb {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/jayasadha";
	private String jdbcUsername = "root";
	private String jdbcPassword ="maatha";

	private static final String INSERT_USERS_SQL = "INSERT INTO supplier" + "  (Supplier_name, Contact_number, Email_address,Address_line1 , Address_line2) VALUES "
			+ " (?, ?, ? , ? , ?);";

	private static final String SELECT_USER_BY_ID = "select Supplier_id,Supplier_name, Contact_number,Email_address,Address_line1,Address_line2 from supplier where Supplier_id =?";
	private static final String SELECT_ALL_USERS = "select * from supplier";
	private static final String DELETE_USERS_SQL = "delete from supplier where Supplier_id = ?;";
	private static final String UPDATE_USERS_SQL = "update supplier set Supplier_name = ?,Contact_number= ?, Email_address =? ,Address_line1 =?, Address_line2 = ? where Supplier_id = ?;";
	
	public supplierdb () {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(supplier user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getContact_no());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getAddress1());
			preparedStatement.setString(5, user.getAddress2());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public supplier selectUser(int id) {
		supplier user = null;
	
		try (Connection connection = getConnection();
			
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("Supplier_name");
				String contact = rs.getString("Contact_number");
				String mail = rs.getString("Email_address");
				String add1 = rs.getString("Address_line1");
				String add2 = rs.getString("Address_line2");
				user = new supplier(id, name,contact , mail, add1, add2);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<supplier> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<supplier> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("Supplier_id");
				String name = rs.getString("Supplier_name");
				String con = rs.getString("Contact_number");
				String email = rs.getString("Email_address");
				String a1 = rs.getString("Address_line1");
				String a2 = rs.getString("Address_line2");
				users.add(new supplier(id,name,con,email,a1,a2));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(supplier user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getContact_no());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getAddress1());
			statement.setString(5, user.getAddress2());
			statement.setInt(6, user.getSid());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	

	public static boolean validate(String id) {
		try {
			con =DBconnect.getConnection();
			stmt= con.createStatement();
			String sql= "select * from supplier where Supplier_name='"+id+"'";
			rs= stmt.executeQuery(sql);
			
			if(rs.next()) {
				isSuccess = true;
			
			}else {
				isSuccess = false;
			}
			
			
			
		}
		
		//sql exception
		catch(SQLException e) {
			e.printStackTrace();
		}
		return isSuccess;
		
	}
	
	public static List<valid> getseller(String Id){
		
		ArrayList <valid> Seller = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from supplier where Supplier_name = '"+Id+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String id =rs.getString(1);
				String name = rs.getString(2);
				String nic =  rs.getString(3);
				String address = rs.getString(4);
				String email = rs.getString(5);
				String contact = rs.getString(6);

				
				valid sel = new valid (id,name,nic,address,email,contact); 
				Seller.add(sel);
			    
			}
		
		}catch(SQLException e){
			
			
		}
		
		return Seller;
	}







}
