package shop.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shop.models.User;

public class UserDao {
	String url = "jdbc:mysql://localhost:3306/onlineshop";
	String username = "root";
	String password =""; 
	public int registerUser(User user) throws ClassNotFoundException{
		String INSERT_USERS_SQL = "INSERT INTO users"+ 
									"(email, password,phone, fullname)VALUES"+
									"(?,?,?,?);";
		int result = 0;
		Class.forName("com.mysql.jdbc.Driver");
		try {
			//1. connection to database
			Connection con = DriverManager.getConnection(url, username, password);
			//2.create a statement with connection object
			PreparedStatement pst = con.prepareStatement(INSERT_USERS_SQL);
			pst.setString(1,user.getEmail());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getPhone());
			pst.setString(4, user.getFullname());
			
			//3.Execute the query
			result = pst.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean checkLogin(String uname, String upass) {
		String sql = "select * from users where fullname=? and password=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, upass);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}
}
