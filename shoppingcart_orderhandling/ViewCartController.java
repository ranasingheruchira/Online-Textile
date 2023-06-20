package com.jayasadha.shoppingcart_orderhandling;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cart_viewCart")

public class ViewCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		int cusID  = (int)session.getAttribute("UID");
		
		//getting list of items
		
		ViewCartDBU vcd = new ViewCartDBU();
		
		ArrayList<ViewCart> list;
		
		try {
			
			list = vcd.getViewCartList(cusID);
			session.setAttribute("cart_viewCart_list", list);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		request.getRequestDispatcher("cart_viewCart.jsp").forward(request, response);
	}

}
