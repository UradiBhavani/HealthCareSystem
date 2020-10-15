package com.cg.hcs.controller;

import com.cg.hcs.service.IUserService;
import com.cg.hcs.service.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

/**********************************
 * @Description: Login Servlet Implementation
 * @author : Yashaswini
 * @Date : 12/10/2020
 *
 **********************************/
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("In Loginservlet");
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		IUserService service = new UserServiceImpl();
		System.out.println(userId + " " + password);
		try {
			boolean isValid = service.validateUser(userId, password);
			System.out.println(isValid);
			if (isValid) {
				String userRole = service.getRoleCode(userId);
				System.out.println(userRole);
				out.println("<html>");
				if (userRole.equals("adm")) {
					out.println("<body> Admin loggedin Successfully...!</body>");
					session.setAttribute("userId", userId);
					session.setAttribute("role", "adm");
					dispatcher = request.getRequestDispatcher("AdminHomePage.jsp");
					dispatcher.forward(request, response);
				} else {
					out.println("<body> User loggedin Successfully...!</body>");
					session.setAttribute("userId", userId);
					session.setAttribute("role", "usr");
					dispatcher = request.getRequestDispatcher("UserHomePage.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				out.println("<body> Invalid credentials...!</body>");
				dispatcher = request.getRequestDispatcher("Login.jsp");
				dispatcher.forward(request, response);
			}
			out.println("</html>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("In LoginServlet catch block");
		}
	}

}
