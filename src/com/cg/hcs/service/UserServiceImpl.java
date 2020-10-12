package com.cg.hcs.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.hcs.dao.IUserDAO;
import com.cg.hcs.dao.UserDAOImpl;
import com.cg.hcs.entity.Appointment;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.entity.Users;
import com.cg.hcs.exception.HCSException;

public class UserServiceImpl implements IUserService{
	IUserDAO userDaoInterface = new UserDAOImpl();
	
	public String register(Users user) {
		try 
		{
			return userDaoInterface.register(user);
		}
		catch (HCSException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	public String getRoleCode(String userId) {
		
		try 
		{
			return userDaoInterface.getRoleCode(userId);
		}
		catch (HCSException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean validateUser(String userId, String password) 
	{
		
		try 
		{
			return userDaoInterface.validateUser(userId, password);
		} 
		catch (HCSException e) 
		{	
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public int makeAppointment(Appointment appointment) 
	{
		try
		{
			return userDaoInterface.makeAppointment(appointment);
		} 
		catch (HCSException e) 
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public List<DiagnosticCenter> getDiagnosticCentersList() 
	{
		try 
		{
			return userDaoInterface.getDiagnosticCentersList();
		}
		catch (HCSException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Test> getTestsList(String centerId) 
	{
		try 
		{
			return userDaoInterface.getTestsList(centerId);
		} 
		catch (HCSException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Users getUser(String userId) 
	{
		try 
		{
			return userDaoInterface.getUser(userId);
		}
		catch (HCSException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Test getTest(String testName,String centerName) 
	{
		try 
		{
			return userDaoInterface.getTest(testName, centerName);
		}
		catch (HCSException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public DiagnosticCenter getDiagnosticCenter(String centerId) 
	{
		try 
		{
			return userDaoInterface.getDiagnosticCenter(centerId);
		} 
		catch (HCSException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Appointment> getAppointmentStatus(String userId)
	{
		try
		{
			return userDaoInterface.getAppointmentStatus(userId);
		} 
		catch (HCSException e) 
		{	
			e.printStackTrace();
		}
		return null;
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