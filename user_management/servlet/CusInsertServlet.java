package com.jayasadha.user_management.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jayasadha.user_management.service.CustomerDBQuery;

/**
 * Servlet implementation class CusInsertServlet
 */
@WebServlet("/CusInsertServlet")
public class CusInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		CustomerDBQuery c1 =new CustomerDBQuery();
		
		isTrue = c1.insertCusDetails(fName, lName, phone, email, adrLine1, adrLine2, adrLine3, username, password);
		
		if(isTrue==true) {			
			
			RequestDispatcher display1 = request.getRequestDispatcher("Login.jsp");
			display1.forward(request, response);			
		}else {
			RequestDispatcher display2 = request.getRequestDispatcher("/WEB-INF/views/CustomerUnsuccess.jsp");
			display2.forward(request, response);
		}
				
	}

}
