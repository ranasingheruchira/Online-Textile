package com.jayasadha.inquiry_management;

import java.io.IOException;
//import java.sql.Date;
//import java.text.ParseException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateInquiry
 */
@WebServlet("/UpdateInquiryServlet")
public class UpdateInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String inq_id = request.getParameter("Iq_id");
		String inq_r = request.getParameter("Manager_reply");
		String inq_d2 = request.getParameter("Date_send");
		String inq_s = request.getParameter("Status_type");
		
		

		
		boolean isTrue;
		isTrue = ContactDbUtil.updateinquiry( inq_id,  inq_r, inq_d2, inq_s) ;
		
		if(isTrue == true) {
			RequestDispatcher rd = request.getRequestDispatcher("inqiryManagement.jsp");
			rd.forward(request, response);
		}
		else { 
			
			RequestDispatcher rd2 = request.getRequestDispatcher("contactNotSubmit.jsp");
			rd2.forward(request, response);
		}
		
	}
	
		
		
		
		
		
		
		
		
		
		
		
}	


