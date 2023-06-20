package com.jayasadha.delivery_management;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LocationInsert")
public class LocationInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Call getParameter method to get location details
		String Locationname = request.getParameter("locname");
		String Locationcharge = request.getParameter("loccharge");
		
		boolean isTrue;
		isTrue = JayasadhaDB.insertLocation(Locationname, Locationcharge);
		
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
