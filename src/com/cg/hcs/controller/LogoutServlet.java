package com.cg.hcs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(LogoutServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("Inside LogOut Servlet\n\n\n\n");

		/*
		 * response.setContentType("text/html"); PrintWriter out =
		 * response.getWriter();
		 */

		/*
		 * HttpSession session = request.getSession();
		 * 
		 * RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("index.jsp");
		 * dispatcher.forward(request, response); session.invalidate();
		 */

		// Destroying the session after logout
		/*
		 * if (request.getSession().getAttribute("userId") == null)
		 * response.sendRedirect("index.jsp");
		 * request.getSession(false).invalidate();
		 * response.sendRedirect("index.jsp");
		 */
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
