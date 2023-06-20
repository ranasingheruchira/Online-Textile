package com.jayasadha.return_refund_management;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/setRep")
public class ReturnRequestControllerRep extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String image  = request.getParameter("image");
		double price = Double.parseDouble(request.getParameter("price"));
		int repID = Integer.parseInt(request.getParameter("id"));
		int rep_sel = 1;
		
		HttpSession session = request.getSession();
		
		session.setAttribute("replace_name", name);
		session.setAttribute("replace_price", price);
		session.setAttribute("replace_image", image);
		session.setAttribute("com_ret_repsel", rep_sel);
		session.setAttribute("replace_id", repID);
		
		request.getRequestDispatcher("returnRequest.jsp").forward(request, response);;
		
	}

}
