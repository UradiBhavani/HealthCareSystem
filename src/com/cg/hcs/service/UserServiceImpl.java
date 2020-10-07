package com.cg.hcs.service;

import java.time.LocalDateTime;

import com.cg.hcs.dao.IUserDAO;
import com.cg.hcs.dao.UserDAOImpl;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.entity.Users;

public class UserServiceImpl implements IUserService{
	IUserDAO userDaoInterface = new UserDAOImpl();
	public boolean addCenter(DiagnosticCenter center) {
		return userDaoInterface.addCenter(center);
	}
	public boolean removeCenter(DiagnosticCenter center) {
		return userDaoInterface.removeCenter(center);
	}
	public String addTest(Test test) {
		return userDaoInterface.addTest(test);
	}
	public boolean removeTest(Test test) {
		return userDaoInterface.removeTest(test);
	}
	public boolean approveAppointment() {
		return userDaoInterface.approveAppointment();
	}

	public String makeAppointment(Users user, DiagnosticCenter test, LocalDateTime datetime) {
		return userDaoInterface.makeAppointment(user, test, datetime);
	}
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
}