package com.cg.hcs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.hcs.dao.IUserDAO;
import com.cg.hcs.dao.UserDAOImpl;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.service.IUserService;
import com.cg.hcs.service.UserServiceImpl;

/**
 * Servlet implementation class ShowTestServlet
 */
@WebServlet("/ShowTestServlet")
public class ShowTestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserDAO userDAO = new UserDAOImpl();
		IUserService userService = new UserServiceImpl();
		try{
			String centerName = request.getParameter("centerName");
			
			DiagnosticCenter center = userService.getDiagnosticCenter(centerName);
			
			List<Test> testList = userService.getTestsList(center.getCenterId());
			request.setAttribute("testList", testList);
			request.getRequestDispatcher("showTest.jsp").include(request,response);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
	}

	
}
