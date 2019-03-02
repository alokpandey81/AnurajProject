/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : ProfileDAOImpl.java
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

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import com.wipro.evs.bean.ProfileBean;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.DBUtilImpl;
import com.wipro.evs.util.DateConverter;
import com.wipro.evs.util.LogFile;

/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public class ProfileDAOImpl implements ProfileDAO {
	private Connection conn;
	/**
	 * Constructor
	 */
	public ProfileDAOImpl() {
		try {
			conn = new DBUtilImpl().getDBConnection("Type 4");
		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "SQL exception");
		}
	}
	/* (non-Javadoc)
	 * @see com.wipro.evs.dao.ProfileDAO#createProfile(com.wipro.evs.bean.ProfileBean)
	 */
	public String createProfile(ProfileBean profile) {
		// TODO Auto-generated method stub
		int index=1;
		int counter=0;
		String result="";
		try
		{
			
		
		String query="insert into EVS_TBL_USER_PROFILE values(?,?,?,?,?,?,?,?,?,?,?,?)";
		DateConverter dateconverter = new DateConverter();
		
		Date dateOfBirth =  dateconverter.convertToSql(profile.getDateOfBirth());
		
		PreparedStatement prepare=conn.prepareStatement(query);
		prepare.setString(index, profile.getUserID());
		
		prepare.setString(++index, profile.getFirstName());
		prepare.setString(++index, profile.getLastName());
		prepare.setDate(++index, dateOfBirth);
		prepare.setString(++index, profile.getGender());
		prepare.setString(++index, profile.getStreet());
		prepare.setString(++index, profile.getLocation());
		prepare.setString(++index, profile.getCity());
		prepare.setString(++index, profile.getState());
		prepare.setString(++index, profile.getPincode());
		prepare.setString(++index, profile.getMobileNo());
		
		prepare.setString(++index, profile.getEmailID());
		counter = prepare.executeUpdate();
		
		if(counter > 0){
			return "SUCCESS";
		}
		else{
			return "FAILURE";
		}
		}
		catch(Exception exception)
		{
			LogFile.logging(exception, "SQL exception");
		}
		return "FAILURE";
		
	}

	/* (non-Javadoc)
	 * @see com.wipro.evs.dao.ProfileDAO#deleteApplication(java.util.ArrayList)
	 */
	public int deleteApplication(ArrayList<String> id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.wipro.evs.dao.ProfileDAO#findAll()
	 */
	public ArrayList<ProfileBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wipro.evs.dao.ProfileDAO#findByID(java.lang.String)
	 */
	public ProfileBean findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wipro.evs.dao.ProfileDAO#updateProfile(com.wipro.evs.bean.ProfileBean)
	 */
	public boolean updateProfile(ProfileBean profile) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.wipro.evs.dao.ProfileDAO#createUID(java.lang.String)
	 */
	public String createUID(String fname) {
		// TODO Auto-generated method stub
		return null;
	}

}
