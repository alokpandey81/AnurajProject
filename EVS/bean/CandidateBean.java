/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : CandidateBean.java
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
import java.util.Date;

/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public class CandidateBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8397421557985261039L;
	private String candidateID;
	private String name;
	private String electionID;
	private String partyID;
	private String district;
	private String constituency;
	private Date dateOfBirth;
	private String mobileNo;
	private String address;
	private String emailID;

	/**
	 * @return the address
	 */
	public final String getAddress () {
		return address;
	}

	/**
	 * @return the candidateID
	 */
	public final String getCandidateID () {
		return candidateID;
	}

	/**
	 * @return the constituency
	 */
	public final String getConstituency () {
		return constituency;
	}

	/**
	 * @return the dateOfBirth
	 */
	public final Date getDateOfBirth () {
		return dateOfBirth;
	}

	/**
	 * @return the district
	 */
	public final String getDistrict () {
		return district;
	}

	/**
	 * @return the electionID
	 */
	public final String getElectionID () {
		return electionID;
	}

	/**
	 * @return the emailID
	 */
	public final String getEmailID () {
		return emailID;
	}

	/**
	 * @return the mobileNo
	 */
	public final String getMobileNo () {
		return mobileNo;
	}

	/**
	 * @return the name
	 */
	public final String getName () {
		return name;
	}

	/**
	 * @return the partyID
	 */
	public final String getPartyID () {
		return partyID;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public final void setAddress (final String address) {
		this.address = address;
	}

	/**
	 * @param candidateID
	 *            the candidateID to set
	 */
	public final void setCandidateID (final String candidateID) {
		this.candidateID = candidateID;
	}

	/**
	 * @param constituency
	 *            the constituency to set
	 */
	public final void setConstituency (final String constituency) {
		this.constituency = constituency;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public final void setDateOfBirth (final Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @param district
	 *            the district to set
	 */
	public final void setDistrict (final String district) {
		this.district = district;
	}

	/**
	 * @param electionID
	 *            the electionID to set
	 */
	public final void setElectionID (final String electionID) {
		this.electionID = electionID;
	}

	/**
	 * @param emailID
	 *            the emailID to set
	 */
	public final void setEmailID (final String emailID) {
		this.emailID = emailID;
	}

	/**
	 * @param mobileNo
	 *            the mobileNo to set
	 */
	public final void setMobileNo (final String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName (final String name) {
		this.name = name;
	}

	/**
	 * @param partyID
	 *            the partyID to set
	 */
	public final void setPartyID (final String partyID) {
		this.partyID = partyID;
	}
}
