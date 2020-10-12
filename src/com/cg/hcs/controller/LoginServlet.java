package com.cg.hcs.controller;
import com.cg.hcs.service.IUserService;
import com.cg.hcs.service.UserServiceImpl;

import java.io.IOException;

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
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String userId = request.getParameter("userid");
	        String password = request.getParameter("password");
	        HttpSession session =  request.getSession();
	        RequestDispatcher dispatcher=null;
	        IUserService service = new UserServiceImpl();
	        
	        try {
	        	boolean isValid = service.validateUser(userId, password);
				if (isValid) {
		        	String userRole = service.getRoleCode(userId);
		        	System.out.println(userRole);
					if(userRole.equals("adm")) {
						
						session.setAttribute("userId", userId);
						dispatcher = request.getRequestDispatcher("AdminHomePage.jsp");
						dispatcher.forward(request, response);
					}
					else {
						session.setAttribute("userId", userId);
						dispatcher = request.getRequestDispatcher("UserHomePage.jsp");
						dispatcher.forward(request, response);	
					}
				} else {
					dispatcher = request.getRequestDispatcher("Login.jsp");
					dispatcher.forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    }

}
