package com.cg.hcs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.hcs.dao.IUserDAO;
import com.cg.hcs.dao.UserDAOImpl;
import com.cg.hcs.entity.Users;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserDAO userDAO = new UserDAOImpl();
		RequestDispatcher dispatcher=null;
		
		System.out.println("Hello");
		try{
			
			System.out.println("In servlet");
			
			Users user = new Users();
			user.setUserId("101");
			user.setUserName(request.getParameter("username"));
			user.setUserPassword(request.getParameter("password"));
			user.setUserRole("usr");
			user.setEmail(request.getParameter("email"));
			System.out.println("Before contact");
			user.setContactNo(Long.parseLong(request.getParameter("contactno")));
			System.out.println("Printing user data \n"+user);
			
			String userId = userDAO.register(user);
			System.out.println("Id - "+userId);
			if(userId != null) {
				//Display a message thet user has registered in succefully
				dispatcher = request.getRequestDispatcher("userHomePage.jsp");
				dispatcher.forward(request, response);
			}
			
			
		}catch(Exception e) {
		
			System.out.println(e.getMessage());
			
		}
	}

}
