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
@WebServlet("/ConfirmationServlet")
public class ConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter(); 
        response.setContentType("text/html");
		
        String ok = request.getParameter("ok");
        
        if(ok != null) {
        	
        	String first = request.getParameter("first");
        	String last = request.getParameter("last");
        	String key = request.getParameter("key");
        	String phone = first+key+last;
        	
        	boolean isTrue;    		
    		CustomerDBQuery c1 =new CustomerDBQuery();
    		
    		isTrue = c1.validatePhoneNum(phone);
        	
    		if(isTrue==true) {			
    			  
    			request.setAttribute("phone", phone);    			
    			RequestDispatcher display1 = request.getRequestDispatcher("/WEB-INF/views/ResetPassword.jsp");
    			display1.forward(request, response);
    						
    		}else {
    			out.println("<script type='text/javascript'>");
    			out.println("alert('Your security key is incorrect. Try again !');");
    			out.println("location='ForgetPassword.jsp'");
    			out.println("</script>");
    		}
    		
        }else {
        	        	
			RequestDispatcher display1 = request.getRequestDispatcher("ForgetPassword.jsp");
			display1.forward(request, response);
        }
		
	}

}
