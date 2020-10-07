package com.cg.hcs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

import javax.persistence.CascadeType;

@Entity
public class DiagnosticCenter 
{
	@Id
	@Column(name="centerId")
	private String centerId;
	private String centerName;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Test> listOfTests;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Appointment> listOfAppointments;
	public DiagnosticCenter(String centerName) {
		super();
		this.centerId = "C000001";
		
		this.centerName = centerName;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public List<Test> getListOfTests() {
		return listOfTests;
	}
	public void setListOfTests(List<Test> listOfTests) {
		this.listOfTests = listOfTests;
	}
	public List<Appointment> getListOfAppointments() {
		return listOfAppointments;
	}
	public void setListOfAppointments(List<Appointment> listOfAppointments) {
		this.listOfAppointments = listOfAppointments;
	}
	
	
	
	
	
}