package com.cg.hcs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Test {
	@Id
	private String testId;
	private String testName;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "centerId", referencedColumnName = "center_id")
	private DiagnosticCenter center;

	public Test() {
		super();
	}

	public Test(String testName, DiagnosticCenter center) {
		super();
		this.testName = testName;
		this.center = center;
	}

	public Test(String testId, String testName, DiagnosticCenter center) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.center = center;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public DiagnosticCenter getCenter() {
		return center;
	}

	public void setCenter(DiagnosticCenter center) {
		this.center = center;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testName=" + testName + ", center=" + center + "]";
	}

}
