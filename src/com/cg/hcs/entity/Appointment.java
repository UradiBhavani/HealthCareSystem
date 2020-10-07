package com.cg.hcs.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Appointment 
{
	@Id
	private long appointmentId;
	private java.sql.Date appointmentDateTime;
	private boolean isApproved;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="center", referencedColumnName="centerId")
	private Test test;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user", referencedColumnName="userId")
	private Users user;

	public Appointment() {
		super();
	}


	public Appointment(java.sql.Date appointmentDateTime, boolean isApproved, Test test, Users user) {
		super();
		this.appointmentDateTime = appointmentDateTime;
		this.isApproved = isApproved;
		this.test = test;
		this.user = user;
	}

	public Appointment(long appointmentId, java.sql.Date appointmentDateTime, boolean isApproved, Test test,
			Users user) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDateTime = appointmentDateTime;
		this.isApproved = isApproved;
		this.test = test;
		this.user = user;
	}




	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public java.sql.Date getDateTime() {
		return appointmentDateTime;
	}

	public void setDateTime(java.sql.Date dateTime) {
		this.appointmentDateTime = dateTime;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean approved) {
		this.isApproved = approved;
	}
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public java.sql.Date getAppointmentDateTime() {
		return appointmentDateTime;
	}

	public void setAppointmentDateTime(java.sql.Date appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentDateTime=" + appointmentDateTime
				+ ", isApproved=" + isApproved + ", test=" + test + ", user=" + user + "]";
	}
	
	
	
}