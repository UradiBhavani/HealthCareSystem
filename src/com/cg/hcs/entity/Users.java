package com.cg.hcs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.cg.hcs.utility.StringSequenceIdGenerator;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;

/***************************************
 * 
 * Description : HealthCareSystem Users Class
 * @author : Reshma, Bhavani
 * @Date : 12/10/2020
 * 
 ***************************************/

@Entity
public class Users 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @GenericGenerator(
        name = "user_seq", 
        strategy = "com.cg.hcs.utility.StringSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
            @Parameter(name = StringSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "U_"),
            @Parameter(name = StringSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	//@Column(name = "user_id")
	private String userId;
	private String userPassword;
	private String userName;
	private Long contactNo;
	private String email;
	private String userRole;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Appointment> appointmentList;
	
	
	
	public Users() {
		super();
	}
	
	
	public Users(String userId) {
		super();
		this.userId = userId;
	}


	public Users(String userPassword, String userName, Long contactNo, String email, String userRole) {
		super();
		this.userPassword = userPassword;
		this.userName = userName;
		this.contactNo = contactNo;
		this.email = email;
		this.userRole = userRole;
	}



	public Users(String userId, String userPassword, String userName, Long contactNo, String email, String userRole,
			List<Appointment> appointmentList) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.contactNo = contactNo;
		this.email = email;
		this.userRole = userRole;
		this.appointmentList = appointmentList;
	}
	
	
	public String getUserId() {
		return userId;
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
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + ", contactNo="
				+ contactNo + ", email=" + email + ", userRole=" + userRole + ", appointmentList=" + appointmentList
				+ "]";
	}
	
	
	
	
	
	
}
