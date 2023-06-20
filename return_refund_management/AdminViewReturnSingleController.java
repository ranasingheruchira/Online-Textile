package com.jayasadha.return_refund_management;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminViewReturnSingleController
 */
@WebServlet("/returnAdminViewRequestSingle")
public class AdminViewReturnSingleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int requestID = Integer.parseInt(request.getParameter("requestID"));
		HttpSession session = request.getSession();
		
		AdminViewReturnRequestListDBU d1 = new AdminViewReturnRequestListDBU();
		
		try {
			ArrayList<ViewAllReturn> list = d1.getAdminReturnListData(requestID);
			session.setAttribute("ret_admin_single_return_request", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("ret_admin_view_return_single.jsp").forward(request, response);
		
	}

}
