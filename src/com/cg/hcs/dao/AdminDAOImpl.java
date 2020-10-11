package com.cg.hcs.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.cg.hcs.entity.DiagnosticCenter;
import com.cg.hcs.entity.Test;
import com.cg.hcs.exception.HCSException;
import com.cg.hcs.utility.JpaUtility;

public class AdminDAOImpl implements IAdminDAO {
	static final EntityManagerFactory factory = JpaUtility.getFactory();

	@Override
	public String addCenter(DiagnosticCenter center) throws HCSException {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(center);
			transaction.commit();

		} catch (PersistenceException e) {
			if (transaction.isActive())
				transaction.rollback();
			throw new HCSException("Error while commiting the transaction");

		} finally {
			manager.close();
		}
		return center.getCenterId();

	}

	@Override
	public boolean deleteCenter(DiagnosticCenter center) throws HCSException {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			DiagnosticCenter centerFetched = manager.find(DiagnosticCenter.class, center.getCenterId());
			if (centerFetched == null)
				return false;
			manager.remove(centerFetched);
			transaction.commit();
			return true;

		} catch (PersistenceException e) {
			throw new HCSException("Error while removing the center");

		} finally {
			manager.close();
		}

	}

	@Override
	public String addTest(Test test) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeTest(Test test) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approveAppointment() {
		// TODO Auto-generated method stub
		return false;
	}

}
