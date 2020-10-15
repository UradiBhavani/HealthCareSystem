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
import com.cg.hcs.entity.Users;
import com.cg.hcs.service.UserServiceImpl;

/**********************************
 * @Description: Register servlet Implementation
 * @author : Reshma
 * @Date : 12/10/2020
 *
 **********************************/
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUserDAO userDAO = new UserDAOImpl();
		RequestDispatcher dispatcher = null;

		try {

			Users user = new Users();
			// user.setUserId("101");
			user.setUserName(request.getParameter("username"));
			user.setUserPassword(request.getParameter("password"));
			user.setUserRole("usr");
			user.setEmail(request.getParameter("email"));
			user.setContactNo(Long.parseLong(request.getParameter("contactno")));
			HttpSession session = request.getSession();

			UserServiceImpl service = new UserServiceImpl();
			String userId = service.register(user);

			if (userId != null) {
				session.setAttribute("userId", userId);
				// Display a message thet user has registered in succefully
				dispatcher = request.getRequestDispatcher("UserHomePage.jsp");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}

}
