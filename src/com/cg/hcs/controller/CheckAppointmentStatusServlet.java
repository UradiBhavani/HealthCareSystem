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

import org.apache.log4j.Logger;

import com.cg.hcs.dao.AdminDAOImpl;
import com.cg.hcs.entity.Appointment;
import com.cg.hcs.entity.Users;
import com.cg.hcs.service.IUserService;
import com.cg.hcs.service.UserServiceImpl;

/**********************************
 * @Description: CheckAppointmentStatus Servlet Implementation
 * @author : Reshma
 * @Date : 12/10/2020
 *
 **********************************/

@WebServlet("/CheckAppointmentStatusServlet")
public class CheckAppointmentStatusServlet extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(CheckAppointmentStatusServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUserService userService = new UserServiceImpl();
		RequestDispatcher dispatcher = null;

		try {
			LOGGER.info("Inside Check appointment status servlet.");

			HttpSession session = request.getSession();
			System.out.println("Before getting session attribute");
			String userId = (String) session.getAttribute("userId");
			Users user = userService.getUser(userId);
			System.out.println(user);
			List<Appointment> appointmentList = userService.getAppointmentStatus(user);

			request.setAttribute("appointmentList", appointmentList);

			request.getRequestDispatcher("CheckAppointmentStatus.jsp").include(request, response);
		} catch (Exception e) {
			LOGGER.info("Error while displaying the status of appointment.");
			e.printStackTrace();
		}

	}

}