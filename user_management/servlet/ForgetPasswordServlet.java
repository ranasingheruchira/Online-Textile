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
 * Servlet implementation class ForgetPasswordServlet
 */
@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter(); 
        response.setContentType("text/html");
		
        String ok = request.getParameter("ok");
        
        if(ok != null) {
        	
        	String mail = request.getParameter("mail");
    		
    		boolean isTrue;
    		
    		CustomerDBQuery c1 =new CustomerDBQuery();
    		
    		isTrue = c1.validateEmail(mail);
    		
    		if(isTrue==true) {			
    			
    			String con = c1.getContact(mail);    			
    			
    			String first = con.substring(0,2);
    			String last = con.substring(8,10);
    			String mid = "* * * * * *";
    			String full = first+mid+last; 
    			
    			request.setAttribute("first", first);
    			request.setAttribute("last", last);
    			request.setAttribute("full", full);	
    			
    			RequestDispatcher display1 = request.getRequestDispatcher("/WEB-INF/views/ConfirmKey.jsp");
    			display1.forward(request, response);
    						
    		}else {
    			out.println("<script type='text/javascript'>");
    			out.println("alert('Your email is not matching. Try again !');");
    			out.println("location='ForgetPassword.jsp'");
    			out.println("</script>");
    		}
        	
        }else {
        	
        	RequestDispatcher display1 = request.getRequestDispatcher("Login.jsp");
			display1.forward(request, response);
        	
        }
        
        
		
		
	}

}
