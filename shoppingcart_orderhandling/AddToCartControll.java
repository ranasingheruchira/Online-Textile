package com.jayasadha.shoppingcart_orderhandling;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addToCart")
public class AddToCartControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int itemID = Integer.parseInt(request.getParameter("IID"));
		int cusID = (int)session.getAttribute("UID");
		boolean unsuccess = true;
		PrintWriter out  = response.getWriter();
		
		AddToCartDBU addtocart = new AddToCartDBU();
		
		try {
			
			unsuccess = addtocart.addToCart(cusID, itemID);
			
		} catch (SQLException e) {
	
			e.printStackTrace();
			
		}
		
		if(!unsuccess) {
			
			response.getWriter().print(!unsuccess);
			
		}
		
	}

}
