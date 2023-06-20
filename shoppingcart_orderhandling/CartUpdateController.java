package com.jayasadha.shoppingcart_orderhandling;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateCart")
public class CartUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cusID =Integer.parseInt(request.getParameter("cusID"));
		int itemID = Integer.parseInt(request.getParameter("itemID"));
		int upOrDown = Integer.parseInt(request.getParameter("up"));
		boolean unsuccess =false;
		
		CartUpdateDBU cud = new  CartUpdateDBU();
		
		try {
			unsuccess = cud.cartUpdate(upOrDown, cusID, itemID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//dispatching to cart
		
		if(!unsuccess) {
			request.getRequestDispatcher("cart_viewCart").forward(request, response);
		}
		else
			response.getWriter().print(!unsuccess);
	}

}
