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


@WebServlet("/SearchEmployeeServlet")
public class SearchEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String userFname = request.getParameter("userFname");
		
		boolean isTrue;
		
		isTrue = EmployeeDBUtil.validSearchEmployee(userFname);
		
		if(isTrue == true){
		
			try {
					List<Common> comDetails = EmployeeDBUtil.getCommonDetailsByName(userFname);
					request.setAttribute("comDetails", comDetails);
			}
			
			catch(Exception e){
				e.printStackTrace();
			}
			
			RequestDispatcher dis = request.getRequestDispatcher("APersonalEmployeeDetails.jsp");
			dis.forward(request, response);
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('The name you entered does not exists!Please try again!!!');");
			out.println("location='ASearchEmployee.jsp'");
			out.println("</script>");
		}
	}

}
