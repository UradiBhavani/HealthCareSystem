package com.cg.hcs.testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

	
	@Test
	public void testRegister() {
		Users user = new Users("Abc@1234", "User 2", 78543210l, "usr2@xyz.co", "usr");
		
		IUserService userService = new UserServiceImpl();
		assertNotNull(userService.register(user));

	}

	// Test to check getRoleCode()
	@Test
	public void testGetRoleCode() 
	{
		
		IUserService userService = new UserServiceImpl();
		assertEquals("usr",userService.getRoleCode("U_00032"));
	}

	@Test
	public void testValidateUser() {
		String userId = "U_00032";
		String password = "Abcd@123";
		IUserService userDAO = new UserServiceImpl();
		boolean status = userDAO.validateUser(userId, password);
		assertTrue(status);
	}

	@Test
	public void testGetDiagnosticCenterList() {
		IUserService userService = new UserServiceImpl();
		assertNotNull(userService.getDiagnosticCentersList());
	}
	
	@Test
	public void testGetTestLists() 
	{
		IUserService userService = new UserServiceImpl();
		assertNotNull(userService.getTestsList("C_00015"));
	}
	
	@Test
	public void testMakeAppointment() 
	{
		Users user = new Users("U_00032");
		com.cg.hcs.entity.Test test = new com.cg.hcs.entity.Test("T_00000028");
		Appointment appointment = new Appointment("12/10/2020 18:35", 'P', test, user);
		
		IUserService userService = new UserServiceImpl();
		assertEquals(102, userService.makeAppointment(appointment));
		
	}
	
	
}
