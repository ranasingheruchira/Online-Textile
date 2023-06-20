package com.jayasadha.inventory_management;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ItemInsert")
public class ItemInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String ItemName = request.getParameter("ItemN");
		String ItemQuantity = request.getParameter("ItemQ");
		String ItemBrand = request.getParameter("ItemB");
		String ItemCategory = request.getParameter("ItemC");
		String ItemDescription = request.getParameter("ItemD");
		String ItemColor = request.getParameter("ItemColr");
		String ItemPrice = request.getParameter("ItemP");
		String ItemImage = request.getParameter("ItemI");
		
		
		

		
		boolean istrue;
	
		
		
		
		istrue =ItemDBUtil.InsertItem(ItemName, ItemQuantity, ItemBrand, ItemCategory, ItemDescription, ItemColor, ItemPrice,ItemImage);
		
		

		if(istrue == true) {

			
			List<Item> itemdetails = ItemDBUtil.getID(); 
			request.setAttribute("itemdetails", itemdetails); 
			
			//dispatcher to request to success.jsp
			RequestDispatcher dis = request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
			
		}

		
		else {
			
			//dispatcher to request to unsuccess.jsp
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);
			}
		
	}

}