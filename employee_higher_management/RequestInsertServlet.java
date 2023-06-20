package com.jayasadha.employee_higher_management;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RequestInsertServlet")
public class RequestInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String EmpID = request.getParameter("empid");
		String RequiredDate = request.getParameter("requiredDate");
		String AdvanceAmount = request.getParameter("advanceAmount");
		String Reason = request.getParameter("reason");
		
		boolean isTrue;
		
		isTrue = EmployeeDBUtil.insertRequest(EmpID, RequiredDate, AdvanceAmount, Reason);
		
		if(isTrue == true) {
			RequestDispatcher dis1 = request.getRequestDispatcher("ARequestInsertSuccess.jsp");
			dis1.forward(request, response);
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("ARequestInsertUnsuccess.jsp");
			dis2.forward(request, response);
		}
		
		
	}

}
