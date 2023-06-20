package com.jayasadha.inquiry_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewCusServlt
 */
@WebServlet("/ViewCusServlt")
public class ViewCusServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter(); 
        response.setContentType("text/html"); 
		
		HttpSession session=request.getSession(false);	        
        if(session.getAttribute("key")!=null){
        	
	        String id=(String)session.getAttribute("key"); 	          
	       
	        
	        try {
				List<Contact> 	inqDetails = ContactDbUtil.getContact(id);
				request.setAttribute("inqDetails",inqDetails);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			RequestDispatcher dis = request.getRequestDispatcher("myinquiry.jsp");
			dis.forward(request, response);
	        
	        	        
        }else{  
            
        	out.println("<script type='text/javascript'>");
			out.println("alert('Please login first');");
			out.println("location='Login.jsp'");
			out.println("</script>");
        	        	
        }  
        out.close();	
		
	}

}
