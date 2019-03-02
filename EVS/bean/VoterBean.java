/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : VoterBean.java
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
public class VoterBean implements Serializable {

	private int serialNo;
	private String candidateID;
	private String electionID;
	private String voterID;

	/**
	 * @return the candidateID
	 */
	public final String getCandidateID () {
		return candidateID;
	}

	/**
	 * @return the electionID
	 */
	public final String getElectionID () {
		return electionID;
	}

	/**
	 * @return the serialNo
	 */
	public final int getSerialNo () {
		return serialNo;
	}

	/**
	 * @return the voterID
	 */
	public final String getVoterID () {
		return voterID;
	}

	/**
	 * @param candidateID
	 *            the candidateID to set
	 */
	public final void setCandidateID (final String candidateID) {
		this.candidateID = candidateID;
	}

	/**
	 * @param electionID
	 *            the electionID to set
	 */
	public final void setElectionID (final String electionID) {
		this.electionID = electionID;
	}

	/**
	 * @param serialNo
	 *            the serialNo to set
	 */
	public final void setSerialNo (final int serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * @param voterID
	 *            the voterID to set
	 */
	public final void setVoterID (final String voterID) {
		this.voterID = voterID;
	}
}
