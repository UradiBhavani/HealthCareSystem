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

/***************************************
 * 
 * Description : HealthCareSystem Service Implementation
 * @author : Reshma, Yashaswini, Bhavani
 * @Date : 12/10/2020
 * 
 ***************************************/
public class UserServiceImpl implements IUserService{
	IUserDAO userDaoInterface = new UserDAOImpl();
	
	/***********************************
	 * 
	 * @Description : User registration Method
	 * @Author : Reshma
	 * @arg1 : Users
	 * 
	 * @returns: String
	 * @Exception : HCSException
	 ***********************************/
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
	
	/***********************************
	 * 
	 * @Description : Method to retrive the RoleCode
	 * @Author : Yashaswini
	 * @arg1 : String
	 * 
	 * @returns: String
	 * @Exception : HCSException
	 * 
	 ***********************************/
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
	
	
	/***********************************
	 * 
	 * @Description : User registration MethodMethod to validate the user
	 * @Author : Yashaswini
	 * @arg1 : String,String
	 * 
	 * @returns: Boolean
	 * @Exception : HCSException
	 ***********************************/
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
	
	
	/***********************************
	 * 
	 * @Description : Method to book an appointment
	 * @Author : Bhavani
	 * @arg1 : Appointment
	 * 
	 * @returns: int
	 * @Exception : HCSException
	 ***********************************/
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
	
	
	/***********************************
	 * 
	 * @Description : Method to retrive the centers list
	 * @Author : Bhavani
	 *
	 *	No arguments
	 * 
	 * @returns: List<DiagnosticCenter>
	 * @Exception : HCSException
	 ***********************************/
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
	
	
	/***********************************
	 * 
	 * @Description : Method to retrive the Tests list under a particular DiagnosticCenter
	 * @Author : Bhavani
	 * @arg1 : String
	 * 
	 * @returns: List<Test>
	 * @Exception : HCSException
	 ***********************************/
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
	
	
	/***********************************
	 * 
	 * @Description : Method to retrieve the user based on userId
	 * @Author : Bhavani
	 * @arg1 : String
	 * 
	 * @returns: Users
	 * @Exception : HCSException
	 * 
	 ***********************************/	
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
	
	
	/***********************************
	 * 
	 * @Description : Method the Test using testname and centerId
	 * @Author : Bhavani
	 * @arg1 : String, String
	 * 
	 * @returns: Test
	 * @Exception : HCSException
	 * 
	 ***********************************/
	@Override
	public Test getTest(String testId) 
	{
		try 
		{
			return userDaoInterface.getTest(testId);
		}
		catch (HCSException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	/***********************************
	 * 
	 * @Description : Method to get the DiagnosticCenter using centerId
	 * @Author : Bhavani
	 * @arg1 : String
	 * 
	 * @returns: DiagnosticCenter
	 * @Exception : HCSException
	 * 
	 ***********************************/
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
	
	/***********************************
	 * 
	 * @Description : Method to retrive the Status of the Appointment
	 * @Author : Reshma
	 * @arg1 : String
	 * 
	 * @returns: List<Appointment>
	 * @Exception : HCSException
	 * 
	 ***********************************/
	@Override
	public List<Appointment> getAppointmentStatus(Users user)
	{
		try
		{
			return userDaoInterface.getAppointmentStatus(user);
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
	public List<DiagnosticCenter> getDiagnosticCentersListByLocation(String location) {
		try
		{
			return userDaoInterface.getDiagnosticCentersListByLocation(location);
		} 
		catch (HCSException e) 
		{	
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean editProfile(Users user) {
		try 
		{
			return userDaoInterface.editProfile(user);
		}
		catch (HCSException e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
}