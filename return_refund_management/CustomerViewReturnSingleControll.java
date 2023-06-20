package com.jayasadha.return_refund_management;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/viewReturnRequest")

public class CustomerViewReturnSingleControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int requestID = Integer.parseInt(request.getParameter("requestID"));
		
		HttpSession session = request.getSession();
		
		CustomerViewReturnDBU cvr = new CustomerViewReturnDBU();
		
		try {
			
			ReturnRequest rs = cvr.getRequestDetailsForID(requestID);
			session.setAttribute("cus_return_req_view", rs);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("viewReturnRequest.jsp").forward(request, response);
	
	}

}
