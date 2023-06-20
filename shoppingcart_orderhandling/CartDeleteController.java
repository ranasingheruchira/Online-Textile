package com.jayasadha.shoppingcart_orderhandling;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/cartDelete")
public class CartDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int itemID = Integer.parseInt(request.getParameter("itemID"));
		int cusID = (int)session.getAttribute("UID");
		boolean unsuccess = true;
		
		CartDeleteDBU cdbu = new CartDeleteDBU();
		
		try {
			
			unsuccess = cdbu.deleteItemFromCart(itemID,cusID);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(!unsuccess) {
			
			request.getRequestDispatcher("cart_viewCart").forward(request, response);
			
		}
	}

}
