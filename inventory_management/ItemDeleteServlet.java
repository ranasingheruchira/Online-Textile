package com.jayasadha.inventory_management;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ItemDeleteServlet")
public class ItemDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String ItemID = request.getParameter("iid");
		
		boolean isTrue;
		
		isTrue = ItemDBUtil.Deleteitem(ItemID);
		

		if(isTrue == true) {
					
			List<Item> itemdetails = ItemDBUtil.getitemDetails(ItemID);
			request.setAttribute("itemdetails", itemdetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("Confirm.jsp");
			dis.forward(request, response);
					
		}
		
		
		else {
			
			List<Item> itemdetails = ItemDBUtil.getitemDetails(ItemID);
			request.setAttribute("itemdetails", itemdetails);
			
			
			
			RequestDispatcher dis = request.getRequestDispatcher("Confirm.jsp");
			dis.forward(request, response);
			}	
			
	}

}
