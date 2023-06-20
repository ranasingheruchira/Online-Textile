package com.jayasadha.inventory_management;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ItemUpdate")
public class ItemUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


		
		String ItemID = request.getParameter("iid");
		String ItemName = request.getParameter("name");
		String ItemQuantity= request.getParameter("quantity");
		String ItemBrand = request.getParameter("brand");
		String ItemCategory = request.getParameter("category");
		String ItemDescription = request.getParameter("description");
		String ItemColor = request.getParameter("color");
		String ItemPrice = request.getParameter("price");
		String ItemImage = request.getParameter("image");
		
		
		boolean isTrue;
		
		isTrue = ItemDBUtil.Updateitem(ItemID, ItemName, ItemQuantity, ItemBrand, ItemCategory, ItemDescription, ItemColor, ItemPrice, ItemImage);

		if(isTrue == true) {
			
			
					
			List<Item> itemdetails = ItemDBUtil.getitemDetails(ItemID);
			request.setAttribute("itemdetails", itemdetails);
			
			
			
			
			
			
			
			
			
			RequestDispatcher dis = request.getRequestDispatcher("Confirm.jsp");
			dis.forward(request, response);
			
			
			
					
		}
		
		
		else {
			
			List<Item> itemdetails = ItemDBUtil.getitemDetails(ItemID);
			request.setAttribute("itemdetails", itemdetails);
			
			
			RequestDispatcher dis = request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
			}	
			
		
	}

}
