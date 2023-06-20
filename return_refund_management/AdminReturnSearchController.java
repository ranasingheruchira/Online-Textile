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


@WebServlet("/searchRequest")
public class AdminReturnSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String searchQuery =  request.getParameter("search");
			AdminViewReturnRequestListDBU dbu = new AdminViewReturnRequestListDBU();
			ArrayList<ViewAllReturn> list = new ArrayList<ViewAllReturn>();
			HttpSession session=request.getSession();
			String msg;
			
			try {
				
				//converts the string into number..
				//if exception throws, the search is not about a phone number
				
				Integer.parseInt(searchQuery);
				
				//get results
				
				list = dbu.getAdminReturnListDataSearchByPhone(searchQuery);
				
				//setting the header
				
				msg = "Search results for "+"'"+searchQuery+"'";
				session.setAttribute("ret_admin_list_msg", msg);
				
			}catch(NumberFormatException | SQLException e) {
				
				try {
					
					list = dbu.getAdminReturnListDataSearchByFName(searchQuery);
					msg = "Search results for "+"'"+searchQuery+"'";
					session.setAttribute("ret_admin_list_msg", msg);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
			
			//setting result set for sesion
			session.setAttribute("admin_view_return_list", list);
			request.getRequestDispatcher("ret_Admin_View_requests.jsp").forward(request, response);
	}

}
