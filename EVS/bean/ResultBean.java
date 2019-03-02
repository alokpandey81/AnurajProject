/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : ResultBean.java
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
public class ResultBean implements Serializable {

	private int serialNo;
	private String electionID;
	private String candidateID;
	private int voteCount;

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
	 * @return the voteCount
	 */
	public final int getVoteCount () {
		return voteCount;
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
	 * @param voteCount
	 *            the voteCount to set
	 */
	public final void setVoteCount (final int voteCount) {
		this.voteCount = voteCount;
	}
}
