package com.cg.hcs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.cg.hcs.utility.StringSequenceIdGenerator;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

@Entity
public class DiagnosticCenter 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "center_seq")
    @GenericGenerator(
        name = "center_seq", 
        strategy = "com.cg.hcs.utility.StringSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "C"),
            @Parameter(name = StringSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(name = "center_id")
	private String centerId;
	private String centerName;
	private String location;
	private Long contactNo;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	private List<Test> listOfTests = new ArrayList<Test>();
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	private List<Appointment> listOfApps = new ArrayList<Appointment>();
	
	
	
	public DiagnosticCenter() {
		super();
	}

	public DiagnosticCenter(String centerId,String purpose)
	{
		this.centerId = centerId;
	}
	
	public DiagnosticCenter(String centerName) 
	{
		super();
		this.centerName = centerName;
		Test defaultTest1 = new Test("Blood Group",this);
		Test defaultTest2 = new Test("Blood Sugar",this);
		Test defaultTest3 = new Test("Blood Pressure",this);
		ArrayList<Test> listOfTests = new ArrayList<Test>();
		listOfTests.add(defaultTest1);
		listOfTests.add(defaultTest2);
		listOfTests.add(defaultTest3);
		
		this.listOfTests = listOfTests;
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
	
	public List<Appointment> getListOfApps() {
		return listOfApps;
	}

	public void setListOfApps(List<Appointment> listOfApps) {
		this.listOfApps = listOfApps;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "DiagnosticCenter [centerId=" + centerId + ", centerName=" + centerName + ", location=" + location
				+ ", contactNo=" + contactNo + ", listOfTests=" + listOfTests + ", listOfApps=" + listOfApps + "]";
	}

	
	
	
}