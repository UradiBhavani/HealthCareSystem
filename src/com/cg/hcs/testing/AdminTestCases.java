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

/***************************************
 * 
 * Description : HealthCareSystem Testing
 * @author : Yashaswini, Pratik Prakash, Alok
 * @Date : 12/10/2020
 * 
 ***************************************/
public class AdminTestCases 
{
	
	/***********************************
	 * 
	 * @Description : Testing method to add DiagnosticCenter
	 * @Author : Alok Pattanaik
	 * No arguments
	 * 
	 * @returns: void
	 * 
	 ***********************************/
	@Test
	public void testAddCenter()
	{
		IAdminService adminService = new AdminServiceImpl();
		DiagnosticCenter center = new DiagnosticCenter("Abc Diagnostic Center");
		String centerId = adminService.addCenter(center);
		assertNotNull(centerId);
	}
	
	/***********************************
	 * 
	 * @Description : Testing method to check Deletion of DiagnosticCenter is successful
	 * @Author : Alok Pattanaik
	 * No Arguments
	 * 
	 * @returns: void
	 * 
	 ***********************************/
	@Test
	public void testDeleteCenter()
	{
		DiagnosticCenter center = new DiagnosticCenter("C_00015","Delete");
		IAdminService adminService = new AdminServiceImpl();
		assertTrue(adminService.deleteCenter(center));
	}
	
	/***********************************
	 * 
	 * @Description : Testing method to view test
	 * @Author : Pratik Prakash
	 * No Arguments
	 * 
	 * @returns: void
	 * 
	 ***********************************/
	@Test
	public void testViewTests()
	{
		DiagnosticCenter center = new DiagnosticCenter("C_00015","View");
		IAdminDAO adminDAO = new AdminDAOImpl();
		adminDAO.viewAllTest(center);
		assertTrue(true);
	}
	
	
	/***********************************
	 * 
	 * @Description : Testing method to add test under a particular DiagnosticCenter
	 * @Author : Pratik Prakash
	 * No Arguments
	 * 
	 * @returns: void
	 * 
	 ***********************************/
	  @Test 
	  public void testAddTest() 
	  {
		  DiagnosticCenter center = new DiagnosticCenter("C_00015", "Add Test"); 
		  com.cg.hcs.entity.Test test = new com.cg.hcs.entity.Test("Covid 190", center);
		  IAdminService adminService = new AdminServiceImpl();
		  assertNotNull(adminService.addTest(test));
	  }
	 
	  /***********************************
		 * 
		 * @Description : Testing method for viewing appointment
		 * @Author : Yashaswini
		 * No Arguments
		 * 
		 * @returns: void
		 * 
		 ***********************************/
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
