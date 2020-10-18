package com.cg.hcs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.hcs.entity.Test;
import com.cg.hcs.service.AdminServiceImpl;
import com.cg.hcs.service.IAdminService;

@WebServlet("/RemoveTestServlet")
public class RemoveTestServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String testId = request.getParameter("testId");
		IAdminService admService = new AdminServiceImpl();
		if(admService.removeTest(testId))
		{
			request.setAttribute("testDeleted", "Test with test ID : "+testId+" deleted");
			request.getRequestDispatcher("AdminHomePage.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("RemoveTest.jsp").forward(request, response);
		}
	}
}
