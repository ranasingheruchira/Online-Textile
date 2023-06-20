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

@WebServlet("/adminViewReturnList")
public class AdminViewReturnListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String status = request.getParameter("status");
		HttpSession session = request.getSession();
		ArrayList<ViewAllReturn>  list = new ArrayList<ViewAllReturn> ();
		String msg = "REQUESTS";
		
		//creating data object
		
		AdminViewReturnRequestListDBU dbu = new AdminViewReturnRequestListDBU();
		
		//checking request type
		
		if(status.equals("all")) {
			
			try {
				
				list = dbu.getAdminReturnListData();
				session.setAttribute("admin_view_return_list", list);
	
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		}else {
			
			try {
				
				list = dbu.getAdminReturnListData(status);
				session.setAttribute("admin_view_return_list", list);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		//creating a message
		//this will be displayed in the header of the list
		
		msg = status.toUpperCase()+" "+msg;
		session.setAttribute("ret_admin_list_msg", msg);
		
		request.getRequestDispatcher("ret_Admin_View_requests.jsp").forward(request, response);
		
	}

}
