package com.jayasadha.delivery_management;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateDeliPersonServlet")
public class UpdateDeliPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String upOrderID = request.getParameter("oid");
		String upOrder_date = request.getParameter("odate");
		String upAddress_Line_1 = request.getParameter("add1");
		String upAddress_Line_2 = request.getParameter("add2");
		String upAddress_Line_3 = request.getParameter("add3");
		String upCustomerID = request.getParameter("cid");
		//String upDelivery_date = request.getParameter("ddate");
		String upDelivery_status = request.getParameter("dstatus");
		String upAssigned_DeliPerson = request.getParameter("dperson");
		
		boolean isTrue;//Create boolean variable called 'isTrue'
		
		
		isTrue = JayasadhaDB.updateAssignment(upOrderID, upOrder_date,upAddress_Line_1,upAddress_Line_2,upAddress_Line_3,
											  upCustomerID,/*upDelivery_date*/upDelivery_status,upAssigned_DeliPerson);
				
				if(isTrue == true) {
					
					List<Order> OrderDetails = JayasadhaDB.getSpeDetails(upOrderID);
					request.setAttribute("OrderDetails", OrderDetails);
					
					RequestDispatcher di = request.getRequestDispatcher("Success_DM.jsp");
					di.forward(request, response);
				}
				
				else {
					
					/*List<Order> OrderDetails = JayasadhaDB.getSpeDetails();
					request.setAttribute("OrderDetails", OrderDetails);*/
					
					RequestDispatcher di2 = request.getRequestDispatcher("Unsuccess.jsp");
					di2.forward(request, response);
				}

	}

}
