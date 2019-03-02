/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : ApplicationBean.java
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
public class ApplicationBean implements Serializable {

	/**
	 * 
	 */
	private int approvedStatus;
	private String constituency;
	private int passedStatus;
	private String userID;
	private String voterID;

	/**
	 * @return the approvedStatus
	 */
	public final int getApprovedStatus () {
		return approvedStatus;
	}

	/**
	 * @return the constituency
	 */
	public final String getConstituency () {
		return constituency;
	}

	/**
	 * @return the passedStatus
	 */
	public final int getPassedStatus () {
		return passedStatus;
	}

	/**
	 * @return the userID
	 */
	public final String getUserID () {
		return userID;
	}

	/**
	 * @return the voterID
	 */
	public final String getVoterID () {
		return voterID;
	}

	/**
	 * @param approvedStatus
	 *            the approvedStatus to set
	 */
	public final void setApprovedStatus (final int approvedStatus) {
		this.approvedStatus = approvedStatus;
	}

	/**
	 * @param constituency
	 *            the constituency to set
	 */
	public final void setConstituency (final String constituency) {
		this.constituency = constituency;
	}

	/**
	 * @param passedStatus
	 *            the passedStatus to set
	 */
	public final void setPassedStatus (final int passedStatus) {
		this.passedStatus = passedStatus;
	}

	/**
	 * @param userID
	 *            the userID to set
	 */
	public final void setUserID (final String userID) {
		this.userID = userID;
	}

	/**
	 * @param voterID
	 *            the voterID to set
	 */
	public final void setVoterID (final String voterID) {
		this.voterID = voterID;
	}

}
