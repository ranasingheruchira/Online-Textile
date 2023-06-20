package com.jayasadha.employee_higher_management;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteRequestsServlet")
public class DeleteRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("reqid");
		
		boolean isTrue1;
		boolean isTrue2;
		
		isTrue2 = EmployeeDBUtil.deleteRequestValidity(id);
		
		if(isTrue2 == true){

			isTrue1 = EmployeeDBUtil.deleteRequest(id);
			
			if(isTrue1 == true) {
			
				RequestDispatcher dis1 = request.getRequestDispatcher("AReqDeleteValid.jsp");
				dis1.forward(request, response);
			}
		}else {
		
			RequestDispatcher dis2 = request.getRequestDispatcher("AReqDeleteInvalid.jsp");
			dis2.forward(request, response);
		}
		
	}

}