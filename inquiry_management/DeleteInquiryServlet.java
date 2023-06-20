package com.jayasadha.inquiry_management;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteInquiryServlet
 */
@WebServlet("/DeleteInquiryServlet")
public class DeleteInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 String con_id = request.getParameter("co_id");
		
		 
		 
		 boolean isTrue;
			isTrue = ContactDbUtil.deleteinquiry(con_id) ;
			
			if(isTrue == true) {
				RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
				rd.forward(request, response);
			}
			else { 
				
				RequestDispatcher rd2 = request.getRequestDispatcher("contactNotSubmit.jsp");
				rd2.forward(request, response);
			}
			
	}

}
