package com.res.DTO;

import java.sql.Timestamp;

public class User {

	private int userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userAddress;
	private String userRole;
	private Timestamp userCreatedDate;
	private Timestamp userLastLoginDate;

	public User() {

	}

	public User(String userName, String userEmail, String userPassword, String userAddress, String userRole) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userRole = userRole;

	}

	public User(int userId, String userName, String userEmail, String userPassword, String userAddress, String userRole,
			Timestamp userCreatedDate, Timestamp userLastLoginDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userRole = userRole;
		this.userCreatedDate = userCreatedDate;
		this.userLastLoginDate = userLastLoginDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Timestamp getUserCreatedDate() {
		return userCreatedDate;
	}

	public void setUserCreatedDate(Timestamp userCreatedDate) {
		this.userCreatedDate = userCreatedDate;
	}

	public Timestamp getUserLastLoginDate() {
		return userLastLoginDate;
	}

	public void setUserLastLoginDate(Timestamp userLastLoginDate) {
		this.userLastLoginDate = userLastLoginDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userAddress=" + userAddress + ", userRole=" + userRole + ", userCreatedDate="
				+ userCreatedDate + ", userLastLoginDate=" + userLastLoginDate + "]";
	}

}
