package com.cg.hcs.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.cg.hcs.utility.StringSequenceIdGenerator;

/***************************************
 * 
 * Description : HealthCareSystem Appointment class
 * @author : Yashaswini
 * @Date : 12/10/2020
 * 
 ***************************************/

@Entity
@Table(
		uniqueConstraints= 
		{@UniqueConstraint (columnNames={"appDate","testId"}),
		 @UniqueConstraint (columnNames={"appDate","testId"})
		}
		
		)
public class Appointment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "center_seq")
    @GenericGenerator(
        name = "center_seq", 
        strategy = "com.cg.hcs.utility.StringSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
            @Parameter(name = StringSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = ""),
            @Parameter(name = StringSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private int appId;
	private String appDate;
	private char isApproved;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="testId", referencedColumnName="testId")
	private Test test;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="userId", referencedColumnName="userId")
	private Users user;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "centerId", referencedColumnName = "center_id")
	private DiagnosticCenter center;
	
	public Appointment() {
		super();
	}


	public Appointment(String appDate, char isApproved, Test test, Users user) {
		super();
		this.appDate = appDate;
		this.isApproved = isApproved;
		this.test = test;
		this.user = user;
	}

	public Appointment(int appId, String appDate, char isApproved, Test test,
			Users user) {
		super();
		this.appId = appId;
		this.appDate = appDate;
		this.isApproved = isApproved;
		this.test = test;
		this.user = user;
	}


	
	
	public DiagnosticCenter getCenter() 
	{
		return center;
	}


	public void setCenter(DiagnosticCenter center) {
		this.center = center;
	}


	public int getAppointmentId() {
		return appId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appId = appointmentId;
	}



	public char isApproved() {
		return isApproved;
	}

	public void setApproved(char approved) {
		this.isApproved = approved;
	}
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getAppointmentDateTime() {
		return appDate;
	}

	public void setAppointmentDateTime(String appointmentDateTime) {
		this.appDate = appointmentDateTime;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	
	
	
	public int getAppId() {
		return appId;
	}


	public void setAppId(int appId) {
		this.appId = appId;
	}


	public String getAppDate() {
		return appDate;
	}


	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}


	public char getIsApproved() {
		return isApproved;
	}


	public void setIsApproved(char isApproved) {
		this.isApproved = isApproved;
	}


	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appId + ", appointmentDateTime=" + appDate
				+ ", isApproved=" + isApproved + ", test=" + test + ", user=" + user + "]";
	}
	
	
}