package com.cg.hcs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.service.AdminServiceImpl;
import com.cg.hcs.service.IAdminService;

@WebServlet("/AddTestServlet")
public class AddTestServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String centerId = request.getParameter("centerId");
		String testName = request.getParameter("testName");
		DiagnosticCenter center = new DiagnosticCenter(centerId, "Add Test");
		Test test = new Test(testName, center);
		IAdminService adminService = new AdminServiceImpl();
		String testId = adminService.addTest(test);
		
		request.setAttribute("testId", testId);
		request.getRequestDispatcher("AdminHomePage.jsp").forward(request, response);
	}
}
