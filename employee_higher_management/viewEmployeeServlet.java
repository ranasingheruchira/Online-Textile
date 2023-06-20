package com.jayasadha.employee_higher_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/viewEmployeeServlet")
public class viewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username = (String) session.getAttribute("AUserName");
		String password= (String) session.getAttribute("APassword");
		
	//	String username = request.getParameter("uname");
		//String password = request.getParameter("password");
		
		boolean isTrue;
		
		isTrue = EmployeeDBUtil.validateNew(username, password);
		
		if(isTrue) {
			List<User> empDetails = EmployeeDBUtil.getOnlyUser(username);
			request.setAttribute("empDetails", empDetails); 
			
			RequestDispatcher dis = request.getRequestDispatcher("AEmployeeAccount.jsp");
			dis.forward(request, response);
		}else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect!Please try again!!!');");
			out.println("location='AViewEmployee.jsp'");
			out.println("</script>");
		}
		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username = (String) session.getAttribute("AUserName");
		String password= (String) session.getAttribute("APassword");
		
	//	String username = request.getParameter("uname");
		//String password = request.getParameter("password");
		
		boolean isTrue;
		
		isTrue = EmployeeDBUtil.validateNew(username, password);
		
		if(isTrue) {
			List<User> empDetails = EmployeeDBUtil.getOnlyUser(username);
			request.setAttribute("empDetails", empDetails); 
			
			RequestDispatcher dis = request.getRequestDispatcher("AEmployeeAccount.jsp");
			dis.forward(request, response);
		}else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect!Please try again!!!');");
			out.println("location='AViewEmployee.jsp'");
			out.println("</script>");
		}
		
	}
	

}
