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

@WebServlet("/DeleteCenterServlet")
public class DeleteCenterServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String centerId = request.getParameter("centerId");
		IAdminService adminService = new AdminServiceImpl();
		DiagnosticCenter center = new DiagnosticCenter(centerId, "Delete");
		boolean result= adminService.deleteCenter(center);
		System.out.println(result);
		if(result)
		{
			request.setAttribute("centerDeleted", "Center with center id : "+centerId+" deleted");
		}
		else
		{
			request.setAttribute("centerDeleted", "Selected Center can't be deleted");
		}
		request.getRequestDispatcher("AdminHomePage.jsp").forward(request, response);
	}
}
