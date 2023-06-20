package com.jayasadha.return_refund_management;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/viewOrder")
public class ViewOrderControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//getting ID from the query String
		
		int id = Integer.parseInt(request.getParameter("OID"));
		
		ArrayList <ViewOrder> ViewOrderList =new ArrayList<ViewOrder>();
		ViewOrderDBU d1 = new ViewOrderDBU();
		
		//setting value to the view order list
		
		try {
			ViewOrderList = d1.getViewOrderList(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//setting list into a session;
		
		HttpSession session = request.getSession();
		session.setAttribute("ViewOrder",ViewOrderList);
		session.setAttribute("ret_current_order", id);
		//dispatching to viewOrder.jsp
		
		request.getRequestDispatcher("viewOrder.jsp").forward(request,response);
	}

}
