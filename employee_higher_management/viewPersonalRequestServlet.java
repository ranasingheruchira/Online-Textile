package com.jayasadha.employee_higher_management;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/viewPersonalRequestServlet")
public class viewPersonalRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession();
		 
		 String employeeID = (String) session.getAttribute("key");
		
		//String employeeID = request.getParameter("empID");
		
		try {
			List<AdvanceRequest> viewPeronalRequests = EmployeeDBUtil.viewPersonalRequests(employeeID);
			request.setAttribute("viewPeronalRequests", viewPeronalRequests);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("AMyRequests.jsp");
		dis.forward(request, response);		
	}

}

