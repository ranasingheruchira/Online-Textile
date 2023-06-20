package com.jayasadha.supplier_financial_management;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String ID = request.getParameter("un");
		
		
		boolean isTrue;
		
		isTrue = supplierdb.validate(ID);	
		
		if(isTrue == true) {
			
			List <valid> sellerDetails = supplierdb.getseller(ID);
			request.setAttribute("sellerDetails", sellerDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("user-list.jsp");
			dis.forward(request, response);
			
		}else {
			
			//bcz this only printwriter is used
			out.println("<script type = 'text/javascript'>");
			out.println ("alert('name not found');");
			out.println("location ='user-list.jsp'");
			out.println("</script>");
		}
		

		}

	

}
