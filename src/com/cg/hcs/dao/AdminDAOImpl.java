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
import com.cg.hcs.queryconstants.QueryConstants;
import com.cg.hcs.utility.JpaUtility;

/*This class deals with all the interactions with the database for the role of Admin
 * The functionality includes :
 * addCenter()
 * removeCenter()
 * addTest()
 * removeTest()
 * approveAppointment()
 * All these are public instance methods.*/


/**********************************
 * @Description: HealthCareSystem Admin DAO Implementation
 * @author : Pratik, Alok, Yashaswini
 * @Date : 12/10/2020
 *
 **********************************/
public class AdminDAOImpl implements IAdminDAO
{
	static final EntityManagerFactory factory = JpaUtility.getFactory();
	
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
			//manager2.createQuery(QueryConstants.GET_DELETE_STATUS).executeUpdate();
			Query query = manager2.createQuery(QueryConstants.GET_DELETE_STATUS);
			query.setParameter(1, centerFetched.getCenterId());
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
	
	/***********************************
	 * 
	 * @Description : Method to view all tests under a center
	 * @Author : Pratik Prakash
	 * @arg1 : DiaganosticCenter
	 * 
	 * @returns: List<Test>
	 * @Exception : HCSException
	 * 
	 ***********************************/
	@Override
	public List<Test> viewAllTest(DiagnosticCenter center) 
	{
		EntityManager manager = factory.createEntityManager();
		Test test = new Test(null, null, center);
	TypedQuery<Test> query = manager.createQuery(QueryConstants.GET_ALL_TESTS,Test.class);
	    query.setParameter(1, test.getCenter().getCenterId());
		List<Test> listOfTests = query.getResultList();
		System.out.println(listOfTests);
		return listOfTests;
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
	public List<Appointment> viewAllPendingAppointmentByCenter(DiagnosticCenter center) throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			TypedQuery<Appointment> query = manager.createQuery(QueryConstants.GET_ALL_PENDING_APPOINTMENT_BY_CENTER,Appointment.class);
			query.setParameter(1,center.getCenterId());
			query.setParameter(2,'P');
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
