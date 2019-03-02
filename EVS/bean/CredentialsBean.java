/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : CredentialsBean.java
 *
 * Description     :Electronic Voting System.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :28-MAR-2014
 * 
 * Modification History:Modified by Jeeshan & Mayank, on date 02-APR-2014.
 **/
package com.wipro.evs.bean;

import java.io.Serializable;

/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public class CredentialsBean implements Serializable {

	private String userID;
	private String password;
	private String userType;
	private int loginStatus;

	/**
	 * @param userID
	 * @param password
	 * @param userType
	 */
	public CredentialsBean() {
		super();
		userID = "";
		password = "";
		userType = "";
	}

	public String getUserID () {
		return userID;
	}

	public void setUserID (final String userID) {
		this.userID = userID;
	}

	public String getPassword () {
		return password;
	}

	public void setPassword (final String password) {
		this.password = password;
	}

	public String getUserType () {
		return userType;
	}

	public void setUserType (final String userType) {
		this.userType = userType;
	}

	public int getLoginStatus () {
		return loginStatus;
	}

	public void setLoginStatus (final int loginStatus) {
		this.loginStatus = loginStatus;
	}

}
