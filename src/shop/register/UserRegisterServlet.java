package shop.register;

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
import shop.models.User;

/**
 * Servlet implementation class UserServlet
 */
//@WebServlet("/userRegister")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//create instance of user data access object
	private UserDao userdao = new UserDao();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("userRegister.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get input parameters
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password1 = request.getParameter("password");
		byte[] salt = getSalt();
		//encrypt the password
		String password = get_SHA_1_SecurePassword(password1, salt);
		
		//set user variables from user object
		User user = new User();
		user.setFullname(fullname);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		
		//try to save the user and throw an error if it goes wrong
		try {
			userdao.registerUser(user);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		//send user to welcome jsp page
		HttpSession session = request.getSession();
		session.setAttribute("uname", fullname);
		
		response.sendRedirect("welcomePage.jsp");
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
