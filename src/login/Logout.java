package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//check if user is admin or user and redirect to respective logins
		if (session.getAttribute("adminToken")!=null) {
			session.removeAttribute("uname");
			session.removeAttribute("adminToken");
			session.invalidate();
			response.sendRedirect("adminLogin.jsp");
		}else {
		session.removeAttribute("uname");
		session.invalidate();
		response.sendRedirect("userLogin.jsp");
		}
		
	}
}

