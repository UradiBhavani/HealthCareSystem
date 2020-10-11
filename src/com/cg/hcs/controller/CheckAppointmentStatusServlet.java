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

import com.cg.hcs.entity.Appointment;
import com.cg.hcs.service.IUserService;
import com.cg.hcs.service.UserServiceImpl;


@WebServlet("/CheckAppointmentStatusServlet")
public class CheckAppointmentStatusServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserService userService = new UserServiceImpl();
		RequestDispatcher dispatcher = null;
		
		try {
			HttpSession session = request.getSession();
			String userId = (String) session.getAttribute("userId");
			String appId = userService.getApplicationId(userId);
			List<Appointment> appointmentList = userService.getAppointmentStatus(userId);
			
			request.setAttribute("appointmentList", appointmentList);
			
			request.getRequestDispatcher("CheckAppointmentStatus.jsp").include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		
	}

	

}