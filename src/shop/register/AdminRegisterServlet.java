package shop.register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.AdminDao;
import shop.models.Admin;


//@WebServlet("/adminRegister")
public class AdminRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//create instance of admin data access object
	private AdminDao admindao = new AdminDao();
	
   
    public AdminRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminRegister.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get input parameters
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//set admin variables from admin object
		Admin admin = new Admin();
		admin.setFullname(fullname);
		admin.setEmail(email);
		admin.setPassword(password);
		
		//try to save the admin and throw an error if it goes wrong
		try {
			admindao.registerAdmin(admin);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		//send admin to welcome jsp page with an admintoken
		HttpSession session = request.getSession();
		session.setAttribute("uname", fullname);
		session.setAttribute("adminToken",1);
		
		response.sendRedirect("welcomePage.jsp");
	}
	
}
