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
 * Servlet implementation class CusUpdatedServlet
 */
@WebServlet("/CusUpdatedServlet")
public class CusUpdatedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String update = request.getParameter("update");
		//String cancel = request.getParameter("cancel");
		
		CustomerDBQuery c1 =new CustomerDBQuery();
		String userId = request.getParameter("userId");
		
		if(update != null) {			
			
			String fName = request.getParameter("fName");
			String lName = request.getParameter("lName");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String adrLine1 = request.getParameter("adrLine1");
			String adrLine2 = request.getParameter("adrLine2");
			String adrLine3 = request.getParameter("adrLine3");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			boolean isTrue;			
			
			isTrue = c1.updateCusDetails(userId, fName, lName, phone, email, adrLine1, adrLine2, adrLine3, username, password);
			
			if(isTrue==true) {		
				
				try {
					List<Customer> cusDetails = c1.getProfile(userId);
					request.setAttribute("cusDetails", cusDetails);			
					
				} catch (Exception e) {
					e.printStackTrace();
				}			
				RequestDispatcher display = request.getRequestDispatcher("/WEB-INF/views/CustomerProfile.jsp");
				display.forward(request, response);				
				
			}else {
				RequestDispatcher display2 = request.getRequestDispatcher("/WEB-INF/views/CustomerUnsuccess.jsp");
				display2.forward(request, response);
			}
			
		}else {
			
			try {
				List<Customer> cusDetails = c1.getProfile(userId);
				request.setAttribute("cusDetails", cusDetails);			
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
			RequestDispatcher display3 = request.getRequestDispatcher("/WEB-INF/views/CustomerProfile.jsp");
			display3.forward(request, response);	
			
		}
		
	}

}
