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

	@Override

	public List<DiagnosticCenter> viewAllCenters() {
		// TODO Auto-generated method stub
		return null;
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
	public boolean removeTest(Test test) 
	{
		IAdminDAO adminDAO = new AdminDAOImpl();
		try 
		{
			return adminDAO.removeTest(test);
		} 
		catch (HCSException e) 
		{
			System.out.println(e.getMessage());		
		}
		return false;
	}

	/***********************************
	 * 
	 * @Description : Method to approve the Appointment
	 * @Author : Yashaswini
	 * @arg1 : Appointment, char
	 * 
	 * @returns: boolean
	 * @Exception : HCSException
	 * 
	 ***********************************/
	@Override
	public boolean approveAppointment(Appointment appointment,char appStatus) 
	{
		IAdminDAO adminDAO = new AdminDAOImpl();
		try 
		{
			return adminDAO.approveAppointment(appointment, appStatus);
		}
		catch (HCSException e) 
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	/***********************************
	 * 
	 * @Description : Methods to view all pending appointments under a center
	 * @Author : Yashaswini
	 * @arg1 : DiagnosticCenter
	 * 
	 * @returns: List<Appointment>
	 * @Exception : HCSException
	 ***********************************/
	@Override
	public List<Appointment> viewAllPendingAppointmentByCenter(DiagnosticCenter center)
	{
		IAdminDAO adminDAO = new AdminDAOImpl();
		try 
		{
			return adminDAO.viewAllPendingAppointmentByCenter(center);
		}
		catch (HCSException e) 
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
}
