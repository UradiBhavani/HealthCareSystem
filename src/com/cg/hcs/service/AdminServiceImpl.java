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
public class AdminServiceImpl implements IAdminService 
{

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
