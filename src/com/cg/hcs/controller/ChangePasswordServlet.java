package com.cg.hcs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.hcs.dao.IUserDAO;
import com.cg.hcs.dao.UserDAOImpl;
import com.cg.hcs.exception.HCSException;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("starting");
		IUserDAO userDAO = new UserDAOImpl();
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		
		try {
			
			String userId = (String) session.getAttribute("userId");
			String password = request.getParameter("confirmPassword");
			System.out.println("pwd : "+password);
			boolean isPasswordChanged = userDAO.changePassword(userId, password);
			if (isPasswordChanged) {
				dispatcher = request.getRequestDispatcher("UserHomePage.jsp");
				dispatcher.forward(request, response);
			} else {
				System.out.println("Could not change password");
			} 
		} catch (HCSException e) {
			System.out.println("In ChangePasswordServlet : "+e.getMessage());
		}
	}
}
