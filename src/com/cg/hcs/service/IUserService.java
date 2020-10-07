package com.cg.hcs.service;

import java.time.LocalDateTime;

import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.entity.Users;

public interface IUserService {
	
	public boolean addCenter(DiagnosticCenter center);
	
	public boolean removeCenter(DiagnosticCenter center);
	
	public String addTest(Test test);
	
	public boolean removeTest(Test test);
	
	public boolean approveAppointment();
	
	public String makeAppointment(Users user, DiagnosticCenter test, LocalDateTime datetime);
	
	public String register(Users user);
	
	public boolean validateUser(String userId, String password);
	
	public String getRoleCode(String userId);

}