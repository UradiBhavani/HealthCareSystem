package com.cg.hcs.service;

import java.util.List;

import com.cg.hcs.dao.AdminDAOImpl;
import com.cg.hcs.dao.IAdminDAO;
import com.cg.hcs.entity.Appointment;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.exception.HCSException;

/*This is the implementation class for Admin module
 * which contains all the methods for implementation of business logic
 * which are public instance methods*/

/**********************************
 * @Description: HealthCareSystem Admin DAO Implementation
 * @author : Pratik, Alok, Yashaswini
 * @Date : 12/10/2020
 *
 **********************************/
public class AdminServiceImpl implements IAdminService 
{

	/***********************************
	 * 
	 * @Description :Method to add DiagnosticCenter
	 * @Author : Alok Pattanaik
	 * @arg1 : Center
	 * 
	 * @returns: String
	 * @Exception : HCSException
	 * 
	 ***********************************/
	@Override
	public String addCenter(DiagnosticCenter center) 
	{
		IAdminDAO adminDAO = new AdminDAOImpl();
		
		try 
		{
			return adminDAO.addCenter(center);
		} 
		catch (HCSException e) 
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	/***********************************
	 * 
	 * @Description : Method to add Test under a particular DiagnosticCenter
	 * @Author : Pratik Prakash
	 * @arg1 : Test
	 * 
	 * @returns: String
	 * @Exception : HCSException
	 * 
	 ***********************************/
	@Override
	public String addTest(Test test) {
		IAdminDAO adminDAO = new AdminDAOImpl();
		try 
		{
			return adminDAO.addTest(test);
		} 
		catch (HCSException e) 
		{
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	/***********************************
	 * 
	 * @Description : Method to delete DiagnosticCenter
	 * @Author : Alok Pattanaik
	 * @arg1 : Center
	 * 
	 * @returns: boolean
	 * @Exception : HCSException
	 * 
	 ***********************************/
	public boolean deleteCenter(DiagnosticCenter center) 
	{
		IAdminDAO adminDAO = new AdminDAOImpl();
		try 
		{
			return adminDAO.deleteCenter(center);
		} 
		catch (HCSException e) 
		{
			System.out.println(e.getMessage());
		}
		return false;
	}

	
	/***********************************
	 * 
	 * @Description : Method to remove Test
	 * @Author : Pratik Prakash
	 * @arg1 : Test
	 * 
	 * @returns: boolean
	 * @Exception : HCSException
	 * 
	 ***********************************/
	@Override
	public boolean removeTest(String testId) 
	{
		IAdminDAO adminDAO = new AdminDAOImpl();
		try 
		{
			return adminDAO.removeTest(testId);
		} 
		catch (HCSException e) 
		{
			System.out.println(e.getMessage());		
		}
		return false;
	}

	/***********************************
	 * 
	 * @Description : Method to approve and reject the Appointment
	 * @Author : Yashaswini
	 * @arg1 : Appointment, char
	 * 
	 * @returns: boolean
	 * @Exception : HCSException
	 * 
	 ***********************************/
	@Override
	public boolean approveRejectAppointment(int appId, char appStatus) 
	{
		IAdminDAO adminDAO = new AdminDAOImpl();
		try 
		{
			return adminDAO.approveRejectAppointment(appId, appStatus);
		}
		catch (HCSException e) 
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	/***********************************
	 * 
	 * @Description : Methods to view all appointments under a center
	 * @Author : Yashaswini
	 * @arg1 : DiagnosticCenter
	 * 
	 * @returns: List<Appointment>
	 * @Exception : HCSException
	 ***********************************/
	@Override
	public List<Appointment> viewAllAppointmentsByCenter(String centerId)
	{
		IAdminDAO adminDAO = new AdminDAOImpl();
		try 
		{
			return adminDAO.viewAllAppointmentsByCenter(centerId);
		}
		catch (HCSException e) 
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

	/***********************************
	 * 
	 * @Description : Method to view all Tests
	 * @Author : Pratik Prakash
	 * @arg1 : centerId
	 * 
	 * @returns: String
	 * @Exception : HCSException
	 * 
	 ***********************************/


	@Override
	public List<Test> viewAllTest(String centerId) 
	{
		IAdminDAO adminDAO = new AdminDAOImpl();
		try 
		{
			return adminDAO.viewAllTest(centerId);
		}
		catch (HCSException e) 
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	/***********************************
	 * 
	 * @Description : Method to view all Centers
	 * @Author : Alok Pattanaik
	 * No Arguments
	 * 
	 * @Exception : HCSException
	 * 
	 ***********************************/
	
	@Override

	public List<DiagnosticCenter> viewAllCenters()
	{
		IAdminDAO adminDAO = new AdminDAOImpl();
		try 
		{
			return adminDAO.viewAllCenters();
		}
		catch (HCSException e) 
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	  
}
