package controllers.product;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import shop.dao.ProductDao;
import shop.models.Product;

//@WebServlet("/productCreate")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 *2,
				maxFileSize = 1024 *1024 *10, 
				maxRequestSize = 1024*1024*50)
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
		
		InputStream image = null;
		Part filePart = request.getPart("image");
		if(filePart != null) {
			image = filePart.getInputStream();
		};
		
		String fileName = extractFileName(filePart);
		String savePath = "C:\\Users\\USER\\Documents\\MyServlets\\OnlineShopping\\WebContent\\Images" + File.separator + fileName;
		File fileSaveDir = new File(savePath);
		filePart.write(savePath + File.separator);
	
		PrintWriter out = response.getWriter();
		Product product = new Product();
		product.setProductName(productName);
		product.setCost(cost);
		product.setDescription(description);
		if(image != null) {
			product.setProductImage(fileName);
		}
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
	
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for(String s:items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
	}
	
}
