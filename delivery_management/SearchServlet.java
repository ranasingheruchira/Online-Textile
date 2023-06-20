package com.jayasadha.delivery_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String oDate = request.getParameter("odate");
		
		boolean isTrue;
		isTrue = JayasadhaDB.validSearchDate(oDate);
		
		if(isTrue == true) {
		try {
			List<Order> searchOrder = JayasadhaDB.getSearch(oDate);
			request.setAttribute("searchOrder", searchOrder);
		}
		catch(Exception e){
		e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("SearchDetails.jsp");
		dis.forward(request, response);
		}
		
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('The date you entered does not exists!Please try again!!!');");
			out.println("location='SearchByDate.jsp'");
			out.println("</script>");
			}
	}
		
		
}



