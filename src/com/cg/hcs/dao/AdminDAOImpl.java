/*package com.cg.hcs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.cg.hcs.entity.Appointment;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.exception.HCSException;
import com.cg.hcs.queryconstants.QueryConstants;
import com.cg.hcs.utility.JpaUtility;

This class deals with all the interactions with the database for the role of Admin
 * The functionality includes :
 * addCenter()
 * removeCenter()
 * addTest()
 * removeTest()
 * approveAppointment()
 * All these are public instance methods.


*//**********************************
 * @Description: HealthCareSystem Admin DAO Implementation
 * @author : Pratik, Alok, Yashaswini
 * @Date : 12/10/2020
 *
 **********************************//*
public class AdminDAOImpl implements IAdminDAO
{
	static final EntityManagerFactory factory = JpaUtility.getFactory();
	static final Logger LOGGER = Logger.getLogger(AdminDAOImpl.class);
	
	*//***********************************
	 * 
	 * @Description :Method to add DiagnosticCenter
	 * @Author : Alok Pattanaik
	 * @arg1 : Center
	 * 
	 * @returns: String
	 * @Exception : HCSException
	 * 
	 ***********************************//*
	@Override
	public String addCenter(DiagnosticCenter center) throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try
		{
			LOGGER.info("Inside User registration Method");
			
			transaction.begin();
			manager.persist(center);
			transaction.commit();
			
		}
		catch (PersistenceException e)
		{
			LOGGER.info("Error while adding a center.");
			
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
	
	*//***********************************
	 * 
	 * @Description : Method to delete DiagnosticCenter
	 * @Author : Alok Pattanaik
	 * @arg1 : Center
	 * 
	 * @returns: boolean
	 * @Exception : HCSException
	 * 
	 ***********************************//*
	@Override
	public boolean deleteCenter(DiagnosticCenter center) throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		EntityManager manager2 = factory.createEntityManager();
		EntityTransaction transaction2 = manager2.getTransaction();
		
		try
		{
			LOGGER.info("Inside delete center method.");
			
			transaction.begin();
			DiagnosticCenter centerFetched = manager.find(DiagnosticCenter.class, center.getCenterId());
			if(centerFetched == null)
				return false;
			transaction2.begin();
			Query query = manager2.createQuery(QueryConstants.GET_DELETE_STATUS);
			query.setParameter(1, centerFetched.getCenterId());
			transaction2.commit();
			manager.remove(centerFetched);
			transaction.commit();
			return true;
			
		}
		catch (PersistenceException e) 
		{
			LOGGER.info("Error while removing a center.");
			throw new HCSException("Error while removing the center" + e.getMessage());
		}
		finally
		{
			manager.close();
		}
		
		
	}
	
	
	*//***********************************
	 * 
	 * @Description : Method to add Test under a particular DiagnosticCenter
	 * @Author : Pratik Prakash
	 * @arg1 : Test
	 * 
	 * @returns: String
	 * @Exception : HCSException
	 * 
	 ***********************************//*
	@Override
	public String addTest(Test test) throws HCSException {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try
		{
			LOGGER.info("Inside add test method.");
			
			transaction.begin();
			DiagnosticCenter center = test.getCenter();
			DiagnosticCenter centerFetched = manager.find(DiagnosticCenter.class, center.getCenterId());
			test.setCenter(centerFetched);
			manager.persist(test);
			transaction.commit();
		}
		catch (PersistenceException e)
		{
			LOGGER.info("Error while adding test under a particular center.");
			
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
	
	
	*//***********************************
	 * 
	 * @Description : Method to remove Test
	 * @Author : Pratik Prakash
	 * @arg1 : Test
	 * 
	 * @returns: boolean
	 * @Exception : HCSException
	 * 
	 ***********************************//*
	@Override
	public boolean removeTest(Test test) throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try
		{
			LOGGER.info("Inside remove test method.");
			
			transaction.begin();
			Test testFetched = manager.find(Test.class, test.getTestId());
			manager.remove(testFetched);
			transaction.commit();
			return true;
		}
		catch (PersistenceException e) 
		{
			LOGGER.info("Error while removing the test under a particular center.");
			
			throw new HCSException("Error while removing test"+e.getMessage());
		}
		finally
		{
			manager.close();
		}
	}
	
	
	*//***********************************
	 * 
	 * @Description : Method to approve the Appointment
	 * @Author : Yashaswini
	 * @arg1 : Appointment, char
	 * 
	 * @returns: boolean
	 * @Exception : HCSException
	 * 
	 ***********************************//*
	@Override
	public boolean approveAppointment(Appointment appointment,char appStatus) throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try
		{
			LOGGER.info("Inside approve appointment method");
			
			transaction.begin();
			Appointment appointmentFetched = manager.find(Appointment.class, appointment.getAppId());
			appointmentFetched.setIsApproved(appStatus);
			manager.persist(appointmentFetched);
			transaction.commit();
			return true;
		}
		catch (PersistenceException e)
		{
			LOGGER.info("error while trying to approve the status of appointment.");
			
			if(transaction.isActive())
				transaction.rollback();
			throw new HCSException("Cannot find appointment"+ e.getMessage());
		}
		finally
		{
			manager.close();
		}
		
		
	}
	
	*//***********************************
	 * 
	 * @Description : Method to view all tests under a center
	 * @Author : Pratik Prakash
	 * @arg1 : DiaganosticCenter
	 * 
	 * @returns: List<Test>
	 * @Exception : HCSException
	 * 
	 ***********************************//*
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
	
	*//***********************************
	 * 
	 * @Description : Methods to view all pending appointments under a center
	 * @Author : Yashaswini
	 * @arg1 : DiagnosticCenter
	 * 
	 * @returns: List<Appointment>
	 * @Exception : HCSException
	 ***********************************//*
	@Override
	public List<Appointment> viewAllPendingAppointmentByCenter(DiagnosticCenter center) throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			LOGGER.info("Error while fetching all the pending appointments under a center");
			
			TypedQuery<Appointment> query = manager.createQuery(QueryConstants.GET_ALL_PENDING_APPOINTMENT_BY_CENTER,Appointment.class);
			query.setParameter(1,center.getCenterId());
			query.setParameter(2,'P');
			List<Appointment> listOfPendingAppointments = query.getResultList();
			return listOfPendingAppointments;
		}
		catch (PersistenceException e) 
		{
			LOGGER.info("Error while fetching all the pending appointments under a center");
			
			throw new HCSException("Error while retreiving all appointments"+ e.getMessage());
		}
		finally
		{
			manager.close();
		}
		
	}
	
}
*/
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
 * All these are public instance methods.
 * */
