package com.jayasadha.return_refund_management;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Order")
public class OrderControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//in here we should get a list of order objects for given session ID
		//then redirect it to the ViewOrder.jsp with the list of order objects
		
		HttpSession session = request.getSession();
		int userID = (int)session.getAttribute("UID");
		ArrayList <Orders> OrderList = new ArrayList<Orders> ();
		RequestDispatcher dis;
		
		orderDBU od1 = new orderDBU();
		
		try {
			OrderList = od1.getOrdersList(userID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//adding the order list as a session
		
		session.setAttribute("Orders", OrderList);
		
		//dispatching into viewOrder.jsp
		
		dis = request.getRequestDispatcher("viewOrderHistory.jsp");
		dis.forward(request, response);
		
	}

}
