package com.cg.hcs.testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cg.hcs.entity.Appointment;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Users;
import com.cg.hcs.service.AdminServiceImpl;
import com.cg.hcs.service.IAdminService;
import com.cg.hcs.service.IUserService;
import com.cg.hcs.service.UserServiceImpl;
import com.cg.hcs.utility.JpaUtility;

public class TestCases {

	// Test to check addCenter()
	@Test
	public void testAddCenter() {
		IAdminService adminService = new AdminServiceImpl();
		DiagnosticCenter center = new DiagnosticCenter("Sample Center");
		String centerId = adminService.addCenter(center);
		assertNotNull(centerId);
	}

	// Test to check deleteCenter()
	@Test
	public void testDeleteCenter() {
		DiagnosticCenter center = new DiagnosticCenter("C_00009", "Delete");
		IAdminService adminService = new AdminServiceImpl();
		assertTrue(adminService.deleteCenter(center));
	}

	/*
	 * @Test public void testCreateCenter() throws HCSException { DiagnosticCenter
	 * center = new DiagnosticCenter("Mumbai"); IAdminService adminDAO = new
	 * AdminServiceImpl(); String returnedValue = adminDAO.addCenter(center);
	 * assertEquals("C_000001", returnedValue); }
	 */

	// Test to check register()
	@Test
	public void testRegister() {
		Users user = new Users();
		user.setUserId("101");
		user.setUserName("Alok");
		user.setUserPassword("#Alok1234");
		user.setUserRole("usr");
		user.setEmail("alok@gmail.com");
		user.setContactNo(Long.parseLong("7540906497"));
		IUserService userDAO = new UserServiceImpl();
		String returnedValue = userDAO.register(user);
		assertEquals("102", returnedValue);

	}

	// Test to check getRoleCode()
	@Test
	public void testGetRoleCode() {
		Users user = new Users();
		user.setUserId("101");
		user.setUserName("Alok");
		user.setUserPassword("#Alok1234");
		user.setUserRole("usr");
		user.setEmail("alok@gmail.com");
		user.setContactNo(Long.parseLong("7540906497"));
		IUserService userDAO = new UserServiceImpl();
		String userId = userDAO.register(user);
		String returnedValue = userDAO.getRoleCode(userId);
		assertEquals("usr", returnedValue);
	}

	@Test
	public void testValidateUser() {
		String userId = "001";
		String password = "#Alok1234";
		IUserService userDAO = new UserServiceImpl();
		boolean status = userDAO.validateUser(userId, password);
		assertTrue(status);
	}

	@Test
	public void testGetDiagnosticCenterList() {
		IUserService userDAO = new UserServiceImpl();
		assertNotNull(userDAO.getDiagnosticCentersList());
	}
	
	@Test
	public void testGetTestLists() {
		IUserService userDAO = new UserServiceImpl();
		assertNotNull(userDAO.getTestsList("C00002"));
	}
	
	@Test
	public void testMakeAppointment() {
		IUserService userDAO = new UserServiceImpl();
		Appointment appointment = new Appointment();
		//INCOMPLETE
	}
	
	
}
