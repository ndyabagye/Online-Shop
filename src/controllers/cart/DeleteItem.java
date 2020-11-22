package controllers.cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.models.Cart;

/**
 * Servlet implementation class DeleteItem
 */
//@WebServlet("/deleteItem")
public class DeleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prodQuantity = Integer.parseInt(request.getParameter("cartQuantity"));
		int prodId = Integer.parseInt(request.getParameter("cartId"));
		
		HttpSession session = request.getSession();
		//get the cart already in session
		ArrayList<Cart> cart = (ArrayList<Cart>)session.getAttribute("cart");
		
		//loop through and delete the item with the id and quantity
		for(int i = 0; i<cart.size(); i++) {
			if(prodId == cart.get(i).productId && prodQuantity == cart.get(i).getQuantity()) {
				cart.remove(i);
			}
		}
		
		//loop through new cart and sum totalCost
		int GrandTotal =0;
		for(int i = 0; i<cart.size(); i++) {
			GrandTotal = GrandTotal + cart.get(i).totalCost;
		}
		
		session.setAttribute("GrandTotal", GrandTotal);
		response.sendRedirect("cart.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
