package com.cg.hcs.dao;

import java.util.List;

import com.cg.hcs.entity.Appointment;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.exception.HCSException;

/*This interface includes the method declarations
 *  of all the functionalities of admin which require database interaction*/
public interface IAdminDAO 
{
	public String addCenter(DiagnosticCenter center) throws HCSException;
	
	public boolean deleteCenter(DiagnosticCenter center) throws HCSException;
	
	public String addTest(Test test) throws HCSException;
	
	boolean removeTest(String testId) throws HCSException;

	boolean approveRejectAppointment(int appId, char appStatus) throws HCSException;

	public List<Test> viewAllTest(String centerId) throws HCSException;

	public List<Appointment> viewAllAppointmentsByCenter(String centerId) throws HCSException;

	public List<DiagnosticCenter> viewAllCenters() throws HCSException;
	
}
