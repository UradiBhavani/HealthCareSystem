package com.cg.hcs.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.hcs.entity.Users;
import com.cg.hcs.exception.HCSException;
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



public class UserDAOImpl implements IUserDAO{
	
	static final EntityManagerFactory factory = JpaUtility.getFactory();
	EntityManager manager = null;
	EntityTransaction transaction = null;

	@Override
	public String register(Users user) throws HCSException 
	{
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
				
		try
		{
			manager.persist(user);
			transaction.commit();
		}
		catch (PersistenceException e)
		{
			if(transaction.isActive())
				transaction.rollback();
			throw new HCSException("Error while registering the new user");
		}
		finally 
		{
			manager.close();
		}
		return user.getUserId();
	}
	
	
	
	@Override
	public String getRoleCode(String userId) throws HCSException 
	{
	
		manager = factory.createEntityManager();
		Users user = null;

		
		try 
		{
			user = manager.find(Users.class, userId);
		} 
		catch (PersistenceException e) 
		{
			throw new HCSException("Error while retreiving the role code");
		}
		finally 
		{	
			manager.close();
		}
		return user.getUserRole();
	}



	@Override
	public boolean validateUser(String userId, String password) throws HCSException 
	{
	
		manager = factory.createEntityManager();
		Users user = null;
		
		try {
				System.out.println(userId+" "+password);
				user = manager.find(Users.class, userId);
				System.out.println(user);
				if(user.getUserPassword().equals(password))
					return true;
				else
					return false;
		} 
		catch (PersistenceException e)
		{
			throw new HCSException("Error while validating user");
		}
		finally 
		{
			manager.close();
		}
		
	}
	

	@Override
	public List<DiagnosticCenter> getDiagnosticCentersList() throws HCSException 
	{
		
		manager = factory.createEntityManager();
		List<DiagnosticCenter> centersList = null;
		try
		{
			TypedQuery<DiagnosticCenter> query = manager.createQuery("select c from DiagnosticCenter c",DiagnosticCenter.class);
			centersList = query.getResultList();
		}
		catch (PersistenceException e) 
		{
			throw new HCSException("Error while fetching centers List");
		}
		finally 
		{
			manager.close();
		}
	
		return centersList;
	}
	
	@Override
	public List<Test> getTestsList(String centerId) throws HCSException 
	{
		
		manager = factory.createEntityManager();
		
		List<Test> testsList = null;
		try
		{
			TypedQuery<Test> query = manager.createQuery("SELECT t FROM Test t where t.center = '"+centerId+"'", Test.class); 
			testsList = query.getResultList();
		}
		catch (PersistenceException e) 
		{
			throw new HCSException("Cannot retrieve test list from center "+centerId);
		}
		finally
		{
			manager.close();
		}
		return testsList;
	}



	@Override
	public int makeAppointment(Appointment appointment) //throws HCSException 
	{
		
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		
		
		try 
		{
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
		} 
		catch (PersistenceException e)
		{
			if(transaction.isActive())
				transaction.rollback();
//			throw new HCSException("Error while making appointment" + e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			manager.close();
		}
		return 0;
		
	}



	@Override
	public Users getUser(String userId) throws HCSException 
	{
		
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();

		Users user = null;
		
		try
		{
			transaction.begin();
			user = manager.find(Users.class,userId);
			transaction.commit();
			return user;
		} 
		catch (RuntimeException e) 
		{
			if(transaction.isActive())
				transaction.rollback();
			throw new HCSException("Error while retreiving user");
		}
		finally
		{
			manager.close();
		}
		
	}



	@Override
	public Test getTest(String testName,String centerId) throws HCSException 
	{
		
		
		manager = factory.createEntityManager();
		try
		{
			TypedQuery<Test> query = manager.createQuery("SELECT t from Test t where t.testName = '"+testName+"' and t.center ='"+centerId+"'", Test.class); 
			Test test = query.getSingleResult();
			return test;
		}
		catch (PersistenceException e)
		{
			throw new HCSException("Error while getting test");
		}
		
	}



	@Override
	public DiagnosticCenter getDiagnosticCenter(String centerId) throws HCSException {
		
		manager = factory.createEntityManager();
		DiagnosticCenter center = null;
		try
		{
			center = manager.find(DiagnosticCenter.class, centerId);
			return center;
		}
		catch(PersistenceException e)
		{
			throw new HCSException("Error while retrieving center with id "+centerId);
		}
		finally
		{
			manager.close();
		}
		
	}



	@Override
	public List<Appointment> getAppointmentStatus(String userId) throws HCSException 
	{
		
		manager = factory.createEntityManager();
		List<Appointment> appointmentList = null;
		try
		{
			TypedQuery<Appointment> query = manager.createQuery("Select a from Appointment a where a.user = '"+userId+"'", Appointment.class);
			appointmentList = query.getResultList();
			return appointmentList;
		}
		catch (PersistenceException e) 
		{
			throw new HCSException("Error while retrieving all appointments");
		}
		finally
		{
			manager.close();
		}
	}



	@Override
	public String getApplicationId(String userId) 
	{
		
		manager = factory.createEntityManager();
		
//		Query query = manager.createQuery("select appId from Appointment a where a.userId=:userId");
//		query.setParameter("userId", userId);
//		//String appId = (String)query.getUniqueResult("appId");
		return null;
	}
		
	
}

