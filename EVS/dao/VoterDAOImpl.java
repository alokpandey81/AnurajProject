/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : VoterDAOImpl.java
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
import com.wipro.evs.bean.ResultBean;
import com.wipro.evs.bean.VoterBean;
import com.wipro.evs.util.DBUtilImpl;
import com.wipro.evs.util.LogFile;

/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public class VoterDAOImpl implements VoterDAO {
	private String result = "FAIL";
	private Connection conn;

	private static final int one = 1;
	private static final int two = 2;
	private static final int three = 3;
	private static final int four = 4;

	/**
	 * Constructor
	 */
	public VoterDAOImpl() {
		try {
			conn = new DBUtilImpl().getDBConnection("Type 4");
		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "SQL exception");
		}
	}

	public String createVoter(VoterBean voter) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteVoterDetails(ArrayList<String> deleteVoterDetails) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 * @return Return Type: ArrayList<VoterBean>
	 * 
	 */

	public ArrayList<ResultBean> findAll() {
		ResultSet rst = null;
		PreparedStatement ps = null;
		ArrayList<ResultBean> arrayList = new ArrayList<ResultBean>();
		ResultBean resultBean = null;
		try {
			ps = conn.prepareStatement("select * from EVS_TBL_RESULT");

			rst = ps.executeQuery();

			while (rst.next()) {
				resultBean = new ResultBean();
				resultBean.setElectionID(rst.getString(two));
				resultBean.setCandidateID(rst.getString(three));
				resultBean.setVoteCount(rst.getInt(four));
				arrayList.add(resultBean);

			}

		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "SQL exception");
		}
		return arrayList;
	}

	/**
	 * 
	 * @param id
	 *            id
	 * @return Return Type: ApplicationBean
	 * 
	 */
	public ApplicationBean findByID(String id) {
		ResultSet rst = null;
		PreparedStatement ps = null;

		ApplicationBean applicationBean = new ApplicationBean();
		try {
			ps = conn
					.prepareStatement("select constituency from EVS_TBL_Application where userid=?");

			ps.setString(one, id);
			rst = ps.executeQuery();
			if (rst.next()) {
				applicationBean.setConstituency(rst.getString(one));
			}

		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "SQL exception");
		}
		return applicationBean;

	}

	/**
	 * 
	 * @param userID
	 *            u
	 * @param electionID
	 *            e
	 * @param candidateID
	 *            c
	 * @return String Return Type: String
	 * 
	 */
	public String updateVote(String userID, String electionID,
			String candidateID) {
		ResultSet rst = null;

		PreparedStatement ps = null;

		String voterID = "";
		int serialno = 1;
		try {
			ps = conn
					.prepareStatement("select voterid,approvedstatus from EVS_TBL_APPLICATION where userid=?");

			ps.setString(one, userID);
			int status = 0;
			rst = ps.executeQuery();

			if (rst.next()) {
				if (rst.getInt(two) == 1) {

					voterID = rst.getString(one);
					status = rst.getInt("approvedstatus");
					ps.close();

					ps = conn
							.prepareStatement("select electionID,candidateID from EVS_TBL_VOTER_DETAILS where voterid=?");

					ps.setString(one, voterID);

					rst = ps.executeQuery();
					int COUNT = 0;
					if (rst.next()) {
						if (rst.getString("electionID").equals(electionID)
						/*
						 * && rst.getString("candidateID").equals(candidateID)
						 */) {
							++COUNT;

						}
					}
					ps.close();
					if (COUNT == 0) {
						ps = conn
								.prepareStatement("select MAX(serialno)+1 from EVS_TBL_VOTER_DETAILS");
						rst = ps.executeQuery();
						if (rst.next()) {
							serialno = rst.getInt(one);
						}

						ps = conn
								.prepareStatement("insert into EVS_TBL_VOTER_DETAILS values(?,?,?,?)");
						ps.setInt(one, serialno);
						ps.setString(two, candidateID);
						ps.setString(three, electionID);
						ps.setString(four, voterID);
						if (ps.executeUpdate() == one) {
							result = "SUCCESS";
						}
					} else {
						result = "VOTED";
					}
				} else {
					result = "NOVOTERID";
				}
			}

		} catch (SQLException exception) {
			result = "VOTED";
			LogFile.logging(exception, "SQL exception");
		}

		return result;

	}
}
