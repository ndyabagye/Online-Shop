package login;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.UserDao;


//@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//get the login page 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("userLogin.jsp");
		dispatcher.forward(request, response);
	}
       
	//check login data
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("fullname");
		String upass1 = request.getParameter("password");
		byte[] salt = getSalt();
		//get password and check encryption
		String upass = get_SHA_1_SecurePassword(upass1, salt);
		UserDao dao = new UserDao();
		
		if(dao.checkLogin(uname, upass)) {
			HttpSession session = request.getSession();
			session.setAttribute("uname", uname);
			response.sendRedirect("welcomePage.jsp");
		}else {
			response.sendRedirect("userLogin.jsp");
		}
	}
	
	public byte[] getSalt() {
		byte[] salt = new byte[8];
		return salt;
	}
	
	public static String get_SHA_1_SecurePassword(String passwordToHash, byte[] salt) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(salt);
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
				generatedPassword = sb.toString();
			}
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
}
