package com.jayasadha.user_management.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jayasadha.user_management.service.CustomerDBQuery;

/**
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter(); 
        response.setContentType("text/html");
		
		String pass1 = request.getParameter("password1");
		String pass2 = request.getParameter("password2");
		String phone = request.getParameter("phone");
		
		CustomerDBQuery c1 =new CustomerDBQuery();
							
		if(pass1.equals(pass2)) {
			
			boolean isTrue;
			isTrue = c1.updateNewPassword(pass2, phone);
			

			if(isTrue==true) {		
					
				out.println("<script type='text/javascript'>");
    			out.println("alert('Your password was successfully changed !');");
    			out.println("location='Login.jsp'");
    			out.println("</script>");							
				
			}else {
				RequestDispatcher display2 = request.getRequestDispatcher("/WEB-INF/views/CustomerUnsuccess.jsp");
				display2.forward(request, response);
			}
			
		}else {
			
			out.println("<script type='text/javascript'>");
			out.println("alert('Two passwords are not matching. Try again !');");			
			out.println("</script>");
			request.setAttribute("phone", phone);
			RequestDispatcher display3 = request.getRequestDispatcher("/WEB-INF/views/ResetPassword.jsp");
			display3.include(request, response);
			
		}
		
		
	}

}
