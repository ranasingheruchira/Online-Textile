package com.jayasadha.user_management.servlet;

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

import com.jayasadha.user_management.model.Customer;
import com.jayasadha.user_management.service.CustomerDBQuery;

/**
 * Servlet implementation class CusLogoutServlet
 */
@WebServlet("/CusLogoutServlet")
public class CusLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 response.setContentType("text/html");  
         PrintWriter out=response.getWriter();
		
		String edit = request.getParameter("edit");
		String signout = request.getParameter("signout");
		
		HttpSession session=request.getSession(false);
		String id=(String)session.getAttribute("key"); 
		
		CustomerDBQuery c1 =new CustomerDBQuery();
		
		if(edit != null) {			
								
			try {
				List<Customer> cusDetails = c1.getProfile(id);
				request.setAttribute("cusDetails", cusDetails);			
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
			RequestDispatcher display = request.getRequestDispatcher("/WEB-INF/views/CustomerUpdate.jsp");
			display.forward(request, response);	
			
			
		}else if(signout != null) {			  
	              
	         //request.getRequestDispatcher("Login.jsp").include(request, response);  
	              
	         HttpSession session1=request.getSession();  
	         session1.invalidate();  
	          
	         out.println("<script type='text/javascript'>");
	         out.println("alert('You are successfully logged out!');");
	         out.println("location='Login.jsp'");
	         out.println("</script>");         
	              
	         out.close();				
			
		}else {
			
			boolean isTrue;			
			
			isTrue = c1.deactivateCustomer(id);
			
			if(isTrue==true) {		
				
				out.println("<script type='text/javascript'>");
		        out.println("alert('Your account is deactivated !');");
		        out.println("location='Login.jsp'");
		        out.println("</script>"); 							
				
			}else {
				try {
					List<Customer> cusDetails = c1.getProfile(id);
					request.setAttribute("cusDetails", cusDetails);			
					
				} catch (Exception e) {
					e.printStackTrace();
				}			
				RequestDispatcher display = request.getRequestDispatcher("/WEB-INF/views/CustomerProfile.jsp");
				display.forward(request, response);
			}					
			
		}
		
	}

}
