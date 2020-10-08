package com.cg.hcs.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.entity.Users;

public interface IUserDAO {

	public String register(Users user);
	
	public boolean validateUser(String userId, String password);
	
	public String getRoleCode(String userId);
	
	boolean addCenter(DiagnosticCenter center);
	
	public List<String> getDiagnosticCentersList();

	boolean removeCenter(DiagnosticCenter center);

	String addTest(Test test);

	boolean removeTest(Test test);

	boolean approveAppointment();

	String makeAppointment(Users user, DiagnosticCenter test, LocalDateTime datetime);

	List<String> getTestsList(String centerId);

}