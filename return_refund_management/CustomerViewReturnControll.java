package com.jayasadha.return_refund_management;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cusViewReturn")

public class CustomerViewReturnControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		RequestDispatcher dis = request.getRequestDispatcher("viewReturnRequestList.jsp");
		
		int cusID= (int)session.getAttribute("UID");
		
		CustomerViewReturnDBU viewReturn = new CustomerViewReturnDBU();
		
		
		try {
			
			ArrayList<ReturnRequest> list = viewReturn.getCustomerReturnRequests(cusID);
			session.setAttribute("cus_return_req_list", list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dis.forward(request, response);
		
	}

}
