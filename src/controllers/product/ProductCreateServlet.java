package controllers.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import shop.dao.ProductDao;
import shop.models.Product;

@WebServlet("/productCreate")
public class ProductCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     private ProductDao productDao;

	public void init() {
		productDao = new ProductDao();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("createProduct.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("productName");
		String description = request.getParameter("description");
		int cost = Integer.parseInt(request.getParameter("cost"));
		PrintWriter out = response.getWriter();
		Product product = new Product();
		product.setProductName(productName);
		product.setCost(cost);
		product.setDescription(description);
		try {
			int status = productDao.createProduct(product);
			if(status>0) {
				response.sendRedirect("welcomePage.jsp");
			}else {
				out.println("Unable to create product!");
			}
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
