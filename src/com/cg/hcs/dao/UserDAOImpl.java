package com.cg.hcs.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.cg.hcs.entity.Users;
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
	
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;

	@Override
	public String register(Users user) {
		
		factory = JpaUtility.getFactory();
		
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
				
		try {
			manager.persist(user);
			transaction.commit();
		} catch (RuntimeException e) {
			transaction.rollback();
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			//manager.close();
			//factory.close();
		}
		return user.getUserId();
	}
	
	
	
	@Override
	public String getRoleCode(String userId) {
		
		factory = JpaUtility.getFactory();
		manager = factory.createEntityManager();
		Users user = null;

		
		try {
				user = manager.find(Users.class, userId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			
			manager.close();
			factory.close();
		}
		return user.getUserRole();
	}



	@Override
	public boolean validateUser(String userId, String password) {
		factory = JpaUtility.getFactory();
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			//manager.close();
			//factory.close();
		}
		return false;
	}
	

	@Override
	public List<String> getDiagnosticCentersList() {
		// TODO Auto-generated method stub
	
		factory = JpaUtility.getFactory();
		manager = factory.createEntityManager();
	
		Query query = manager.createQuery("select centerName from DiagnosticCenter");
		List<String> centersList = query.getResultList();
	
		return centersList;
	}
	
	@Override
	public List<String> getTestsList(String centerId) {
		factory = JpaUtility.getFactory();
		manager = factory.createEntityManager();
	
		Query query = manager.createQuery("select t.testName from Test t where t.centerId=:centerId");
		query.setParameter("centerId", centerId);
		
		List<String> testsList = query.getResultList();
	
		return testsList;
	}



	@Override
	public String makeAppointment(Appointment appointment) {
		
		factory = JpaUtility.getFactory();
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();

		transaction.begin();
		
		String result="unsuccessfull";
		try {
			manager.persist(appointment);
			transaction.commit();
			result="success";
		} catch (RuntimeException e) {
			transaction.rollback();
			System.out.println(e.getMessage());
		} finally {
			manager.close();
			factory.close();
		}
		
		return result;
	}



	@Override
	public Users getUser(String userId) {
		factory = JpaUtility.getFactory();
		
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();

		transaction.begin();
		
		Users user = null;
		try {
			user = manager.find(Users.class,userId);
			transaction.commit();
		} catch (RuntimeException e) {
			transaction.rollback();
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}
		
		return user;
	}



	@Override
	public Test getTest(String testName,String centerName) {
		factory = JpaUtility.getFactory();
		
		manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select * from Test t where t.testName=:testName and t.centerName=:centerName");
		query.setParameter("testName", testName);
		query.setParameter("centerName", centerName);
		
		Test test = (Test) query.getSingleResult();
		
		return test;
	}



	@Override
	public DiagnosticCenter getDiagnosticCenter(String centerName) {
		factory = JpaUtility.getFactory();
		manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select * from DiagnosticCenter c where c.centerName=:centerName");
		query.setParameter("centerName", centerName);
		
		DiagnosticCenter diagnosticCenter = (DiagnosticCenter) query.getSingleResult();
		
		return diagnosticCenter;
	}



	@Override
	public List<Appointment> getAppointmentStatus(String userId) {
		factory = JpaUtility.getFactory();
		manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select * from Appointment a where a.Users.userId=:userId");
		query.setParameter("userId", userId);
		List<Appointment> appointmentList = query.getResultList();
		return appointmentList;
	}



	@Override
	public String getApplicationId(String userId) {
		factory = JpaUtility.getFactory();
		manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select appId from Appointment a where a.userId=:userId");
		query.setParameter("userId", userId);
		//String appId = (String)query.getUniqueResult("appId");
		return null;
	}
		
	
}

