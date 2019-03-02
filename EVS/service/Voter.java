/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : Voter.java
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

import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.ResultBean;

/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public interface Voter {

	String castVote(final String userId, final String electionId,
			final String candiadteId);

	String requestVoterId(final String userId);

	ArrayList<CandidateBean> viewCandidatesByElectionName(
			final String electionName, final String constituency);

	String viewGeneratedVoterId(final String userId, final String constituency);

	ArrayList<ElectionBean> viewListOfElections();

	ArrayList<ResultBean> viewListOfElectionsResults();
}
