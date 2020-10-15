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

import com.cg.hcs.dao.IUserDAO;
import com.cg.hcs.dao.UserDAOImpl;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.service.IUserService;
import com.cg.hcs.service.UserServiceImpl;

/**********************************
 * @Description: ShowDiagnosticCenter servlet Implementation
 * @author : Bhavani
 * @Date : 12/10/2020
 *
 **********************************/
@WebServlet("/ShowDiagnosticCenterServlet")
public class ShowDiagnosticCenterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUserDAO userDAO = new UserDAOImpl();
		RequestDispatcher dispatcher = null;
		IUserService userService = new UserServiceImpl();

		try {
			List<DiagnosticCenter> centersList = userService.getDiagnosticCentersList();
			System.out.println("After getting centerlist");
			request.setAttribute("centersList", centersList);
			request.getRequestDispatcher("showCenters.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("In ShowDiagnosticCenter" + e.getMessage());

		}

	}

}
