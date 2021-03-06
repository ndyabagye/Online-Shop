package controllers.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import shop.models.Cart;


/**
 * Servlet implementation class CreateCart
 */
//@WebServlet("/createCart")
public class CreateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("prodId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int cost = Integer.parseInt(request.getParameter("prodCost"));
		String name = request.getParameter("prodName");
	
		int totalCost = quantity*cost;
		
		HttpSession session = request.getSession();
		
		ArrayList<Cart> cart = (ArrayList<Cart>)session.getAttribute("cart");
		
		if(cart == null) {
			cart =  new ArrayList<Cart>();
		}
	
		cart.add(new Cart(id,name,quantity, cost,totalCost));
		int GrandTotal = 0;
		//loop through and sum totalCost
		for(int i = 0; i<cart.size(); i++) {
				GrandTotal = GrandTotal + cart.get(i).totalCost;
			}
	
		//set cart
		session.setAttribute("cart", cart);
		//set GrandTotal
		session.setAttribute("GrandTotal", GrandTotal);

		response.sendRedirect("welcomePage.jsp");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
