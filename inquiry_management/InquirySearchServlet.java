package com.jayasadha.inquiry_management;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InquirySearchServlet
 */
@WebServlet("/InquirySearchServlet")
public class InquirySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String search_iq = request.getParameter("search_inqid");
		
		
		try {
			List<Contact> 	search_inq = ContactDbUtil.getInquiry(search_iq);
			request.setAttribute("search_inq",search_inq);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("inquirySearch.jsp");
		dis.forward(request, response);
		
	}

	
}
