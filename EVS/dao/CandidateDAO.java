/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : CandidateDAO.java
 *
 * Description     :Electronic Voting System.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :28-MAR-2014
 * 
 * Modification History:Modified by Jeeshan & Mayank, on date 02-APR-2014.
 **/
package com.wipro.evs.dao;

import java.util.ArrayList;

import com.wipro.evs.bean.CandidateBean;

/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public interface CandidateDAO {

	String createCandidate(final CandidateBean candidate);

	int deleteCandidate(final ArrayList<String> id);

	ArrayList<CandidateBean> findAll();

	ArrayList<CandidateBean> findByID(final String id);

	boolean updateCandidate(final CandidateBean candidate);
}
