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
import javax.servlet.http.HttpSession;

import com.cg.hcs.dao.IUserDAO;
import com.cg.hcs.dao.UserDAOImpl;
import com.cg.hcs.entity.Appointment;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.entity.Users;
import com.cg.hcs.service.IUserService;
import com.cg.hcs.service.UserServiceImpl;

/**********************************
 * @Description: MakeAppointment Servlet Implementation
 * @author : Bhavani
 * @Date : 12/10/2020
 *
 **********************************/
@WebServlet("/MakeAppointmentServlet")
public class MakeAppointmentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in makeappointment servlet");
		IUserDAO userDAO = new UserDAOImpl();
		IUserService userService = new UserServiceImpl();
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();

		try {

			System.out.println("in try " + session.getAttribute("userId"));
			String userId = (String)session.getAttribute("userId");
			Users user = new Users(userId);
			Test test = new Test(request.getParameter("testObj"));
			String appDateTime = request.getParameter("date") + request.getParameter("time");

			System.out.println(appDateTime);

			Appointment appointment = new Appointment(appDateTime, 'P', test, user);
			System.out.println(appointment);
			int makeAppointment = userService.makeAppointment(appointment);

			if (makeAppointment != 0) {
				request.setAttribute("successMessage", "Appointment booked successfully!!");
				dispatcher = request.getRequestDispatcher("UserHomePage.jsp");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

}
