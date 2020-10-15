package com.cg.hcs.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.cg.hcs.entity.Users;
import com.cg.hcs.exception.HCSException;
import com.cg.hcs.queryconstants.QueryConstants;
import com.cg.hcs.utility.JpaUtility;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.cg.hcs.entity.Appointment;
import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.entity.Users;
import com.cg.hcs.utility.JpaUtility;

/***************************************
 * 
 * Description : HealthCareSystem DAO Implementation
 * 
 * @author : Reshma, Yashaswini, Bhavani
 * @Date : 12/10/2020
 * 
 ***************************************/

public class UserDAOImpl implements IUserDAO {

	static final EntityManagerFactory factory = JpaUtility.getFactory();
	EntityManager manager = null;
	EntityTransaction transaction = null;

	static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
	
	/***********************************
	 * 
	 * @Description : User registration Method
	 * @Author : Reshma
	 * @arg1 : Users
	 * 
	 * @returns: String
	 * @Exception : HCSException
	 ***********************************/

	@Override
	public String register(Users user) throws HCSException {
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();

		try {
			LOGGER.info("Inside User registration Method");
			
			manager.persist(user);
			transaction.commit();
		} catch (PersistenceException e) {
			LOGGER.info("Error while registering the user");
			
			if (transaction.isActive())
				transaction.rollback();
			throw new HCSException("Error while registering the new user");
		} finally {
			manager.close();
		}
		return user.getUserId();
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

	@Override
	public String getRoleCode(String userId) throws HCSException {

		manager = factory.createEntityManager();
		Users user = null;

		try {
			user = manager.find(Users.class, userId);
		} catch (PersistenceException e) {
			throw new HCSException("Error while retreiving the role code");
		} finally {
			manager.close();
		}
		return user.getUserRole();
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
	@Override
	public boolean validateUser(String userId, String password) throws HCSException {

		manager = factory.createEntityManager();
		Users user = null;

		try {
			LOGGER.info("Inside validate user method.");
			
			user = manager.find(Users.class, userId);
			if (user.getUserPassword().equals(password))
				return true;
			else
				return false;
		} catch (PersistenceException e) {
			LOGGER.info("Error while validating the user");
			
			throw new HCSException("Error while validating user");
		} finally {
			manager.close();
		}

	}

	/***********************************
	 * 
	 * @Description : Method to retrive the centers list
	 * @Author : Bhavani
	 *
	 *         No arguments
	 * 
	 * @returns: List<DiagnosticCenter>
	 * @Exception : HCSException
	 ***********************************/
	@Override
	public List<DiagnosticCenter> getDiagnosticCentersList() throws HCSException {

		manager = factory.createEntityManager();
		List<DiagnosticCenter> centersList = null;
		try {
			LOGGER.info("Inside get diagnostic center list method.");
			
			TypedQuery<DiagnosticCenter> query = manager.createQuery(QueryConstants.GET_DIAGNOSTICCENTER_LIST,
					DiagnosticCenter.class);
			centersList = query.getResultList();
		} catch (PersistenceException e) {
			LOGGER.info("Error while fetching the diagnostic centers list");
			
			throw new HCSException("Error while fetching centers List");
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			manager.close();
		}

		return centersList;
	}

	/***********************************
	 * 
	 * @Description : Method to retrive the Tests list under a particular
	 *              DiagnosticCenter
	 * @Author : Bhavani
	 * @arg1 : String
	 * 
	 * @returns: List<Test>
	 * @Exception : HCSException
	 ***********************************/
	@Override
	public List<Test> getTestsList(String centerId) throws HCSException {

		manager = factory.createEntityManager();

		List<Test> testsList = null;
		try {
			LOGGER.info("Inside get test list method.");
			
			TypedQuery<Test> query = manager.createQuery(QueryConstants.GET_TEST_LIST, Test.class);
			query.setParameter("centerId", centerId);
			testsList = query.getResultList();
		} catch (PersistenceException e) {
			LOGGER.info("Error while retriving the tests list.");
			
			throw new HCSException("Cannot retrieve test list from center " + centerId);
		} finally {
			manager.close();
		}
		return testsList;
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
	public int makeAppointment(Appointment appointment)  throws HCSException
	{

		manager = factory.createEntityManager();
		transaction = manager.getTransaction();

		try {
			LOGGER.info("Inside make appointment method.");			
			
			transaction.begin();
			Users user = manager.find(Users.class, appointment.getUser().getUserId());
			Test test = manager.find(Test.class, appointment.getTest().getTestId());
			DiagnosticCenter center = manager.find(DiagnosticCenter.class, test.getCenter().getCenterId());
			appointment.setUser(user);
			appointment.setTest(test);
			appointment.setCenter(center);
			manager.persist(appointment);
			transaction.commit();
			return appointment.getAppId();
		} catch (PersistenceException e) {
			LOGGER.info("Error while booking appointment for patient.");
			
			if (transaction.isActive())
				transaction.rollback();
			throw new HCSException("Error while making appointment" +e.getMessage());
			
		} finally {
			manager.close();
		}

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
	public Users getUser(String userId) throws HCSException {

		manager = factory.createEntityManager();
		transaction = manager.getTransaction();

		Users user = null;

		try {
			LOGGER.info("Inide get user method.");
			
			transaction.begin();
			user = manager.find(Users.class, userId);
			transaction.commit();
			return user;
		} catch (RuntimeException e) {
			LOGGER.info("Error while retriving the user details.");
			if (transaction.isActive())
				transaction.rollback();
			throw new HCSException("Error while retreiving user");
		} finally {
			manager.close();
		}

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
	public Test getTest(String testId) throws HCSException {

		manager = factory.createEntityManager();
		try {
			LOGGER.info("Inside get test method.");
			System.out.println("Inside get test method"+testId);
			
			Test test = manager.find(Test.class, testId);
			return test;
		} catch (PersistenceException e) {
			LOGGER.info("Error while retriving the test deatils under a particular center.");
			
			throw new HCSException("Error while getting test");
		}

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
	public DiagnosticCenter getDiagnosticCenter(String centerId) throws HCSException {

		manager = factory.createEntityManager();
		DiagnosticCenter center = null;
		try {
			LOGGER.info("Inside get diagnostic center method.");
			
			center = manager.find(DiagnosticCenter.class, centerId);
			return center;
		} catch (PersistenceException e) {
			LOGGER.info("Error while retriving the details of diagnostic center.");
			
			throw new HCSException("Error while retrieving center with id " + centerId);
		} finally {
			manager.close();
		}

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
	@Transactional
	@Override
	public List<Appointment> getAppointmentStatus(Users user) throws HCSException {

		manager = factory.createEntityManager();
		List<Appointment> appointmentList = null;
		try {
			LOGGER.info("Inside get appointment status method.");
			
			TypedQuery<Appointment> query = manager.createQuery(QueryConstants.GET_APPOINTMENT_STATUS,
					Appointment.class);
			query.setParameter("user", user);
			appointmentList = query.getResultList();
			return appointmentList;
		} catch (PersistenceException e) {
			LOGGER.info("Error while fetching the status of appointment by customer.");
			throw new HCSException("Error while retrieving all appointments");
		} finally {
			manager.close();
		}
	}

	/***********************************
	 * 
	 * @Description : Method to retrieve the applicationId using userId
	 * @Author : Reshma
	 * @arg1 : String
	 * 
	 * @returns: String
	 * @Exception : HCSException
	 * 
	 ***********************************/
	@Override
	public String getApplicationId(String userId) {

		manager = factory.createEntityManager();

		// Query query = manager.createQuery("select appId from Appointment a
		// where a.userId=:userId");
		// query.setParameter("userId", userId);
		// //String appId = (String)query.getUniqueResult("appId");
		return null;
	}

}
