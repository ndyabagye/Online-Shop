package controllers.product;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.ProductDao;
import shop.models.Product;

/**
 * Servlet implementation class ProductDetails
 */
//@WebServlet("/productDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao;

	public void init() {
		productDao = new ProductDao();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			Product product = new Product();
			product = productDao.getProduct(id);
			String productName = product.getProductName();
			String description = product.getDescription();
			int cost = product.getCost();
			int prodId = product.getId();
			String prodImage = product.getProductImage();
			
			HttpSession session = request.getSession();
			session.setAttribute("productName", productName);
			session.setAttribute("cost", cost);
			session.setAttribute("prodId", prodId);
			session.setAttribute("description", description);
			session.setAttribute("productImage", prodImage);
			response.sendRedirect("productDetails.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
