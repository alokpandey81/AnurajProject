/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : AdministratorDAO.java
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

import com.wipro.evs.bean.ProfileBean;

/**
 * @author Jeeshan & Mayank MAR 28, 2014
 * @version 1.0.0.
 */
public interface AdministratorDAO {

	String createAdministrator(final ProfileBean profile);

	int deleteApplication(final ArrayList<String> id);

	ArrayList<ProfileBean> findAll();

	ProfileBean findByID(final String id);

	boolean updateAdministrator(final ProfileBean profile);
}
