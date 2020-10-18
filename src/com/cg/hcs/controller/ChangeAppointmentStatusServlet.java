package com.cg.hcs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.hcs.entity.Appointment;
import com.cg.hcs.service.AdminServiceImpl;
import com.cg.hcs.service.IAdminService;

@WebServlet("/ChangeAppointmentStatusServlet")
public class ChangeAppointmentStatusServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int appId = Integer.parseInt(request.getParameter("appId"));
		char appStatus = request.getParameter("appStatus").charAt(0);
		IAdminService adminService = new AdminServiceImpl();
		adminService.approveRejectAppointment(appId, appStatus);
	}
}
