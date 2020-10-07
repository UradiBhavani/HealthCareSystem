package com.cg.hcs.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.utility.JpaUtility;

@WebServlet("/CreateCenterServlet")
public class CreateCenterServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String centerName = request.getParameter("centerName");
		
	}
}
