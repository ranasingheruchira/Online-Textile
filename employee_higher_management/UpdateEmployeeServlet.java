package com.jayasadha.employee_higher_management;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("upuid");
		String fname = request.getParameter("upfname");
		String lname = request.getParameter("uplname");
		String contactno = request.getParameter("upcontact");
		String email = request.getParameter("upemail");
		String adline1 = request.getParameter("upadline1");
		String adline2 = request.getParameter("upadline2");
		String city = request.getParameter("upcity");
		String username = request.getParameter("upuname");
		String password = request.getParameter("uppassword");
		String nic = request.getParameter("upnic");
		String dob = request.getParameter("updob");
		String positionid = request.getParameter("uppositionid");
	
		boolean isTrue1;
		boolean isTrue2;
		
		isTrue1 = EmployeeDBUtil.updateUser(id, fname, lname,  contactno, email, adline1, adline2, city, username, password);
		isTrue2 = EmployeeDBUtil.updateEmployee(id, nic, dob, positionid);
	
		if(isTrue1 && isTrue2 == true) {
			
			List<User> userAllDetails = EmployeeDBUtil.getUserDetails(id);
			request.setAttribute("userAllDetails", userAllDetails);
			
			List<Employee> empAllDetails = EmployeeDBUtil.getEmployeeDetails(id);
			request.setAttribute("empAllDetails", empAllDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("AUpdateSuccess.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis = request.getRequestDispatcher("AUpdateUnsuccess.jsp");
			dis.forward(request, response);
		}
	
	}

}


