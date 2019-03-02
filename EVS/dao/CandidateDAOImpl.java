/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : CandidateDAOImpl.java
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

import java.sql.*;
import java.util.ArrayList;

import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.DBUtilImpl;
import com.wipro.evs.util.LogFile;
/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public class CandidateDAOImpl implements CandidateDAO {
	private static final int one = 1;
	private static final int two = 2;
	private static final int three = 3;
	private static final int four = 4;
	private static final int five = 5;
	private static final int six = 6;
	private static final int seven = 7;
	private static final int eight = 8;
	private static final int nine = 9;
	private static final int ten = 10;
	private static final int eleven = 11;
	private static final int twelve = 12;
	private Connection conn;
	private String result = "FAIL";
	private ResultSet rst2;
	private PreparedStatement ps2;

	public CandidateDAOImpl() {
		try {
			conn = new DBUtilImpl().getDBConnection("Type 4");
		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "SQL exception");
		}
	}

	
	/**
	 * 
	 * @param candidateBean
	 *            c
	 * @return Return Type: String
	 * 
	 */
	public String createCandidate(CandidateBean candidateBean) {
		ResultSet rst = null;
		PreparedStatement ps = null;
		int count=0;
		
		try {
			ps = conn
					.prepareStatement("select * from EVS_TBL_Candidate");
			rst = ps.executeQuery();
			if (rst.next()) {
			if(rst.getString("partyid").equals(candidateBean.getPartyID())&&rst.getString("constituency").equals(candidateBean.getConstituency()));
			{
				count++;
			}
			
			}
			if(count==0)
			{
			ps = conn
					.prepareStatement("select EVS_SEQ_CANDIDATEID.nextval from dual");
			rst = ps.executeQuery();
			if (rst.next()) {
				candidateBean.setCandidateID(rst.getString(one));
			}
			ps.close();
			candidateBean.setCandidateID((candidateBean.getName().substring(0,
					two).toLowerCase())
					+ (candidateBean.getCandidateID()));

			java.sql.Date date = new Date(candidateBean.getDateOfBirth()
					.getTime());

			ps = conn
					.prepareStatement("insert into EVS_TBL_Candidate values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(one, candidateBean.getCandidateID());
			ps.setString(two, candidateBean.getName());
			ps.setString(three, candidateBean.getElectionID());
			ps.setString(four, candidateBean.getPartyID());
			ps.setString(five, candidateBean.getDistrict());
			ps.setString(six, candidateBean.getConstituency());
			ps.setDate(seven, date);
			ps.setString(eight, candidateBean.getMobileNo());
			ps.setString(nine, candidateBean.getAddress());
			ps.setString(ten, candidateBean.getEmailID());

			int col = ps.executeUpdate();
			if (col > 0) {
				result = "SUCCESS";
			} else {
				result = "FAIL";
			}
			}
			else
			{
				result = "FAIL";
			}
		} catch (SQLException exception) {
			result = "ERROR";
			LogFile.logging(exception, "SQL exception");
		} catch (Exception exception) {
			LogFile.logging(exception, "exception");
			result = "ERROR";
		}
		return result;
	}
	/**
	 * 
	 * @param id
	 *            id
	 * @return r Return Type: ArrayList<CandidateBean>
	 * 
	 */
	public ArrayList<CandidateBean> findByElectionName(String id) {
		CandidateBean candidateBean = null;
		ResultSet rst = null;
		PreparedStatement ps = null;
		ArrayList<CandidateBean> arraylist = new ArrayList<CandidateBean>();
		try {
			ps = conn
					.prepareStatement("select electionID from EVS_TBL_ELECTION where name=?");

			ps.setString(one, id);
			
			rst = ps.executeQuery();

			if (rst.next()) {
				id = rst.getString(one);
			}
			ps.close();
			ps = conn
					.prepareStatement("select * from EVS_TBL_CANDIDATE where electionid=?");
			ps.setString(one, id);
			rst = ps.executeQuery();
			while (rst.next()) {
				candidateBean = new CandidateBean();
				candidateBean.setCandidateID(rst.getString(one));
				candidateBean.setName(rst.getString(two));
				candidateBean.setElectionID(rst.getString(three));
				ps2 = conn
						.prepareStatement("select name,symbol from EVS_TBL_PARTY where partyid=?");
				ps2.setString(one, rst.getString(four));
				rst2 = ps2.executeQuery();
				if (rst2.next()) {
					candidateBean.setPartyID(rst2.getString(one));
					candidateBean.setAddress(rst2.getString(two));
				}
				candidateBean.setDistrict(rst.getString(five));
				candidateBean.setConstituency(rst.getString(six));
				candidateBean.setDateOfBirth(new java.util.Date(rst.getDate(
						seven).getTime()));
				candidateBean.setMobileNo(rst.getString(eight));

				candidateBean.setEmailID(rst.getString(ten));
				arraylist.add(candidateBean);
			}
			ps.close();

		} catch (SQLException exception) {
			LogFile.logging(exception, "SQL exception");
		}

		return arraylist;
	}
	/**
	 * 
	 * @param id
	 *            id
	 * @return r Return Type: ArrayList<CandidateBean>
	 * 
	 */
	public ArrayList<CandidateBean> findCandidatesCastVote(String id) {
		CandidateBean candidateBean = null;
		ResultSet rst = null;
		PreparedStatement ps = null;
		ArrayList<CandidateBean> arraylist = new ArrayList<CandidateBean>();
		try {
			ps = conn
					.prepareStatement("select candidateid,name,electionid,partyid from EVS_TBL_CANDIDATE where electionid=?");
			ps.setString(one, id);
			rst = ps.executeQuery();
			while (rst.next()) {
				candidateBean = new CandidateBean();
				candidateBean.setCandidateID(rst.getString(one));
				candidateBean.setName(rst.getString(two));
				candidateBean.setElectionID(rst.getString(three));
				candidateBean.setPartyID(rst.getString(four));
				ps2 = conn
						.prepareStatement("select name,symbol from EVS_TBL_PARTY where partyid=?");
				ps2.setString(one, candidateBean.getPartyID());
				rst2 = ps2.executeQuery();
				if (rst2.next()) {
					candidateBean.setAddress(rst2.getString(one));
					candidateBean.setEmailID(rst2.getString(two));
				}

				arraylist.add(candidateBean);
			}
		} catch (SQLException exception) {
			LogFile.logging(exception, "SQL exception");
		}

		return arraylist;

	}
	/**
	 * 
	 * @param id
	 *            id
	 * @return r Return Type: ArrayList<CandidateBean>
	 * 
	 */
	public ArrayList<CandidateBean> findByPartyID(String id) {
		CandidateBean candidateBean = null;
		ResultSet rst = null;
		PreparedStatement ps = null;
		ArrayList<CandidateBean> arraylist = new ArrayList<CandidateBean>();
		try {
			ps = conn
					.prepareStatement("select * from EVS_TBL_CANDIDATE where partyid=?");
			ps.setString(one, id);
			rst = ps.executeQuery();
			while (rst.next()) {
				candidateBean = new CandidateBean();
				candidateBean.setCandidateID(rst.getString(one));
				candidateBean.setName(rst.getString(two));
				candidateBean.setElectionID(rst.getString(three));
				candidateBean.setPartyID(rst.getString(four));
				candidateBean.setDistrict(rst.getString(five));
				candidateBean.setConstituency(rst.getString(six));
				candidateBean.setDateOfBirth(new java.util.Date(rst.getDate(
						seven).getTime()));
				candidateBean.setMobileNo(rst.getString(eight));
				candidateBean.setAddress(rst.getString(nine));
				candidateBean.setEmailID(rst.getString(ten));
				arraylist.add(candidateBean);

			}
		} catch (SQLException exception) {
			LogFile.logging(exception, "SQL exception");
		}

		return arraylist;
	}


	public int deleteCandidate(ArrayList<String> id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<CandidateBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CandidateBean> findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateCandidate(CandidateBean candidate) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 
	 * @param id
	 *            i
	 * @param constituency
	 *            c
	 * @return r
	 * @throws SQLException
	 *             s Return Type: ArrayList<CandidateBean>
	 * 
	 */
	public ArrayList<CandidateBean> findByElectionIDConstituency(String id/*,String constituency*/) throws SQLException {
		ArrayList<CandidateBean> arrayList = new ArrayList<CandidateBean>();
		CandidateBean candidateBean = new CandidateBean();

		PreparedStatement ps = conn.prepareStatement("select * from EVS_TBL_CANDIDATE where ELECTIONID=?");
//System.out.println( id+"id"+constituency+"constituency");
		ps.setString(one, id);
		//ps.setString(two, constituency);
		ResultSet rst = ps.executeQuery();

		while (rst.next()) {
			
			candidateBean.setCandidateID(rst.getString(one));
			candidateBean.setName(rst.getString(two));
			candidateBean.setElectionID(rst.getString(three));
			ps2 = conn.prepareStatement("select name,symbol from EVS_TBL_PARTY where partyid=?");
			ps2.setString(one, rst.getString(four));
			rst2 = ps2.executeQuery();
			if (rst2.next()) {
				candidateBean.setPartyID(rst2.getString(one));
				candidateBean.setAddress(rst2.getString(two));
			}
			System.out.println("hiiiiiiii");
			candidateBean.setDistrict(rst.getString(five));
			candidateBean.setConstituency(rst.getString(six));
			candidateBean.setDateOfBirth(new java.util.Date(rst.getDate(seven)
					.getTime()));
			candidateBean.setMobileNo(rst.getString(eight));

			candidateBean.setEmailID(rst.getString(ten));
			System.out.println(candidateBean+"candidateBean");
			arrayList.add(candidateBean);

			
		}

		return arrayList;
	}

}
