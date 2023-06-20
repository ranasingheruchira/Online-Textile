package com.jayasadha.inquiry_management;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter(); 
        response.setContentType("text/html"); 
		
        String fname = request.getParameter("Fname");
		String lname = request.getParameter("Lname");
		String mobile = request.getParameter("Mobile");
		String type = request.getParameter("Inquiry");
		String message = request.getParameter("Message");
        
		HttpSession session=request.getSession(false);	        
        if(session.getAttribute("key")!=null){
        	
	        String id=(String)session.getAttribute("key"); 	          
	       
	        boolean isTrue;
			isTrue = ContactDbUtil.insertinquiry(fname, lname, mobile, type, message, id);
			
			if(isTrue == true) {
				RequestDispatcher rd = request.getRequestDispatcher("contactSubmit.jsp");
				rd.forward(request, response);
			}
			else { 
				
				RequestDispatcher rd2 = request.getRequestDispatcher("contactNotSubmit.jsp");
				rd2.forward(request, response);
			}    
	             
	        
	        	        
        }else{  
            
        	out.println("<script type='text/javascript'>");
			out.println("alert('Please login first');");
			out.println("location='Login.jsp'");
			out.println("</script>");
        	        	
        }  
        out.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
