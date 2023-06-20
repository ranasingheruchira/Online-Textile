package com.jayasadha.return_refund_management;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/replacement")
public class ReplacementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		double max_price = Double.parseDouble(request.getParameter("price"));
		
		HttpSession session = request.getSession();
		session.setAttribute("ret_rep_sel_maxp", max_price);
		
		ReplacementDBU rep = new ReplacementDBU();
		
		try {
			
			ArrayList<Replacement> replist = rep.getReplacementList(max_price);
			session.setAttribute("replacement_list",replist);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//dispatching into select replacement
		
		request.getRequestDispatcher("selectReplacement.jsp").forward(request, response);
		
		//request.getRequestDispatcher("test.jsp").forward(request, response);
		
		
	}

}
