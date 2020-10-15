package com.cg.hcs.queryconstants;

/**********************************
 * @Description: HealthCareSystem QueryConstants
 * @author : Bhavani, Reshma
 * @Date : 12/10/2020
 *
 **********************************/
public class QueryConstants {
	
	
	//User Queries
	
	public static final String GET_DIAGNOSTICCENTER_LIST = "select c from DiagnosticCenter c";
	
	public static final String GET_TEST_LIST = "SELECT t FROM Test t where t.center.centerId = :centerId";
	
	public static final String GET_TEST = "SELECT t from Test t where t.testId = ?";
	
	public static final String GET_APPOINTMENT_STATUS = "Select a from Appointment a where a.user = :user";
	
	//Admin Queries
	
	public static final String GET_DELETE_STATUS = "Delete a from appoinment a where a.center = ?";
	
	public static final String GET_ALL_TESTS = "SELECT t from Test t WHERE t.center=?";
	
	public static final String GET_ALL_PENDING_APPOINTMENT_BY_CENTER = "SELECT a FROM Appointment a WHERE a.center = ? AND a.isApproved = ?";
}
