/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : AdministratorDAOImpl.java
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
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public class AdminstratorDAOImpl implements AdministratorDAO {

	/* (non-Javadoc)
	 * @see com.wipro.evs.dao.AdministratorDAO#createAdministrator(com.wipro.evs.bean.ProfileBean)
	 */
	public String createAdministrator(ProfileBean profile) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wipro.evs.dao.AdministratorDAO#deleteApplication(java.util.ArrayList)
	 */
	public int deleteApplication(ArrayList<String> id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.wipro.evs.dao.AdministratorDAO#findAll()
	 */
	public ArrayList<ProfileBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wipro.evs.dao.AdministratorDAO#findByID(java.lang.String)
	 */
	public ProfileBean findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wipro.evs.dao.AdministratorDAO#updateAdministrator(com.wipro.evs.bean.ProfileBean)
	 */
	public boolean updateAdministrator(ProfileBean profile) {
		// TODO Auto-generated method stub
		return false;
	}

}
