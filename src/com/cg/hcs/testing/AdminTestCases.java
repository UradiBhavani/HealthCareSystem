package com.cg.hcs.testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.cg.hcs.dao.AdminDAOImpl;
import com.cg.hcs.dao.IAdminDAO;
import com.cg.hcs.entity.Appointment;
import com.cg.hcs.entity.DiagnosticCenter;

import com.cg.hcs.service.AdminServiceImpl;
import com.cg.hcs.service.IAdminService;

public class AdminTestCases 
{
	
	@Test
	public void testAddCenter()
	{
		IAdminService adminService = new AdminServiceImpl();
		DiagnosticCenter center = new DiagnosticCenter("Abc Diagnostic Center");
		String centerId = adminService.addCenter(center);
		assertNotNull(centerId);
	}
	
	@Test
	public void testDeleteCenter()
	{
		DiagnosticCenter center = new DiagnosticCenter("C_00015","Delete");
		IAdminService adminService = new AdminServiceImpl();
		assertTrue(adminService.deleteCenter(center));
	}
	
	@Test
	public void testViewTests()
	{
		DiagnosticCenter center = new DiagnosticCenter("C_00015","View");
		IAdminDAO adminDAO = new AdminDAOImpl();
		adminDAO.viewAllTest(center);
		assertTrue(true);
	}
	
	 
	  @Test 
	  public void testAddTest() 
	  {
		  DiagnosticCenter center = new DiagnosticCenter("C_00015", "Add Test"); 
		  com.cg.hcs.entity.Test test = new com.cg.hcs.entity.Test("Covid 190", center);
		  IAdminService adminService = new AdminServiceImpl();
		  assertNotNull(adminService.addTest(test));
	  }
	 
	
	@Test
	public void testViewAppointment()
	{
		IAdminService adminService = new AdminServiceImpl();
		DiagnosticCenter center = new DiagnosticCenter("C_00015", "View Appointment");
		List<Appointment> appointmentList = adminService.viewAllPendingAppointmentByCenter(center);
		System.out.println(appointmentList);
		assertNotNull(appointmentList);
	}
	
	
}
