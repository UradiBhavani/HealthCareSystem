package com.cg.hcs.service;



import java.time.LocalDateTime;
import java.util.List;

import com.cg.hcs.entity.Appointment;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.entity.Users;

public interface IUserService {
	
	
	int makeAppointment(Appointment appointment);
	
	public String register(Users user);
	
	public boolean validateUser(String userId, String password);
	
	public String getRoleCode(String userId);

	public List<DiagnosticCenter> getDiagnosticCentersList();
	
	List<Test> getTestsList(String centerId);
	
	public Users getUser(String userId);
	 
	public Test getTest(String testId);
	
	public DiagnosticCenter getDiagnosticCenter(String centerId);
	
	public List<Appointment> getAppointmentStatus(Users user);

	public List<String> getTestList();

	public String getApplicationId(String userId);
	
}
