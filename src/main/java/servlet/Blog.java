package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Blog")
public class Blog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String fowardPath = null;
		
		if (action == null) {
			fowardPath = "/WEB-INF/jsp/blog.jsp";
			
		} else if (action.equals("login")) {
			fowardPath = "/WEB-INF/jsp/login.jsp";
			
		} else if (action.equals("register")) {
			fowardPath = "WEB-INF/jsp/register.jsp";
			
		} else if (action.equals("logout")) {
			HttpSession session=request.getSession();
			session.invalidate();
			fowardPath = "/WEB-INF/jsp/blog.jsp";
		}
		
		RequestDispatcher dispatcher =request.getRequestDispatcher(fowardPath);
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
