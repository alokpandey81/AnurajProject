/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : ElectionBean.java
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
public class ElectionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4616400372256335754L;
	private String electionID;
	private String name;
	private Date electionDate;
	private String district;
	private String constituency;
	private Date countingDate;

	/**
	 * @return the electionID
	 */
	public String getElectionID () {
		return electionID;
	}

	/**
	 * @param electionID
	 *            the electionID to set
	 */
	public void setElectionID (final String electionID) {
		this.electionID = electionID;
	}

	/**
	 * @return the name
	 */
	public String getName () {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName (final String name) {
		this.name = name;
	}

	/**
	 * @return the electionDate
	 */
	public Date getElectionDate () {
		return electionDate;
	}

	/**
	 * @param electionDate
	 *            the electionDate to set
	 */
	public void setElectionDate (final Date electionDate) {
		this.electionDate = electionDate;
	}

	/**
	 * @return the district
	 */
	public String getDistrict () {
		return district;
	}

	/**
	 * @param district
	 *            the district to set
	 */
	public void setDistrict (final String district) {
		this.district = district;
	}

	/**
	 * @return the constituency
	 */
	public String getConstituency () {
		return constituency;
	}

	/**
	 * @param constituency
	 *            the constituency to set
	 */
	public void setConstituency (final String constituency) {
		this.constituency = constituency;
	}

	/**
	 * @return the countingDate
	 */
	public Date getCountingDate () {
		return countingDate;
	}

	/**
	 * @param countingDate
	 *            the countingDate to set
	 */
	public void setCountingDate (final Date countingDate) {
		this.countingDate = countingDate;
	}

}
