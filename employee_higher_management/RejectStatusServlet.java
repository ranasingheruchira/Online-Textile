package com.jayasadha.employee_higher_management;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RejectStatusServlet")
public class RejectStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("reqid");
		String reqStatus = request.getParameter("status");

		boolean isTrue;

		isTrue = EmployeeDBUtil.RejectRequest(id, reqStatus);

		if(isTrue == true){
			
			List<AdvanceRequest> checkAllRequests = EmployeeDBUtil.checkAvailableRequests();
			request.setAttribute("checkAllRequests", checkAllRequests);
			
			RequestDispatcher dis1 = request.getRequestDispatcher("ADisplayAvailableRequests.jsp");
			dis1.forward(request, response);
			
		}else{

			RequestDispatcher dis2 = request.getRequestDispatcher("Invalid.jsp");
			dis2.forward(request, response);
		}
	}
	
}
