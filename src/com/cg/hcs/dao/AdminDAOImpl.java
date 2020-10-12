package com.cg.hcs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.hcs.entity.Appointment;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.exception.HCSException;
import com.cg.hcs.utility.JpaUtility;

/*This class deals with all the interactions with the database for the role of Admin
 * The functionality includes :
 * addCenter()
 * removeCenter()
 * addTest()
 * removeTest()
 * approveAppointment()
 * All these are public instance methods.*/
public class AdminDAOImpl implements IAdminDAO
{
	static final EntityManagerFactory factory = JpaUtility.getFactory();
	@Override
	public String addCenter(DiagnosticCenter center) throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try
		{
			transaction.begin();
			manager.persist(center);
			transaction.commit();
			
		}
		catch (PersistenceException e)
		{
			if(transaction.isActive())
				transaction.rollback();
			throw new HCSException("Error while commiting the transaction"+ e.getMessage());
			
		}
		finally 
		{
			manager.close();
		}
		return center.getCenterId();
		
		
	}
	@Override
	public boolean deleteCenter(DiagnosticCenter center) throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		EntityManager manager2 = factory.createEntityManager();
		EntityTransaction transaction2 = manager2.getTransaction();
		
		try
		{
			transaction.begin();
			DiagnosticCenter centerFetched = manager.find(DiagnosticCenter.class, center.getCenterId());
			if(centerFetched == null)
				return false;
			transaction2.begin();
			manager2.createQuery("Delete a from appoinment a where a.center = '"+centerFetched.getCenterId()+"'").executeUpdate();
//			manager.remove(centerFetched.getListOfApps());
//			manager.remove(centerFetched.getListOfTests());
			transaction2.commit();
			manager.remove(centerFetched);
			transaction.commit();
			return true;
			
		}
		catch (PersistenceException e) 
		{
			throw new HCSException("Error while removing the center" + e.getMessage());
		}
		finally
		{
			manager.close();
		}
		
		
	}
	@Override
	public String addTest(Test test) throws HCSException {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try
		{
			transaction.begin();
			DiagnosticCenter center = test.getCenter();
			DiagnosticCenter centerFetched = manager.find(DiagnosticCenter.class, center.getCenterId());
			test.setCenter(centerFetched);
			manager.persist(test);
			transaction.commit();
		}
		catch (PersistenceException e)
		{
			if(transaction.isActive())
				transaction.rollback();
			e.printStackTrace();
			throw new HCSException("Error while commiting the transaction"+ e.getMessage());
		}
		finally
		{
			manager.close();
		}
		return test.getTestId();
	}
	@Override
	public boolean removeTest(Test test) throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try
		{
			transaction.begin();
			Test testFetched = manager.find(Test.class, test.getTestId());
			manager.remove(testFetched);
			transaction.commit();
			return true;
		}
		catch (PersistenceException e) 
		{
			throw new HCSException("Error while removing test"+e.getMessage());
		}
		finally
		{
			manager.close();
		}
	}
	
	@Override
	public boolean approveAppointment(Appointment appointment,char appStatus) throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try
		{
			transaction.begin();
			Appointment appointmentFetched = manager.find(Appointment.class, appointment.getAppId());
			appointmentFetched.setIsApproved(appStatus);
			manager.persist(appointmentFetched);
			transaction.commit();
			return true;
		}
		catch (PersistenceException e)
		{
			if(transaction.isActive())
				transaction.rollback();
			throw new HCSException("Cannot find appointment"+ e.getMessage());
		}
		finally
		{
			manager.close();
		}
		
		
	}
	
	
	@Override
	public List<Test> viewAllTest(DiagnosticCenter center) 
	{
		EntityManager manager = factory.createEntityManager();
		Test test = new Test(null, null, center);
		TypedQuery<Test> query = manager.createQuery("SELECT t from Test t WHERE t.center="+"'"+test.getCenter().getCenterId()+"'",Test.class);
		List<Test> listOfTests = query.getResultList();
		System.out.println(listOfTests);
		return listOfTests;
	}
	
	@Override
	public List<Appointment> viewAllPendingAppointmentByCenter(DiagnosticCenter center) throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			TypedQuery<Appointment> query = manager.createQuery("SELECT a FROM Appointment a WHERE a.center = '"+center.getCenterId()+"' AND a.isApproved = 'P'",Appointment.class);
			List<Appointment> listOfPendingAppointments = query.getResultList();
			return listOfPendingAppointments;
		}
		catch (PersistenceException e) 
		{
			throw new HCSException("Error while retreiving all appointments"+ e.getMessage());
		}
		finally
		{
			manager.close();
		}
		
	}
	
}
