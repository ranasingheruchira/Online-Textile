package com.jayasadha.delivery_management;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetCountServlet")
public class GetCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Order> OrderDetails1= JayasadhaDB.getPersonCount();
			request.setAttribute("OrderDetails1", OrderDetails1);
		}
		
		catch (Exception e)	{
			e.printStackTrace();
		}
			RequestDispatcher dis = request.getRequestDispatcher("ViewOrderDetails.jsp");
			dis.forward(request, response);
	}

}
