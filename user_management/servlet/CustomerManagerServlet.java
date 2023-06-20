package com.jayasadha.user_management.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jayasadha.user_management.model.Customer;
import com.jayasadha.user_management.service.CustomerDBQuery;

/**
 * Servlet implementation class CustomerManagerServlet
 */
@WebServlet("/CustomerManagerServlet")
public class CustomerManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String fName = null, lName = null, phone = null, email = null, adrLine1 = null, adrLine2 = null, adrLine3 = null, username = null, password = null, type = null, registerDate = null;
		String view = request.getParameter("view");
		String id1 = request.getParameter("userId1");
		String id2 = request.getParameter("userId2");
		
		CustomerDBQuery c1 =new CustomerDBQuery();
		
		if(view != null) {    	
        		        
	        List<Customer> cusDetails = c1.getProfile(id1);
			request.setAttribute("cusDetails", cusDetails);
        	
			request.getRequestDispatcher("/WEB-INF/views/CusProfileManager.jsp").include(request, response);    		
    		
        }else { 
        	
        	List<Customer> cusDetails2 = c1.getProfile(id2);
			request.setAttribute("cusDetails2", cusDetails2);
			
			for(Customer c : cusDetails2) {				
				 fName = c.getfName();
				 lName = c.getlName();
				 phone = c.getPhone();
				 email = c.getEmail();
				 adrLine1 = c.getAddrLine1();
				 adrLine2 = c.getAddrLine2();
				 adrLine3 = c.getAddrLine3();
				 username = c.getUsername();
				 password = c.getPassword();
				 type = c.getType();
				 registerDate = c.getRegisterDate();
			}
			boolean isTrue;
			isTrue = c1.insertDeletedCusDetails(id2, fName, lName, phone, email, adrLine1, adrLine2, adrLine3, username, password, type, registerDate);
			
			if(isTrue==true) {
				
				boolean success;
				success = c1.deleteInactiveCustomers(id2);
				
				if(success==true) {
					/* method for get total customers */
					int total = c1.getToatalCus();
					request.setAttribute("total", total);
	
					/* method for get inactive customer IDs */
					List<Customer> cusData = c1.getInactiveCusIds(); 
					request.setAttribute("cusData", cusData);					
					request.getRequestDispatcher("CustomerManagement.jsp").include(request, response);
				}else {
					RequestDispatcher display2 = request.getRequestDispatcher("/WEB-INF/views/CustomerUnsuccess.jsp");
					display2.forward(request, response);
			    }
				
						
			}else {
				RequestDispatcher display2 = request.getRequestDispatcher("/WEB-INF/views/CustomerUnsuccess.jsp");
				display2.forward(request, response);
			}
        	
        }
		
	}

}
