/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : ApplicationDAOImpl.java
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
import com.wipro.evs.util.DBUtilImpl;
import com.wipro.evs.util.LogFile;


/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public class ApplicationDAOImpl implements ApplicationDAO {


private static final int one = 1;
private static final int two = 2;
private static final int three = 3;
private static final int four = 4;
private static final int five = 5;
private Connection conn;

private String result = "FAIL";

/**
 * Constructor
 */
public ApplicationDAOImpl() {
	try {
		conn = new DBUtilImpl().getDBConnection("Type 4");
	} catch (SQLException exception) {
		// TODO Auto-generated catch block
		LogFile.logging(exception, "SQL exception");
	}
}

/**
 * 
 * @param userID
 *            id
 * @return Return Type: String
 * 
 */
public String createApplication(String userID) {
	ApplicationBean applicationBean = new ApplicationBean();
	applicationBean.setUserID(userID);
	PreparedStatement ps = null;
	ResultSet rst = null;
	int ONE=1;
	
	try {
		ps = conn
				.prepareStatement("select approvedstatus,passedstatus from EVS_TBL_Application where userid=?");
		ps.setString(one, applicationBean.getUserID());
		rst = ps.executeQuery();

		if (rst.next()) {
			if (rst.getInt(ONE) == 0 && rst.getInt(two) == three) {
				result = "REJECTED";
			} else if (rst.getInt(ONE) == 1 && rst.getInt(two) == three) {
				result = "APPROVED";
			} else {
				result = "APPLIED";
			}
		} else {

			try {
				ps.close();
				try {
					ps = conn
							.prepareStatement("select EVS_SEQ_REQUESTID.nextval from dual");

					rst = ps.executeQuery();
					if (rst.next()) {
						applicationBean.setVoterID(rst.getString(ONE));
					}
					ps.close();
					ps = conn
							.prepareStatement("select city from EVS_TBL_USER_PROFILE where userid=?");
					ps.setString(ONE, applicationBean.getUserID());
					rst = ps.executeQuery();
					if (rst.next()) {
						applicationBean.setConstituency(rst.getString(ONE));
					}
					ps.close();

				} catch (SQLException exception) {
					// TODO Auto-generated catch block
					LogFile.logging(exception, "SQL exception");
				}
				applicationBean.setVoterID((applicationBean.getUserID()
						.substring(0, two).toLowerCase())
						+ (applicationBean.getVoterID()));
				ps = conn
						.prepareStatement("insert into EVS_TBL_Application values(?,?,?,?,?)");

				ps.setString(ONE, applicationBean.getUserID());
				ps.setString(two, applicationBean.getConstituency());
				ps.setInt(three, 1);
				ps.setInt(four, 0);
				ps.setString(five, applicationBean.getVoterID());
				if (ps.executeUpdate() == ONE) {
					result = "SUCCESS";
				}
			} catch (SQLException exception) {
				LogFile.logging(exception, "SQL exception");
				
			}
			catch(Exception exception)
			{	LogFile.logging(exception, "exception");
				result="FAIL";
			}
		}
	} catch (SQLException exception) {
		LogFile.logging(exception, "SQL exception");
	}
	return result;
}


	public int deleteApplication(ArrayList<String> id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	/**
	 * 
	 * @return Return Type: ArrayList<ApplicationBean>
	 * 
	 */
	public ArrayList<ApplicationBean> findAll() {
		PreparedStatement ps = null;
		ResultSet rst = null;
		//Connection conn=DBUtil.getDBConnection("type4");
		ApplicationBean applicationBean = new ApplicationBean();
		ArrayList<ApplicationBean> arrayList = new ArrayList<ApplicationBean>();
		try {
			ps = conn
					.prepareStatement("select userid,constituency,passedstatus,voterid from EVS_TBL_Application where passedstatus=1");

			rst = ps.executeQuery();
			while (rst.next()) {

				applicationBean = new ApplicationBean();
				applicationBean.setUserID(rst.getString(one));
				applicationBean.setConstituency(rst.getString(two));
				applicationBean.setPassedStatus(rst.getInt(three));
				applicationBean.setVoterID(rst.getString(four));
				arrayList.add(applicationBean);
			}
		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "SQL exception");
		}
		return arrayList;

	}
	public ApplicationBean findByID(String id) {
		PreparedStatement ps = null;
		ResultSet rst = null;
		ApplicationBean applicationBean = new ApplicationBean();
		try {
			ps = conn
					.prepareStatement("select passedstatus,approvedstatus,voterid from EVS_TBL_Application where userid=?");

			ps.setString(one, id);
			rst = ps.executeQuery();
			if (rst.next()) {
				applicationBean.setPassedStatus(rst.getInt(one));
				applicationBean.setApprovedStatus(rst.getInt(two));
				applicationBean.setVoterID(rst.getString(three));
			}
		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "SQL exception");
		}
		return applicationBean;
	}
	/**
	 * 
	 * @param applicationBean
	 *            object
	 * @return Return Type: boolean
	 * 
	 */
	public boolean updateApplication(ApplicationBean applicationBean) {
		boolean flag = false;
		PreparedStatement ps = null;

		try {
			ps = conn
					.prepareStatement("update EVS_TBL_Application set passedstatus=2 where userid=?");
			ps.setString(one, applicationBean.getUserID());
			if (ps.executeUpdate() == one) {
				flag = true;
			}

		} catch (SQLException exception) {
			LogFile.logging(exception, "SQL exception");
		}

		return flag;
	}

	@Override
	public String createXYZ(ApplicationBean application) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ApplicationBean> findAll(int passedstatus) {
		// TODO Auto-generated method stub
		return null;
	}

}
