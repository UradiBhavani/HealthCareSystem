package com.cg.hcs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.hcs.entity.Users;
import com.cg.hcs.exception.HCSException;
import com.cg.hcs.service.IUserService;
import com.cg.hcs.service.UserServiceImpl;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserService userService = new UserServiceImpl();
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		
		try{
			String userId = (String) session.getAttribute("userId");
			String username = request.getParameter("username");
			Long contactNo = Long.parseLong(request.getParameter("contactNo"));
			String email = request.getParameter("email");
			
			Users user = new Users(userId, username, contactNo, email);
			System.out.println("EditProfileServlet "+user);
			boolean res = userService.editProfile(user);
			System.out.println(res);
			if(res){
				dispatcher = request.getRequestDispatcher("UserHomePage.jsp");
				dispatcher.forward(request,response);
			}else{
				System.out.println("Could not update profile");
			}
		}catch(Exception e){
			System.out.println("In EditProfileServlet : "+e.getMessage());
		}
	}

}
