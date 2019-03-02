/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : ElectrolOfficerDAOImpl.java
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.EOBean;
import com.wipro.evs.util.DBUtilImpl;
import com.wipro.evs.util.LogFile;


/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public class ElectoralOfficerDAOImpl implements ElectoralOfficerDAO {

	private static final int five = 5;
	private static final int four = 4;
	private static final int one = 1;
	private static final int three = 3;
	private static final int two = 2;
	
	private Connection conn;
	private boolean flag;
	
	private String result = "FAIL";
	/**
	 * Constructor
	 */
	public ElectoralOfficerDAOImpl () {
		try {
			conn = new DBUtilImpl().getDBConnection("Type 4");
		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "SQL exception");
		}
	}
	/**
	 * 
	 * @param eOBean
	 *            eo
	 * @return Return Type: String
	 * 
	 */
	public String createEO (final EOBean eOBean) {
		return "SUCCESS";
	}
	/**
	 * 
	 * @param deleteEO
	 *            de
	 * @return Return Type: int
	 * 
	 */
	public int deleteEO (final ArrayList<String> deleteEO) {
		return 0;
	}
	/**
	 * 
	 * @return Return Type: ArrayList<EOBean>
	 * 
	 */
	public ArrayList<ApplicationBean> findAll () {
		ApplicationBean applicationBean = null;
		ResultSet rst = null;
		PreparedStatement ps = null;
		ArrayList<ApplicationBean> arraylist = new ArrayList<ApplicationBean>();
		try {
			ps = conn
					.prepareStatement("select * from EVS_TBL_Application where passedstatus=?");
			ps.setInt(one, two);
			rst = ps.executeQuery();
			while (rst.next()) {
				applicationBean = new ApplicationBean();
				applicationBean.setUserID(rst.getString(one));
				applicationBean.setConstituency(rst.getString(two));
				applicationBean.setPassedStatus(rst.getInt(three));
				applicationBean.setApprovedStatus(rst.getInt(four));
				applicationBean.setVoterID(rst.getString(five));
				arraylist.add(applicationBean);
			}
		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "SQL exception");
		}
		return arraylist;
	}
	/**
	 * 
	 * @param id
	 *            id
	 * @return Return Type: EOBean
	 * 
	 */
	public EOBean findByID (final String id) {
		return new EOBean();
	}
	/**
	 * 
	 * @param id
	 *            i
	 * @return r Return Type: String
	 * 
	 */
	public String findConstituency (final String id) {
		ResultSet rst = null;
		PreparedStatement ps = null;
		try {
			ps = conn
					.prepareStatement("select constituency from EVS_TBL_EO where electoralofficerid=?");
			ps.setString(one, id);
			rst = ps.executeQuery();
			if (rst.next()) {
				result = rst.getString(one);
			}
		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "SQL exception");
		}
		return result;
	}
	/**
	 * 
	 * @param applicationBean
	 *            a
	 * @return r Return Type: boolean
	 * 
	 */
	public boolean updateApprovedStatus (final ApplicationBean applicationBean) {
		PreparedStatement ps = null;
		try {
			ps = conn
					.prepareStatement("update EVS_TBL_Application set approvedstatus=? where userid=?");
			ps.setInt(one, one);
			ps.setString(two, applicationBean.getUserID());
			if (ps.executeUpdate() == one) {
				flag = true;
			}
		} catch (SQLException exception) {
			LogFile.logging(exception, "SQL exception");
		}
		return flag;
	}
	/**
	 * 
	 * @param eOBean
	 *            eo
	 * @return Return Type: boolean
	 * 
	 */
	public boolean updateElectoralOfficer (final EOBean eOBean) {
		return true;
	}
	public boolean updateEO (final EOBean eOBean) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 
	 * @param applicationBean
	 *            a
	 * @return r Return Type: boolean
	 * 
	 */
	public boolean updateRejectVoterID (final ApplicationBean applicationBean) {
		PreparedStatement ps = null;
		try {
			ps = conn
					.prepareStatement("update EVS_TBL_Application set approvedstatus=?,passedstatus=? where userid=?");
			ps.setInt(one, 0);
			ps.setInt(two, three);
			ps.setString(three, applicationBean.getUserID());
			if (ps.executeUpdate() == one) {
				flag = true;
			}
		} catch (SQLException exception) {
			LogFile.logging(exception, "SQL exception");
		}
		return flag;
	}
	/**
	 * 
	 * @param applicationBean
	 *            a
	 * @return r Return Type: boolean
	 * 
	 */
	public boolean updateVoterID (final ApplicationBean applicationBean) {
		ResultSet rst = null;
		PreparedStatement ps = null;
		try {
			ps = conn
					.prepareStatement("select EVS_SEQ_VOTERID.nextval from dual");
			rst = ps.executeQuery();
			if (rst.next()) {
				applicationBean.setVoterID(rst.getString(one));
			}
			ps.close();
			ps = conn
					.prepareStatement("select city from EVS_TBL_USER_PROFILE where userid=?");
			ps.setString(one, applicationBean.getUserID());
			rst = ps.executeQuery();
			if (rst.next()) {
				applicationBean.setConstituency(rst.getString(one));
			}
			ps.close();
			applicationBean.setVoterID(applicationBean.getUserID()
					.substring(0, two).toLowerCase()
					+ applicationBean.getConstituency().substring(0, two)
							.toLowerCase() + applicationBean.getVoterID());
			ps = conn
					.prepareStatement("update EVS_TBL_Application set voterid=?,passedstatus=? where userid=?");
			ps.setString(one, applicationBean.getVoterID());
			ps.setInt(two, three);
			ps.setString(three, applicationBean.getUserID());
			if (ps.executeUpdate() == one) {
				flag = true;
			}
		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "SQL exception");
		} catch (Exception exception) {
			LogFile.logging(exception, "SQL exception");
			flag = false;
		}
		return flag;
	}
	@Override
	public String createElectoralOfficer(EOBean eo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int deleteElectoralOfficer(ArrayList<String> id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
