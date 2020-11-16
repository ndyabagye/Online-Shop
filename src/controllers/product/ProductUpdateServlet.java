package controllers.product;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.ProductDao;
import shop.models.Product;

/**
 * Servlet implementation class ProductUpdateServlet
 */
//@WebServlet("/productUpdate")
public class ProductUpdateServlet extends HttpServlet {
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
			
			HttpSession session = request.getSession();
			session.setAttribute("productName", productName);
			session.setAttribute("description", description);
			session.setAttribute("cost", cost);
			session.setAttribute("prodId", prodId);
			response.sendRedirect("updateProduct.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("productName");
		String description = request.getParameter("description");
		int cost = Integer.parseInt(request.getParameter("cost"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		PrintWriter out = response.getWriter();
		Product product = new Product();
		product.setProductName(productName);
		product.setDescription(description);
		product.setCost(cost);
		product.setId(id);
		try {
			int status = productDao.updateProduct(product);
			if(status>0) {
				response.sendRedirect("welcomePage.jsp");
			}else {
				out.println("Unable to update product");
			}
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
