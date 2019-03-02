/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : Administrator.java
 *
 * Description     :Electronic Voting System.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :28-MAR-2014
 * 
 * Modification History:Modified by Jeeshan & Mayank, on date 02-APR-2014.
 **/
package com.wipro.evs.service;

import java.util.ArrayList;
import java.util.Map;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.PartyBean;

/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public interface Administrator {

	String addCandidate(final CandidateBean candidateBean);

	String addElection(final ElectionBean electionBean);

	String addParty(final PartyBean partyBean);

	Map approveElectionResults(final String electionId);

	boolean forwardVoterIDRequest(final String userId);

	ArrayList<ApplicationBean> viewAllAdminPendingApplications();

	ArrayList<PartyBean> viewAllParty();

	ArrayList<ElectionBean> viewAllUpcomingElections();

	ArrayList<CandidateBean> viewCandidateDetailsByElectionName(
			final String electionName);

	ArrayList<CandidateBean> viewCandidateDetailsByParty(final String partyId);

	ArrayList<ElectionBean> viewElections();
}
