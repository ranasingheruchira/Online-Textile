package com.jayasadha.return_refund_management;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/return")
public class ReturnRequestControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String itemName = request.getParameter("name");
		double itemPrice  = Double.parseDouble(request.getParameter("price"));
		String image = request.getParameter("image");
		int ID = Integer.parseInt(request.getParameter("id"));
		int rep_sel;
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("rep_sel")==null) {
			
			rep_sel = 0;
			
		}
		else
			rep_sel = (int)session.getAttribute("rep_sel");
		
		
		session.setAttribute("com_ret_name", itemName);
		session.setAttribute("com_ret_price", itemPrice);
		session.setAttribute("com_ret_image", image);
		session.setAttribute("com_ret_id", ID);
		session.setAttribute("com_ret_repsel",rep_sel);
		
		request.getRequestDispatcher("returnRequest.jsp").forward(request, response);
		
	}

}
