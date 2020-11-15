package shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shop.models.Product;

public class ProductDao {
	String url = "jdbc:mysql://localhost:3306/onlineshop";
	String username = "root";
	String password = "";

	// create a product
	public int createProduct(Product product) throws ClassNotFoundException {
		String INSERT_PRODUCT = "INSERT INTO products" + "(productName,cost)VALUES" + "(?,?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		int result = 0;
		try {
			// connect to database
			Connection con = DriverManager.getConnection(url, username, password);
			// create a statement with connection object
			PreparedStatement pst = con.prepareStatement(INSERT_PRODUCT);
			pst.setString(1, product.getProductName());
			pst.setInt(2, product.getCost());
			pst.setString(3, product.getDescription());

			// execute query
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateProduct(Product product) throws ClassNotFoundException {
		String UPDATE_PRODUCT = "UPDATE products SET productName=?, cost=?, description=? where id=?";
		Class.forName("com.mysql.jdbc.Driver");
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url,username, password);
			PreparedStatement pst = con.prepareStatement(UPDATE_PRODUCT);
			pst.setString(1, product.getProductName());
			pst.setInt(2, product.getCost());
			pst.setString(3, product.getDescription());
			pst.setInt(4, product.getId());
			//execute query to update the product
			result = pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteProduct(int id) throws ClassNotFoundException {
		int result = 0;
		String DELETE_PRODUCT = "DELETE FROM products WHERE id=?";
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection(url, username,password);
			PreparedStatement pst = con.prepareStatement(DELETE_PRODUCT);
			pst.setInt(1,id);
			result = pst.executeUpdate();	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Product getProduct(int id) throws ClassNotFoundException {
		Product product = new Product();
		String GET_PRODUCT ="SELECT * FROM products where id =?";
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection(url, username,password);
			PreparedStatement pst = con.prepareStatement(GET_PRODUCT);
			pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				product.setId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setCost(rs.getInt(3));
				product.setDescription(rs.getString(4));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}

}
