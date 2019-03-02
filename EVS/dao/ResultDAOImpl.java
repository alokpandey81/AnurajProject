/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : ResultDAOImpl.java
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

import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ResultBean;
import com.wipro.evs.util.DBUtilImpl;
import com.wipro.evs.util.LogFile;
/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public class ResultDAOImpl implements ResultDAO {
	private static final int one = 1;
	private static final int two = 2;
	private static final int three = 3;
	private static final int four = 4;
	/* private static final int five = 5; */
	/* private static final int six = 6; */
	private String result = "FAIL";
	private Connection conn;

	/**
	 * Construtor
	 */
	public ResultDAOImpl() {
		try {
			conn = new DBUtilImpl().getDBConnection("Type 4");
		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "SQL exception");
		}
	}

	/**
	 * 
	 * @param resultBean
	 *            r
	 * @return r Return Type: ArrayList<ResultBean> a
	 * 
	 */
	public ArrayList<ResultBean> createResult(ResultBean resultBean) {
		
		ResultSet rst = null;
		PreparedStatement ps = null;
		ResultSet rst2 = null;
		PreparedStatement ps2 = null;
		int iterator = 0;
		int serialNo = 0;
		boolean flag = false;
		int ONE = 1;
		int p=0;
		Connection conn1 = conn;
		String electionIDtemp = resultBean.getElectionID();
		ArrayList<CandidateBean> arrayList = new ArrayList<CandidateBean>();
		CandidateBean candidateBean = new CandidateBean();
		ArrayList<ResultBean> arrayList2return = new ArrayList<ResultBean>();
		try {
			ps = conn
					.prepareStatement("select candidateid from EVS_TBL_CANDIDATE where electionid=?");

			ps.setString(one, electionIDtemp);

			rst = ps.executeQuery();
			while (rst.next()) {
				
				candidateBean = new CandidateBean();
				
				candidateBean.setCandidateID(rst.getString(ONE));
				arrayList.add(candidateBean);
			}
			
			ps.close()
			;
			for (iterator = 0; iterator < arrayList.size(); iterator++) {

				ps = conn1
						.prepareStatement("select count(voterid) from EVS_TBL_VOTER_DETAILS where electionid=? and candidateid=?");
				ps.setString(ONE, electionIDtemp);
				ps.setString(two, arrayList.get(iterator).getCandidateID());
				rst = ps.executeQuery();
				if (rst.next()) {
					ps2 = conn1
							.prepareStatement("select EVS_SEQ_SERIALNO1.NEXTVAL from DUAL");
					rst2 = ps2.executeQuery();
					if (rst2.next()) {
						serialNo = rst2.getInt(ONE);
					}

					ps2.close();
				
						
						{
					ps2 = conn1
							.prepareStatement("insert into EVS_TBL_RESULT values(?,?,?,?)");
					ps2.setInt(ONE, serialNo);
					ps2.setString(two, electionIDtemp);
					ps2.setString(three, arrayList.get(iterator)
							.getCandidateID());
					ps2.setInt(four, rst.getInt(ONE));

					if (ps2.executeUpdate() == ONE) {
						
						flag = true;

						result = "SUCCESS";
					}

					ps2.close();
						}
					
				}

			}
		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "SQL exception");
		}
	
		if (flag) {
			try {
				String partyid = "";
				ps = conn1
						.prepareStatement("select * from EVS_TBL_RESULT where electionid=?");

				ps.setString(ONE, electionIDtemp);
				rst = ps.executeQuery();
				while (rst.next()) {
					resultBean = new ResultBean();
					resultBean.setSerialNo(rst.getInt(ONE));
					ps2 = conn1
							.prepareStatement("select partyid,name from EVS_TBL_candidate where candidateid=?");
					ps2.setString(ONE, rst.getString(three));

					rst2 = ps2.executeQuery();
					if (rst2.next()) {
						partyid = rst2.getString(ONE);
						resultBean.setCandidateID(rst2.getString(two));
					}
					ps2.close();
					rst2.close();
					
					ps2 = conn1
							.prepareStatement("select name from EVS_TBL_PARTY where partyid=?");
					ps2.setString(ONE, partyid);
					rst2 = ps2.executeQuery();
					if (rst2.next()) {
						resultBean.setElectionID(rst2.getString(ONE));
					}

					resultBean.setVoteCount(rst.getInt(four));
					arrayList2return.add(resultBean);
				}
			} catch (SQLException exception) {
				// TODO Auto-generated catch block
				LogFile.logging(exception, "SQL exception");
			}
		}
		
		return arrayList2return;
	}

	public int deleteResult(ArrayList<String> id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<ResultBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultBean findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateResult(ResultBean result) {
		// TODO Auto-generated method stub
		return false;
	}

}
