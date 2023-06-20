package com.jayasadha.inventory_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		
		
		String Iname = request.getParameter("Itname");
		
		
		boolean istrue;
		
		istrue =ItemDBUtil.validate(Iname);
		
		
		
		if(istrue == true) {
			
			
			
			
			
			List<Item> itemdetails =ItemDBUtil.getitemDetail(Iname);
			request.setAttribute("itemdetails", itemdetails);
			
			
			
			RequestDispatcher dis = request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
			
			
		}
		
		
		else {
			
			out.println("<script type = 'text/javascript'>");
			out.println("alert ('You entered Incorrect details');");
			out.println("location ('View.jsp');");
			out.println("</script>");
			}
		
	}
}