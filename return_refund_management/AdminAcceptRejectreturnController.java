package com.jayasadha.return_refund_management;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/admin_return_update")

public class AdminAcceptRejectreturnController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String emp_message = request.getParameter("emp_message");
		int requestID = Integer.parseInt(request.getParameter("requestID"));
		int cusID = Integer.parseInt(request.getParameter("cusID"));
		String status = request.getParameter("set");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address3 =request.getParameter("address3");
		int replacement = Integer.parseInt(request.getParameter("replacement"));
		int orderID;
		
		//generating unique order ID (unique for nearly 1 hour :(  )
		
		orderID = new OrderIDGenerator().getOrderID(cusID);
		
		ReturnAcceptRejectUpdateDBU dbu = new ReturnAcceptRejectUpdateDBU();
		
		boolean unsuccessUpdateReturn=true;
		boolean unsuccessInsertOrder =true;
		boolean unsuccessInsertOrderContain;
		
		if(status.equals("accepted")) {
			
			try {
				unsuccessInsertOrder= dbu.addToOrder(address1,address2,address3,cusID,orderID);
				unsuccessUpdateReturn =dbu.updateStatus(requestID, status, emp_message);
				unsuccessInsertOrderContain = dbu.addToOrderContain(orderID,replacement);
						
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}else {
			
			try {
				unsuccessUpdateReturn = dbu.updateStatus(requestID, status, emp_message);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}
		
		
	}

}
