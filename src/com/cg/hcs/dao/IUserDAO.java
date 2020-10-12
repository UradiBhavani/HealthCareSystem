package com.cg.hcs.dao;



import com.cg.hcs.entity.Users;
import java.time.LocalDateTime;
import java.util.List;

import com.cg.hcs.entity.Appointment;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.entity.Users;

public interface IUserDAO {

	public String register(Users user);
	
	public boolean validateUser(String userId, String password);
	
	public String getRoleCode(String userId);
	
	String makeAppointment(Appointment appointment);
	
	public List<String> getDiagnosticCentersList();
	
	List<String> getTestsList(String centerId);
	
	public Users getUser(String userId);
	 
	public Test getTest(String testName,String centerName);
	
	public DiagnosticCenter getDiagnosticCenter(String centerName);
	
	public List<Appointment> getAppointmentStatus(String userId);
	
	public String getApplicationId(String userId);

}