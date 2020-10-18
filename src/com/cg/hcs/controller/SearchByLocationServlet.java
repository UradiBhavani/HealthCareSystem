package com.cg.hcs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.service.IUserService;
import com.cg.hcs.service.UserServiceImpl;

/**
 * Servlet implementation class SearchByLocation
 */
@WebServlet("/SearchByLocation")
public class SearchByLocationServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserService userService = new UserServiceImpl();
		RequestDispatcher dispatcher = null;
		
		try{
			String location = request.getParameter("location");
			List<DiagnosticCenter> centersList = userService.getDiagnosticCentersListByLocation(location);
			request.setAttribute("centersList", centersList);
			request.getRequestDispatcher("showCenters.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
