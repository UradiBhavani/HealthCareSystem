package com.cg.hcs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;

@Entity
public class Users 
{
	@Id
	private String userId;
	private String userPassword;
	private String userName;
	private Long contactNo;
	private String email;
	private String userRole;
	//@OneToMany(cascade = CascadeType.ALL)
	//private List<DiagnosticCenter> centerList;
	
	
	
	public Users() {
		super();
	}
	/*public Users(String userId, String userPassword, String userName, Long contactNo, String email, String userRole,
			List<DiagnosticCenter> centerList) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.contactNo = contactNo;
		this.email = email;
		this.userRole = userRole;
		this.centerList = centerList;
	}*/
	
	public String getUserId() {
		return userId;
	}
	public Users(String userId, String userPassword, String userName, Long contactNo, String email, String userRole) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.contactNo = contactNo;
		this.email = email;
		this.userRole = userRole;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	/*public List<DiagnosticCenter> getCenterList() {
		return centerList;
	}
	public void setCenterList(List<DiagnosticCenter> centerList) {
		this.centerList = centerList;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + ", contactNo="
				+ contactNo + ", email=" + email + ", userRole=" + userRole + ", centerList=" + centerList + "]";
	}*/

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + ", contactNo="
				+ contactNo + ", email=" + email + ", userRole=" + userRole + "]";
	}
	
	
	
	
	
	
}
