/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : ElectionDAO.java
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

import com.wipro.evs.bean.ElectionBean;

/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public interface ElectionDAO {

	String createElection(final ElectionBean election);

	int deleteElection(final ArrayList<String> id);

	ArrayList<ElectionBean> findAll();

	ElectionBean findByID(final String id);

	boolean updateElection(final ElectionBean election);
}
