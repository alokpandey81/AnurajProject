/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : EOBean.java
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
public class EOBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6579968925667543658L;
	private String constituency;
	private String electoralOfficerID;

	/**
	 * @return the constituency
	 */
	public final String getConstituency () {
		return constituency;
	}

	/**
	 * @return the electoralOfficerID
	 */
	public final String getElectoralOfficerID () {
		return electoralOfficerID;
	}

	/**
	 * @param constituency
	 *            the constituency to set
	 */
	public final void setConstituency (final String constituency) {
		this.constituency = constituency;
	}

	/**
	 * @param electoralOfficerID
	 *            the electoralOfficerID to set
	 */
	public final void setElectoralOfficerID (final String electoralOfficerID) {
		this.electoralOfficerID = electoralOfficerID;
	}
}
