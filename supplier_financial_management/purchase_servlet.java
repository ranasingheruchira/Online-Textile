package com.jayasadha.supplier_financial_management;

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



/**
 * Servlet implementation class purchase_servlet
 */
@WebServlet("/purchase_servlet")
public class purchase_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private purchasedb userDAO;

	public void init() {
		userDAO = new purchasedb ();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new1":
				showNewForm(request, response);
				break;
			case "/purchase":
				insertUser(request, response);
				break;
			case "/delete1":
				deleteUser(request, response);
				break;
			case "/edit1":
				showEditForm(request, response);
				break;
			case "/updatep":
				updateUser(request, response);
				break;
			default:
				listUser1(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser1(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<purchase> listUser1 = userDAO.selectAllUsers();
		request.setAttribute("listUser1", listUser1);
		RequestDispatcher dispatcher = request.getRequestDispatcher("purchase-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("purchase-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		purchase existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("purchase-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String product_id = request.getParameter("name");
		int suppid = Integer.parseInt(request.getParameter("con"));
		String date = request.getParameter("mail");
		int quan = Integer.parseInt(request.getParameter("add1"));
		float up = Float.parseFloat(request.getParameter("add2"));
		purchase newUser = new purchase(product_id,suppid,date,quan,up);
		userDAO.insertUser(newUser);
		response.sendRedirect("list1");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String product_id = request.getParameter("name");
		int suppid = Integer.parseInt(request.getParameter("con"));
		String date = request.getParameter("mail");
		int quan = Integer.parseInt(request.getParameter("add1"));
		float up = Float.parseFloat(request.getParameter("add2"));

		purchase book = new purchase(id,product_id,suppid,date,quan,up);
		userDAO.updateUser(book);
		response.sendRedirect("list1");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("list1");

	}
	

	}
