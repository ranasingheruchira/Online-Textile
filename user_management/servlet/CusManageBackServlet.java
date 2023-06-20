package com.jayasadha.user_management.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jayasadha.user_management.model.Customer;
import com.jayasadha.user_management.service.CustomerDBQuery;

/**
 * Servlet implementation class CusManageBackServlet
 */
@WebServlet("/CusManageBackServlet")
public class CusManageBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		CustomerDBQuery c1 =new CustomerDBQuery();
		/* method for get total customers */
		int total = c1.getToatalCus();
		request.setAttribute("total", total);

		/* method for get inactive customer IDs */
		 List<Customer> cusData = c1.getInactiveCusIds(); 
		 request.setAttribute("cusData", cusData);					
		 request.getRequestDispatcher("CustomerManagement.jsp").include(request, response);
		
	}

}
