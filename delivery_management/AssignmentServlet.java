package com.jayasadha.delivery_management;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AssignmentServlet")
public class AssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			List<AddDeliveryPerson> assignDeliveryPersonDetails = JayasadhaDB.getAssignDeliveryPersonDetails();
			request.setAttribute("assignDeliveryPersonDetails", assignDeliveryPersonDetails);
		}
		
		catch (Exception e)	{
			e.printStackTrace();
		}
			RequestDispatcher dis = request.getRequestDispatcher("ViewDetails.jsp");
			dis.forward(request, response);
		
	}

}
