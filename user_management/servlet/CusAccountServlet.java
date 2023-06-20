package com.jayasadha.user_management.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jayasadha.user_management.model.Customer;
import com.jayasadha.user_management.service.CustomerDBQuery;

/**
 * Servlet implementation class CusAccountServlet
 */
@WebServlet("/CusAccountServlet")
public class CusAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter(); 
        response.setContentType("text/html"); 	        
          
          
        HttpSession session=request.getSession(false);	        
        if(session.getAttribute("key")!=null){
        	
	        String id=(String)session.getAttribute("key"); 	          
	       
	        
	        CustomerDBQuery c1 =new CustomerDBQuery();
	        
	        List<Customer> cusDetails = c1.getProfile(id);
			request.setAttribute("cusDetails", cusDetails);
	        
	        request.getRequestDispatcher("/WEB-INF/views/CustomerProfile.jsp").include(request, response);
	        
        }else{  
            
        	out.println("<script type='text/javascript'>");
			out.println("alert('Please login first');");
			out.println("location='Login.jsp'");
			out.println("</script>");
        	        	
        }  
        out.close();  
    }	

}
