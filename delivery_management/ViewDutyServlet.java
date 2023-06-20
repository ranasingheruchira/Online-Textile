package com.jayasadha.delivery_management;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewDutyServlet")
public class ViewDutyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Duty = request.getParameter("sDuty");
		
		try {
			List<Order> searchDuty = JayasadhaDB.getMyduties(Duty);
			request.setAttribute("searchDuty", searchDuty);
		}
		catch(Exception e){
		e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("DutyDetails.jsp");
		dis.forward(request, response);
		}
	
}
	


