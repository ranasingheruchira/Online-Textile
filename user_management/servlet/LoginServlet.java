package com.jayasadha.user_management.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jayasadha.employee_higher_management.Employee;
import com.jayasadha.employee_higher_management.JobRole;
import com.jayasadha.user_management.model.Customer;
import com.jayasadha.user_management.service.CustomerDBQuery;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = 0;
		String type = null, res = null, pid = null;
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		boolean isTrue;

		CustomerDBQuery c1 = new CustomerDBQuery();

		isTrue = c1.validateCredentials(username, password);

		if (isTrue == true) {

			List<Customer> cusDetails = c1.getCusDetails(username, password);
			// request.setAttribute("cusDetails", cusDetails);

			

			for (Customer c : cusDetails) {
				id = c.getUserId();
				type = c.getType();
			}
			String key = String.valueOf(id);
			int key1 = Integer.parseInt(key);

			// Customer c2 = new Customer(); out.print("Welcome, "+name);
			HttpSession session = request.getSession();
			session.setAttribute("key", key);
			session.setAttribute("UID", key1);

			////////////// if else statement to direct admin side/////////////////
			
			if (type.equals("Employee")) {
				
				try {
					res = c1.getJobRole(key);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
//				List<Employee> emp = c1.getPosition(key);				
//				for (Employee r : emp) {					
//					pid = r.getPositionid();
//				}
//				
//				//pid = null
//				System.out.println(pid);
				
//				List<JobRole> emp1 = c1.getJob(key);				
//				for (JobRole r1 : emp1) {					
//					des = r1.getJobDescription();
//				}
				
				if(res.equals("User Manager")) {
					/* method for get total customers */
					int total = c1.getToatalCus();
					request.setAttribute("total", total);
	
					/* method for get inactive customer IDs */
					 List<Customer> cusData = c1.getInactiveCusIds(); 
					 request.setAttribute("cusData", cusData);					
					 request.getRequestDispatcher("CustomerManagement.jsp").include(request, response);
					 
				}else if(res.equals("Inquiry Manager")) {
					request.getRequestDispatcher("inqiryManagement.jsp").include(request, response);
					
				}else if(res.equals("Supplier Manager")) {
					request.getRequestDispatcher("user-list.jsp").include(request, response);
				
				}else if(res.equals("Delivery Manager")) {
					request.getRequestDispatcher("Common.jsp").include(request, response);
				
				}else if(res.equals("Higher Manager")) {
						request.getRequestDispatcher("View.jsp").include(request, response);
						
				}else if(res.equals("Delivery Person")) {
					request.getRequestDispatcher("SearchDuties.jsp").include(request, response);
			    
				}else if(res.equals("Return Manager")) {
					request.getRequestDispatcher("adminViewReturnList?status=all").include(request, response);
					
			    }else if(res.equals("Shop Manager")) {
			    	session.setAttribute("AUserName",username);
			    	session.setAttribute("APassword",password);
					request.getRequestDispatcher("viewEmployeeServlet").include(request, response);
			    }
					
				
					
				
				 
			} else {
				// default
				request.getRequestDispatcher("cart_viewItems").include(request, response);
			}

		} else {
			/*
			 * java script alert for invalid credentials
			 */
			out.println("<script type='text/javascript'>");
			out.println("alert('Sorry, username or password incorrect! !!! Try Again');");
			out.println("location='Login.jsp'");
			out.println("</script>");

		}

		out.close();

	}

}
