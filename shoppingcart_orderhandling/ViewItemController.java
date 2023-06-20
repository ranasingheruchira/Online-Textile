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

@WebServlet("/cart_viewItems")

public class ViewItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		ViewItemDBU vid = new ViewItemDBU();
		
		try {
			
			ArrayList<Shop> list  = vid.getItemList();
			session.setAttribute("cart_view_items", list);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("cart_view_item.jsp").forward(request, response);
		
		
	}


}
