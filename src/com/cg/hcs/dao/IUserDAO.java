package com.cg.hcs.dao;



import com.cg.hcs.entity.Users;
import com.cg.hcs.exception.HCSException;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.hcs.entity.Appointment;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.entity.Users;

public interface IUserDAO {

	public String register(Users user) throws HCSException;
	
	public boolean validateUser(String userId, String password) throws HCSException;
	
	public String getRoleCode(String userId) throws HCSException;
	
	public int makeAppointment(Appointment appointment) throws HCSException;
	
	public List<DiagnosticCenter> getDiagnosticCentersList() throws HCSException;
	
	List<Test> getTestsList(String centerId) throws HCSException;
	
	public Users getUser(String userId) throws HCSException;
	 
	public Test getTest(String testId) throws HCSException;
	
	public DiagnosticCenter getDiagnosticCenter(String centerId) throws HCSException;
	
	public List<Appointment> getAppointmentStatus(Users user) throws HCSException;
	
	public String getApplicationId(String userId);

}