package com.cg.hcs.service;

import java.util.List;

import com.cg.hcs.entity.Appointment;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;


/*This interface contains business logic methods to be implemented for the admin module*/
public interface IAdminService 
{
	public String addCenter(DiagnosticCenter center);
	

	public List<DiagnosticCenter> viewAllCenters();
	
	public String addTest(Test test);
	

	public boolean deleteCenter(DiagnosticCenter center);
	
	public List<Test> viewAllTest(String centerId);

	public boolean removeTest(String testId);

	

	List<Appointment> viewAllAppointmentsByCenter(String centerId);

	public boolean approveRejectAppointment(int appId, char appStatus);


	
}
