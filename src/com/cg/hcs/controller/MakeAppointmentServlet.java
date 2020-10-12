package com.cg.hcs.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.hcs.dao.IUserDAO;
import com.cg.hcs.dao.UserDAOImpl;
import com.cg.hcs.entity.Appointment;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.entity.Users;
import com.cg.hcs.service.IUserService;
import com.cg.hcs.service.UserServiceImpl;

@WebServlet("/MakeAppointmentServlet")
public class MakeAppointmentServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IUserDAO userDAO = new UserDAOImpl();
		IUserService userService = new UserServiceImpl();
		RequestDispatcher dispatcher = null;
		
		try{
			
			
			
	        Users user = userService.getUser(request.getParameter("userId"));
	        Test test = userService.getTest(request.getParameter("testName"),request.getParameter("centerName"));
	        DiagnosticCenter diagnosticCenter = userService.getDiagnosticCenter(request.getParameter("centerName"));
	        String appDateTime = request.getParameter("date") + request.getParameter("time");
	        
			
			
			Appointment appointment = new Appointment();
			
			appointment.setAppDate(request.getParameter("appDateTime"));
			appointment.setIsApproved('P');
			appointment.setCenter(diagnosticCenter);
			appointment.setTest(test);
			appointment.setUser(user);
			
			String makeAppointment = userService.makeAppointment(appointment);
			
			if(makeAppointment.equals("success")) {
				//Display a message that user has Booked appointment succefully
				dispatcher = request.getRequestDispatcher("MakeAppointment.jsp");
				dispatcher.forward(request, response);
			}
			
			
		}catch(Exception e) {
		
			System.out.println(e.getMessage());
			
		}
		
	}

}
