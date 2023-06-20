package com.jayasadha.employee_higher_management;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeInsertServlet")
public class EmployeeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Fname = request.getParameter("fname");
		String Lname = request.getParameter("lname");
		String ContactNo = request.getParameter("contact");
		String Email = request.getParameter("email");
		String Addressline1 = request.getParameter("adline1");
		String Addressline2 = request.getParameter("adline2");
		String City = request.getParameter("city");
		String Username = request.getParameter("uname");
		String Password = request.getParameter("password");
		String Nic = request.getParameter("nic");
		String Dob = request.getParameter("dob");
		String Positionid = request.getParameter("positionid");
		
		
		boolean isTrue1;
		boolean isTrue2;
		
		
		isTrue1 = EmployeeDBUtil.insertNewEUser(Fname, Lname, ContactNo, Email, Addressline1, Addressline2, City, Username, Password);
		
		if(isTrue1 == true) {
			
			isTrue2 = EmployeeDBUtil.insertNewEmployee(Nic, Dob, Positionid);
			
			if(isTrue2 == true) {
				
				RequestDispatcher dis1 = request.getRequestDispatcher("AInsertSuccess.jsp");
				dis1.forward(request, response);
			
			}
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("Unsuccess.jsp");
			dis2.forward(request, response);
		}
		
	}

}
