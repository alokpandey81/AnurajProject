/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : PartyBean.java
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
public class PartyBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5245889048362437698L;
	private String partyID;
	private String name;
	private String leader;
	private String symbol;

	/**
	 * @return the leader
	 */
	public final String getLeader () {
		return leader;
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
	 * @return the symbol
	 */
	public final String getSymbol () {
		return symbol;
	}

	/**
	 * @param leader
	 *            the leader to set
	 */
	public final void setLeader (final String leader) {
		this.leader = leader;
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

	/**
	 * @param symbol
	 *            the symbol to set
	 */
	public final void setSymbol (final String symbol) {
		this.symbol = symbol;
	}
}