public class AdminDAOImpl implements IAdminDAO
{
	static final EntityManagerFactory factory = JpaUtility.getFactory();
	
	/* This method is used to add a new Diagnostic Center to the database
	 * 
	 * Argument - DiagnosticCenter object to be added in the database
	 * 
	 * return type - String which is the center Id of the newly created center
	 * 
	 * Exception : HCSException */
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
	
	/* This method is used to delete a Diagnostic Center existing in the database
	 * 
	 * Argument - DiagnosticCenter object which is to be deleted
	 * 
	 * return type - boolean - Whether or not the center is deleted
	 * 
	 * Exception : HCSException */
	@Override
	public boolean deleteCenter(DiagnosticCenter center) throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try
		{
			transaction.begin();
			DiagnosticCenter centerFetched = manager.find(DiagnosticCenter.class, center.getCenterId());
			if(centerFetched==null)
				return false;
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
	
	/* This method is used to add a new Test to a center in the database
	 * 
	 * Argument - Test object to be added
	 * 
	 * return type - String which is the test Id of the newly created test
	 * 
	 * Exception : HCSException */
	@Override
	public String addTest(Test test) throws HCSException 
	{
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
	
	/* This method is used to delete a Test existing in a center in the database
	 * 
	 * Argument - Test object which is to be deleted
	 * 
	 * return type - boolean - Whether or not the test is deleted
	 * 
	 * Exception : HCSException */
	@Override
	public boolean removeTest(String testId) throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try
		{
			transaction.begin();
			Query query = manager.createQuery(QueryConstants.DELETE_TEST);
			query.setParameter("testId", testId);
			query.executeUpdate();
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
	
	/* This method is used to approve or reject an appointment of a test existing in the database
	 * 
	 * Argument - int - Appointment Id of the appointment, char - The app status to which the appointment will update
	 * 
	 * return type - boolean - Whether or not the appointment's status is changed
	 * 
	 * Exception : HCSException */
	@Override
	public boolean approveRejectAppointment(int appId,char appStatus) throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try
		{
			transaction.begin();
			Appointment appointmentFetched = manager.find(Appointment.class, appId);
			appointmentFetched.setAppStatus(appStatus);
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
	
	/* This method is used to retrieve all the tests existing in a center in the database
	 * 
	 * Argument - String - center Id for which all the tests are to be retrieved
	 * 
	 * return type - List of Tests under that particular center
	 * 
	 * Exception : HCSException */
	@Override
	public List<Test> viewAllTest(String centerId) throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		List<Test> listOfTests = null;
		try
		{	
			TypedQuery<Test> query = manager.createQuery(QueryConstants.GET_TEST_LIST,Test.class);
			query.setParameter("centerId", centerId);
			listOfTests = query.getResultList();
			System.out.println(listOfTests);
			return listOfTests;
		}
		catch (PersistenceException e) 
		{
			throw new HCSException("Error while retreiving all tests");
		}
	}
	
	/* This method is used to retrieve all the appointments existing in a center in the database
	 * 
	 * Argument - String - center Id for which all the appointments are to be retrieved
	 * 
	 * return type - List of Appointments under that particular center
	 * 
	 * Exception : HCSException */
	@Override
	public List<Appointment> viewAllAppointmentsByCenter(String centerId) throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			TypedQuery<Appointment> query = manager.createQuery(QueryConstants.GET_ALL_APPOINTMENT_BY_CENTER,Appointment.class);
			query.setParameter("centerId", centerId);
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
	
	/* This method is used to retrieve all the centers in the database
	 * 
	 * No Arguments
	 * 
	 * return type - List of all Diagnostic Centers
	 * 
	 * Exception : HCSException */
	@Override
	public List<DiagnosticCenter> viewAllCenters() throws HCSException 
	{
		EntityManager manager = factory.createEntityManager();
		List<DiagnosticCenter> centersList = null;
		try
		{
			TypedQuery<DiagnosticCenter> query = manager.createQuery(QueryConstants.GET_DIAGNOSTICCENTER_LIST, DiagnosticCenter.class);
			centersList = query.getResultList();
			return centersList;
		}
		catch (PersistenceException e)
		{
			throw new HCSException("Error retrieving centers list");
		}
		finally 
		{
			manager.close();
		}
	}
	
}