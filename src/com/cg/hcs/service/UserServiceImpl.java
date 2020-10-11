package com.cg.hcs.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.hcs.dao.IUserDAO;
import com.cg.hcs.dao.UserDAOImpl;
import com.cg.hcs.entity.Appointment;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.entity.Users;

public class UserServiceImpl implements IUserService{
	IUserDAO userDaoInterface = new UserDAOImpl();
	
	public String register(Users user) {
		return userDaoInterface.register(user);
	}
	public String getRoleCode(String userId) {
		// TODO Auto-generated method stub
		return userDaoInterface.getRoleCode(userId);
	}
	public boolean validateUser(String userId, String password) {
		// TODO Auto-generated method stub
		return userDaoInterface.validateUser(userId, password);
	}
	@Override
	public String makeAppointment(Appointment appointment) {
		return userDaoInterface.makeAppointment(appointment);
	}
	@Override
	public List<String> getDiagnosticCentersList() {
		return userDaoInterface.getDiagnosticCentersList();
	}
	@Override
	public List<String> getTestsList(String centerId) {
		return userDaoInterface.getTestsList(centerId);
	}
	@Override
	public Users getUser(String userId) {
		return userDaoInterface.getUser(userId);
	}
	@Override
	public Test getTest(String testName,String centerName) {
		return userDaoInterface.getTest(testName, centerName);
	}
	@Override
	public DiagnosticCenter getDiagnosticCenter(String centerName) {
		return userDaoInterface.getDiagnosticCenter(centerName);
	}
	@Override
	public List<Appointment> getAppointmentStatus(String userId) {
		return userDaoInterface.getAppointmentStatus(userId);
	}
	@Override
	public List<String> getTestList() {
		
		return null;
	}
	@Override
	public String getApplicationId(String userId) {
		return userDaoInterface.getApplicationId(userId);
	}
}