package com.jayasadha.return_refund_management;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


@WebServlet("/placeReturn")
@MultipartConfig

public class ReturnPlacementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int CustoemrID = Integer.parseInt(request.getParameter("cus_id"));
		String customerReason = request.getParameter("cus_note");
		int OrderID = Integer.parseInt(request.getParameter("order_ID"));
		int ItemID = Integer.parseInt(request.getParameter("ItemID"));
		int replacement =Integer.parseInt(request.getParameter("replacement"));
		String message = "Request Send Successully..!!";
		
		long namePart = System.currentTimeMillis();
		
		String evidenceName = ""+namePart+CustoemrID;
		
		ReturnPlacementDBU retPlace = new ReturnPlacementDBU();
		
		try {
			
			retPlace.insertReturnRequest(CustoemrID, customerReason, OrderID, ItemID, replacement,evidenceName);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//uploading a file
		
	    Part filePart = request.getPart("evidences");
	    String fileName = filePart.getSubmittedFileName();
	    for (Part part : request.getParts()) {
	      part.write("D:\\JayasadaTextiles\\Project\\KDY_2021_WD07\\src\\main\\webapp\\images\\evidence\\"+evidenceName+".png");
	    }
	    
	    //response.getWriter().print("The file uploaded sucessfully.");
		
	    //setting success message
	    session.setAttribute("ret_msg", message);
	    request.getRequestDispatcher("RetSuccess.jsp").forward(request, response);
	}


}
