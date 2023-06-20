package com.jayasadha.user_management.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jayasadha.employee_higher_management.Employee;
import com.jayasadha.employee_higher_management.JobRole;
import com.jayasadha.user_management.model.Customer;
import com.jayasadha.user_management.util.CommonConstants;
import com.jayasadha.user_management.util.DBConnectionUtil;

public class CustomerDBQuery implements InterfaceCustomerDBQuery {
	
	private static Connection connect = null;
	private static PreparedStatement stmt = null;
	private static ResultSet result = null;	
	
	private static boolean isSuccess = false;
	final String type = "Customer";
	final String type2 = "DCustomer";
	
	//DCustomer - Deactivated customer
	final String type1 = "DCustomer";
	
	/**
	 * method for insert customer details
	 */
	public boolean insertCusDetails(String fName, String lName, String phone, String email, String adrLine1, String adrLine2, String adrLine3, String username, String password) {

		try {
			
			connect = DBConnectionUtil.getDBConnection();			
			
			/*
			 * query is in 'CommonConstants' class & 'INSERT_CUSTOMER' key is used to retrieve the query
			 */
			stmt = connect.prepareStatement(CommonConstants.INSERT_CUSTOMER);			
			
			stmt.setString(1, fName);
			stmt.setString(2, lName);
			stmt.setString(3, phone);
			stmt.setString(4, email);
			stmt.setString(5, adrLine1);
			stmt.setString(6, adrLine2);
			stmt.setString(7, adrLine3);
			stmt.setString(8, username);
			stmt.setString(9, password);
			stmt.setString(10, type);
			
			int results = stmt.executeUpdate();

			/*
			 * check whether the data insertion is success or not
			 */
			if (results > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isSuccess;
	}
	
	
	/**
	 * method for check whether the user name & password exist or not
	 */
	public boolean validateCredentials(String username, String password) {

		try {
			connect = DBConnectionUtil.getDBConnection();			
			
			/*
			 * query is in 'CommonConstants' class & 'VALIDATE_CREDENTIALS' key is used to retrieve the query
			 */
			stmt = connect.prepareStatement(CommonConstants.VALIDATE_CREDENTIALS);
						
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, type2);
						
			result = stmt.executeQuery();

			/*
			 * check whether the execution of the query is success or not
			 */
			if (result.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			 /*
			  * This is a generic Exception handler which can handle all the exceptions.
	          */
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
				
			} catch (SQLException e) {
				/*
				 * SQLException - Thrown when database access error occurs or this method is called on a closed connection
				 */
				e.printStackTrace();
			}
		}

		/**
		 * return a boolean value
		 */
		return isSuccess;
	}
	
	
	/**
	 * method1(for login) for get the customer details 
	 */
	public List<Customer> getCusDetails(String username1, String password1) {

		ArrayList<Customer> CusData = new ArrayList<>();

		try {
			connect = DBConnectionUtil.getDBConnection();
			
			/*
			 * query is in 'CommonConstants' class & 'GET_CUSTOMER' key is used to retrieve the query
			 */
			stmt = connect.prepareStatement(CommonConstants.GET_CUSTOMER);
						
			stmt.setString(1, username1);
			stmt.setString(2, password1);
			
			result = stmt.executeQuery();

			if (result.next()) {
				int userId = result.getInt(1);
				String fName = result.getString(2);
				String lName = result.getString(3);
				String phone = result.getString(4);
				String email = result.getString(5);
				String addrLine1 = result.getString(6);
				String addrLine2 = result.getString(7);
				String addrLine3 = result.getString(8);
				String username = result.getString(9);
				String password = result.getString(10);
				String type = result.getString(11);
				String registerDate = result.getString(12);

				Customer cus = new Customer(userId, fName, lName, phone, email, addrLine1, addrLine2, addrLine3, username, password, type, registerDate);
						
				CusData.add(cus);				
												
			}

		} catch (Exception e) {
			 /*
			  * This is a generic Exception handler which can handle all the exceptions.
	          */
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
				/*
				 * SQLException - Thrown when database access error occurs or this method is called on a closed connection
				 */
				e.printStackTrace();
			}
		}

		/**
		 * return a list of customer details
		 */
		return CusData;
	}

	
	/**
	 * method2(for profile) for get the customer details 
	 */
	public List<Customer> getProfile(String id) {

		ArrayList<Customer> CusData = new ArrayList<>();

		try {
			connect = DBConnectionUtil.getDBConnection();
			
			/*
			 * query is in 'CommonConstants' class & 'GET_CUSTOMER' key is used to retrieve the query
			 */
			stmt = connect.prepareStatement(CommonConstants.GET_PROFILE);
			
			int ids = Integer.parseInt(id);
			
			stmt.setInt(1, ids);
			stmt.setString(2, type);
			result = stmt.executeQuery();

			if (result.next()) {
				int userId = result.getInt(1);
				String fName = result.getString(2);
				String lName = result.getString(3);
				String phone = result.getString(4);
				String email = result.getString(5);
				String addrLine1 = result.getString(6);
				String addrLine2 = result.getString(7);
				String addrLine3 = result.getString(8);
				String username = result.getString(9);
				String password = result.getString(10);
				String type = result.getString(11);
				String registerDate = result.getString(12);


				Customer cus = new Customer(userId, fName, lName, phone, email, addrLine1, addrLine2, addrLine3, username, password, type, registerDate);
						
				CusData.add(cus);				
												
			}

		} catch (Exception e) {
			 /*
			  * This is a generic Exception handler which can handle all the exceptions.
	          */
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
				/*
				 * SQLException - Thrown when database access error occurs or this method is called on a closed connection
				 */
				e.printStackTrace();
			}
		}

