package com.cg.hcs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.hcs.dao.IUserDAO;
import com.cg.hcs.dao.UserDAOImpl;
import com.cg.hcs.service.IUserService;
import com.cg.hcs.service.UserServiceImpl;

@WebServlet("/ShowDiagnosticCenterServlet")
public class ShowDiagnosticCenterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserDAO userDAO = new UserDAOImpl();
		RequestDispatcher dispatcher= null;
		IUserService userService = new UserServiceImpl();
		
		try{
			List<String> centersList = userService.getDiagnosticCentersList();
			request.setAttribute("centersList", centersList);
			/*List<String> testList = userService.getTestList();
			request.setAttribute("testList", testList);*/
			request.getRequestDispatcher("makeAppointment.jsp").forward(request, response);
		}
		catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

}
