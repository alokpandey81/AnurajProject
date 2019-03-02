/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : ApplicationDAO.java
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

import com.wipro.evs.bean.ApplicationBean;

/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public interface ApplicationDAO {

	/**
	 * @param application
	 * @return
	 */
	String createApplication (final String userID);
	String createXYZ (final ApplicationBean application);

	/**
	 * @param id
	 * @return
	 */
	int deleteApplication (final ArrayList<String> id);

	/**
	 * @return
	 */
	ArrayList<ApplicationBean> findAll ();

	/**
	 * @param passedstatus
	 * @return
	 */
	ArrayList<ApplicationBean> findAll (int passedstatus);

	/**
	 * @param id
	 * @return
	 */
	ApplicationBean findByID (final String id);

	/**
	 * @param application
	 * @return
	 */
	boolean updateApplication (final ApplicationBean application);
}
