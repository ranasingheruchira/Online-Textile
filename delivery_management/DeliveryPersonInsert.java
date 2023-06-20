package com.jayasadha.delivery_management;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeliveryPersonInsert")
public class DeliveryPersonInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//int AssignLocationID = Integer.parseInt(request.getParameter("locid"));
				//int AssignDeliveryPersonID = Integer.parseInt(request.getParameter("delid"));
				String AssignLocationID = request.getParameter("locid");
				String AssignDeliveryPersonID = request.getParameter("delid");
				String AssignDate = request.getParameter("date");
				
				int AId = Integer.parseInt(AssignLocationID);
				int ADId = Integer.parseInt( AssignDeliveryPersonID);
				
				boolean isTrue;
				isTrue = JayasadhaDB.insertAddDeliveryPerson(AId, ADId, AssignDate);
				
				if(isTrue == true)
				{
					
					RequestDispatcher dis = request.getRequestDispatcher("Success_DM.jsp");//Create RequestDispatcher class object called 'dis'
					dis.forward(request, response);//RequestDispatcher class dispatching the request to 'success.jsp'file
				}
				
				else
				{
					RequestDispatcher dis2 = request.getRequestDispatcher("Unsuccess_DM.jsp");//Create RequestDispatcher class object called 'dis2'
					dis2.forward(request, response);//RequestDispatcher class dispatching the request to 'success.jsp'file	
				}
				
   }

}