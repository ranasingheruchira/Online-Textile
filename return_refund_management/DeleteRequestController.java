package com.jayasadha.return_refund_management;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/retDeleteReq")
public class DeleteRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int requestID = Integer.parseInt(request.getParameter("requestID"));
		boolean unsuccessful=true;
		String message = "Delete Unsuccessfull.. Please try Later..!!";
		
		DeleteRequestDBU del = new DeleteRequestDBU();
			
		try {
			
			unsuccessful = del.deleteRequest(requestID);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		if(!unsuccessful) {
			
			message = "Delete Successfull..!!";
			session.setAttribute("ret_msg",message);
			request.getRequestDispatcher("RetSuccess.jsp").forward(request, response);
			
		}else
			response.getWriter().print(message);
		
		
		
		//dispatching to success/error page
		
		
		
	}

}
