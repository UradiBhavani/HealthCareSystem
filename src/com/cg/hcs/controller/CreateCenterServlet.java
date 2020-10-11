package com.cg.hcs.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.service.AdminServiceImpl;
import com.cg.hcs.service.IAdminService;


@WebServlet("/CreateCenterServlet")
public class CreateCenterServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String centerName = request.getParameter("centerName");
		DiagnosticCenter center = new DiagnosticCenter(centerName);
		
		IAdminService adminService = new AdminServiceImpl();
		String centerId = adminService.addCenter(center);
		if(centerId != null)
		{
			request.setAttribute("centerId","Center created with "+centerId);
		}
		else
		{
			request.setAttribute("centerId","Center could not get created. Please Try Again.");
		}
		request.getRequestDispatcher("AdminHomePage.jsp").forward(request, response);

	}
}
