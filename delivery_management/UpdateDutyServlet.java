package com.jayasadha.delivery_management;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateDutyServlet")
public class UpdateDutyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uOrderID = request.getParameter("usoid");
		/*String uOrder_date = request.getParameter("usodate");
		String uAddress_Line_1 = request.getParameter("usadd1");
		String uAddress_Line_2 = request.getParameter("usadd2");
		String uAddress_Line_3 = request.getParameter("usadd3");
		String uCustomerID = request.getParameter("uscid");*/
		String uDelivery_date = request.getParameter("usddate");
		String uDelivery_status = request.getParameter("usdstatus");
		
		
		boolean isTrue;//Create boolean variable called 'isTrue'
		
		
		isTrue = JayasadhaDB.updateStatus(uOrderID, uDelivery_date, uDelivery_status);
				
				if(isTrue == true) {
					
					List<Order> searchDuty = JayasadhaDB.getSpeDetails(uOrderID);
					request.setAttribute("searchDuty", searchDuty);
					
					RequestDispatcher di = request.getRequestDispatcher("DutyDetails.jsp");
					di.forward(request, response);
				}
				
				else {
					
					RequestDispatcher di2 = request.getRequestDispatcher("Unsuccess.jsp");
					di2.forward(request, response);
				}

	}

}
