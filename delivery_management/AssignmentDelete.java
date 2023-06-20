package com.jayasadha.delivery_management;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AssignmentDelete")
public class AssignmentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String AssignLocationID = request.getParameter("dtlocid");
		String AssignDeliveryPersonID = request.getParameter("dtelid");
		//String AssignDate = request.getParameter("dtdate");
		
		int AId = Integer.parseInt(AssignLocationID);
		int ADId = Integer.parseInt( AssignDeliveryPersonID);
		
		boolean isTrue;
		
		isTrue = JayasadhaDB.deleteAssignment(AssignLocationID, AssignDeliveryPersonID);
		
		if(isTrue==true) {
			RequestDispatcher dis = request.getRequestDispatcher("DeleteSuccess.jsp");
			dis.forward(request, response);
		}else {
			List<AddDeliveryPerson> assignDeliveryPersonDetails = JayasadhaDB.getAssignDeliveryPersonDetails();
			request.setAttribute("assignDeliveryPersonDetails", assignDeliveryPersonDetails);
			
			
			RequestDispatcher dis = request.getRequestDispatcher("ViewDetails.jsp");
			dis.forward(request, response);
		}
		
	}

}