		/**
		 * return a list of customer details
		 */
		return CusData;
	}
	
	
	/**
	 * method for update the customer details 
	 */
	public boolean updateCusDetails(String userId, String fName, String lName, String phone, String email, String adrLine1, String adrLine2, String adrLine3, String username, String password) {

		try {
			connect = DBConnectionUtil.getDBConnection();			
			
			/*
			 * query is in 'CommonConstants' class & 'UPDATE_PROFILE' key is used to retrieve the query
			 */
			stmt = connect.prepareStatement(CommonConstants.UPDATE_PROFILE);			
			
			int id = Integer.parseInt(userId);
			
			stmt.setString(1, fName);
			stmt.setString(2, lName);
			stmt.setString(3, phone);
			stmt.setString(4, email);
			stmt.setString(5, adrLine1);
			stmt.setString(6, adrLine2);
			stmt.setString(7, adrLine3);
			stmt.setString(8, username);
			stmt.setString(9, password);
			stmt.setInt(10, id);

			int results = stmt.executeUpdate();

			/*
			 * check whether the data updating is success or not
			 */
			if (results > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			 /*
			  * This is a generic Exception handler which can handle all the exceptions.
	          */
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
				/*
				 * SQLException - Thrown when database access error occurs or this method is called on a closed connection
				 */
				e.printStackTrace();
			}
		}

		/**
		 * return a boolean value
		 */
		return isSuccess;
	}
	
	
	
	/**
	 * method for deactivate customer(update)
	 */
	public boolean deactivateCustomer(String userId) {

		try {
			connect = DBConnectionUtil.getDBConnection();			
			
			/*
			 * query is in 'CommonConstants' class & 'DEACTIVATE_CUSTOMER' key is used to retrieve the query
			 */
			stmt = connect.prepareStatement(CommonConstants.DEACTIVATE_CUSTOMER);			
			
			
			int id = Integer.parseInt(userId);
			
			stmt.setString(1, type1);			
			stmt.setInt(2, id);

			int results = stmt.executeUpdate();

			/*
			 * check whether the data updating is success or not
			 */
			if (results > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			 /*
			  * This is a generic Exception handler which can handle all the exceptions.
	          */
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
				/*
				 * SQLException - Thrown when database access error occurs or this method is called on a closed connection
				 */
				e.printStackTrace();
			}
		}

		/**
		 * return a boolean value
		 */
		return isSuccess;
	}
	
	/**
	 * method for check whether the email exist or not(forget password)
	 */
	public boolean validateEmail(String email) {

		try {
			connect = DBConnectionUtil.getDBConnection();			
			
			/*
			 * query is in 'CommonConstants' class & 'VALIDATE_EMAIL' key is used to retrieve the query
			 */
			stmt = connect.prepareStatement(CommonConstants.VALIDATE_EMAIL);
						
			stmt.setString(1, email);			
			stmt.setString(2, type);
			
			result = stmt.executeQuery();

			/*
			 * check whether the execution of the query is success or not
			 */
			if (result.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			 /*
			  * This is a generic Exception handler which can handle all the exceptions.
	          */
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
				
			} catch (SQLException e) {
				/*
				 * SQLException - Thrown when database access error occurs or this method is called on a closed connection
				 */
				e.printStackTrace();
			}
		}

		/**
		 * return a boolean value
		 */
		return isSuccess;
	}
	
	/**
	 * method for get contact number(forget password)
	 */
	public String getContact(String email) {

		String contact = null;
		
		try {
			connect = DBConnectionUtil.getDBConnection();
			
			/*
			 * query is in 'CommonConstants' class & 'GET_CONTACT' key is used to retrieve the query
			 */
			stmt = connect.prepareStatement(CommonConstants.GET_CONTACT);
						
			stmt.setString(1, email);						
			result = stmt.executeQuery();

			if (result.next()) {
				
				String phone = result.getString(1);
				
				Customer cus = new Customer();
				cus.setPhone(phone);
								
				contact = cus.getPhone();				
						
			}
			
			

		} catch (Exception e) {
			 /*
			  * This is a generic Exception handler which can handle all the exceptions.
	          */
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
				/*
				 * SQLException - Thrown when database access error occurs or this method is called on a closed connection
				 */
				e.printStackTrace();
			}
		}

		/**
		 * return a boolean value
		 */
		return contact;
	}
	
	
	/**
	 * method for check whether the contact number exist or not(Reset password1)
	 */
	public boolean validatePhoneNum(String phone) {

		try {
			connect = DBConnectionUtil.getDBConnection();			
			
			/*
			 * query is in 'CommonConstants' class & 'VALIDATE_PHONE' key is used to retrieve the query
			 */
			stmt = connect.prepareStatement(CommonConstants.VALIDATE_PHONE);
						
			stmt.setString(1, phone);			
						
			result = stmt.executeQuery();

			/*
			 * check whether the execution of the query is success or not
			 */
			if (result.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			 /*
			  * This is a generic Exception handler which can handle all the exceptions.
	          */
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
				
			} catch (SQLException e) {
				/*
				 * SQLException - Thrown when database access error occurs or this method is called on a closed connection
				 */
				e.printStackTrace();
			}
		}

		/**
		 * return a boolean value
		 */
		return isSuccess;
	}
	
	
	/**
	 * method for update the new password
	 */
	public boolean updateNewPassword(String password, String phone) {

		try {
			connect = DBConnectionUtil.getDBConnection();			
			
			/*
			 * query is in 'CommonConstants' class & 'UPDATE_PASSWORD' key is used to retrieve the query
			 */
			stmt = connect.prepareStatement(CommonConstants.UPDATE_PASSWORD);			
						
			stmt.setString(1, password);
			stmt.setString(2, phone);

			int results = stmt.executeUpdate();

			/*
			 * check whether the data updating is success or not
			 */
			if (results > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			 /*
			  * This is a generic Exception handler which can handle all the exceptions.
	          */
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
				/*
				 * SQLException - Thrown when database access error occurs or this method is called on a closed connection
				 */
				e.printStackTrace();
			}
		}

		/**
		 * return a boolean value
		 */
		return isSuccess;
	}
	
	/**
	 * method for get total number of customers
	 */
	public int getToatalCus() {
	
		int total = 0;
		try {
			connect = DBConnectionUtil.getDBConnection();
			
			/*
			 * query is in 'CommonConstants' class & 'GET_TOTAL' key is used to retrieve the query
			 */
			stmt = connect.prepareStatement(CommonConstants.GET_TOTAL);
						
			stmt.setString(1, type);						
			result = stmt.executeQuery();

			if (result.next()) {
				
				total = result.getInt(1);
			}			

		} catch (Exception e) {
			 /*
			  * This is a generic Exception handler which can handle all the exceptions.
	          */
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
				/*
				 * SQLException - Thrown when database access error occurs or this method is called on a closed connection
				 */
				e.printStackTrace();
			}
		}

		/**
		 * return a boolean value
		 */
		return total;
	}
	
	
	
	/**
	 * method for get inactive customer IDs
	 */
	public List<Customer> getInactiveCusIds() {

		ArrayList<Customer> CusData = new ArrayList<>();

		try {
			connect = DBConnectionUtil.getDBConnection();
			
			/*
			 * query is in 'CommonConstants' class & 'GET_INACTIVE_CUSTOMER_IDS' key is used to retrieve the query
			 */
			stmt = connect.prepareStatement(CommonConstants.GET_INACTIVE_CUSTOMER_IDS);
						
			result = stmt.executeQuery();

			while (result.next()) {
				int userId = result.getInt(1);
				/*
				 * String fName = result.getString(2); String lName = result.getString(3);
				 * String phone = result.getString(4); String email = result.getString(5);
				 * String addrLine1 = result.getString(6); String addrLine2 =
				 * result.getString(7); String addrLine3 = result.getString(8); String username
				 * = result.getString(9); String password = result.getString(10); String type =
				 * result.getString(11);
				 * 
				 * 
				 * Customer cus = new Customer(userId, fName, lName, phone, email, addrLine1,
				 * addrLine2, addrLine3, username, password, type);
				 */
				Customer cus = new Customer();
				cus.setUserId(userId);
				
				CusData.add(cus);						
												
			}
			
		} catch (Exception e) {
			 /*
			  * This is a generic Exception handler which can handle all the exceptions.
	          */
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
				/*
				 * SQLException - Thrown when database access error occurs or this method is called on a closed connection
				 */
				e.printStackTrace();
			}
		}

		/**
		 * return a list of customer details
		 */
		return CusData;
	}
	
	
	/**
	 * method for delete customers who are inactive more than 1 year
	 */
	public boolean deleteInactiveCustomers(String id) {

		int userId = Integer.parseInt(id);

		try {
			connect = DBConnectionUtil.getDBConnection();
			
			/*
			 * query is in 'CommonConstants' class & 'DELETE_INACTIVE_CUSTOMERS' key is used to retrieve the query
			 */
			stmt = connect.prepareStatement(CommonConstants.DELETE_INACTIVE_CUSTOMERS);

			stmt.setInt(1, userId);
			
			int result = stmt.executeUpdate();

			/*
			 * check whether the data deletion is success or not
			 */
			if (result > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			 /*
			  * This is a generic Exception handler which can handle all the exceptions.
	          */
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
				/*
				 * SQLException - Thrown when database access error occurs or this method is called on a closed connection
				 */
				e.printStackTrace();
			}
		}

		/**
		 * return a boolean value
		 */
		return isSuccess;
	}
	
	
	/**
	 * method for insert deleted customer details
	 */
	public boolean insertDeletedCusDetails(String id, String fName, String lName, String phone, String email, String adrLine1, String adrLine2, String adrLine3, String username, String password, String type9, String registerDate) {

		try {
			
			connect = DBConnectionUtil.getDBConnection();			
			
			/*
			 * query is in 'CommonConstants' class & 'INSERT_DELETED_CUSTOMER' key is used to retrieve the query
			 */
			stmt = connect.prepareStatement(CommonConstants.INSERT_DELETED_CUSTOMER);			
			
			stmt.setString(1, id);
			stmt.setString(2, fName);
			stmt.setString(3, lName);
			stmt.setString(4, phone);
			stmt.setString(5, email);
			stmt.setString(6, adrLine1);
			stmt.setString(7, adrLine2);
			stmt.setString(8, adrLine3);
			stmt.setString(9, username);
			stmt.setString(10, password);
			stmt.setString(11, type9);
			stmt.setString(12, registerDate);
			
			int results = stmt.executeUpdate();

			/*
			 * check whether the data insertion is success or not
			 */
			if (results > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			/*
			 * This is a generic Exception handler which can handle all the exceptions.
	         */
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
				/*
				 * SQLException - Thrown when database access error occurs or this method is called on a closed connection
				 */
				e.printStackTrace();
			}
		}

		/**
		 * return a boolean value
		 */
		return isSuccess;
	}
	
	
	/**
	 * method for get job description 
	 */	
	
	public String getJobRole(String id) throws ClassNotFoundException, SQLException {
		
		connect = DBConnectionUtil.getDBConnection();
		
		stmt = connect.prepareStatement(CommonConstants.GET_JOB); 
		
		int ids = Integer.parseInt(id);
		
		stmt.setInt(1, ids);			
		result = stmt.executeQuery();
		
		result.next();
		
		return result.getString(1);
	}
	
}
