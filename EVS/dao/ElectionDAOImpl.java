/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : ElectionDAOImpl.java
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

import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.DBUtilImpl;
import com.wipro.evs.util.LogFile;
/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public class ElectionDAOImpl implements ElectionDAO {
	private static final int one = 1;
	private static final int two = 2;
	private static final int three = 3;
	private static final int four = 4;
	private static final int five = 5;
	private static final int six = 6;
	private Connection conn;
	

	private String result = "FAIL";
	public ElectionDAOImpl() {
		try {
			conn = new DBUtilImpl().getDBConnection("Type 4");
		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "SQL exception");
		}
	}
	/**
	 * 
	 * @param createElections c
	 * @return Return Type: String
	 * 
	 * 
	 */
	public String createElection(ElectionBean createElections)
	{
		return null;
	}
	public String createElections(ElectionBean createElections){
		ResultSet rst=null;
		int count=0;
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement("select * FROM EVS_TBL_Election");
			rst = ps.executeQuery();
			if (rst.next()){
			
				
				if(createElections.getConstituency().equals(rst.getString("Constituency")))
				{
				int a=	createElections.getElectionDate().compareTo(rst.getDate("ElectionDate"));
				if(a==0)
				{
					count++;
				}
				}
			ps.close();
			
			if(count==0)
			{
			ps = conn.prepareStatement("select EVS_SEQ_ELECTIONID.nextval from dual");
		rst = ps.executeQuery();
		if (rst.next()){
			createElections.setElectionID(rst.getString(one));}
		ps.close();
		createElections.setElectionID((createElections.getName().substring(0, two)
				.toLowerCase()) + (createElections.getElectionID()));
		
		java.sql.Date electionDateSqlDate = new java.sql.Date(createElections
				.getElectionDate().getTime());
		java.sql.Date countingDateSqlDate = new java.sql.Date(createElections
				.getCountingDate().getTime());
		ps = conn
				.prepareStatement("insert into EVS_TBL_Election values(?,?,?,?,?,?)");
		ps.setString(one, createElections.getElectionID());
		ps.setString(two, createElections.getName());
		ps.setDate(three, electionDateSqlDate);
		ps.setString(four, createElections.getDistrict());
		ps.setString(five, createElections.getConstituency());
		ps.setDate(six, countingDateSqlDate);
		if (ps.executeUpdate()==1){
			result = "SUCCESS";}
		else{
			result="FAIL";}
			}
			else
			{
				result="ERROR";
			}
		}} catch (SQLException exception) {
			result="ERROR";
			LogFile.logging(exception, "SQL exception");
		}
		catch (Exception exception) {
			LogFile.logging(exception, "SQL exception");
			result="ERROR";
		}
		
		return result;
	}
	/**
	 * 
	 * @param electionID e
	 * @return r
	 * Return Type: int
	 *
	 */
	public int getRowCountOfVote(String electionID){
		int rowcount=0;
		ResultSet rst=null;
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select count(electionid) from EVS_TBL_VOTER_DETAILS where electionid=?");
		
		ps.setString(one, electionID);
		rst=ps.executeQuery();
		if(rst.next()){
			rowcount=rst.getInt(one);}
		} catch (SQLException exception) {
			LogFile.logging(exception, "SQL exception");
		}
		return rowcount;
		
	}
	/**
	 *  
	 * @return r
	 * @throws SQLException s
	 * Return Type: ArrayList<ElectionBean>
	 *
	 */
	public ArrayList<ElectionBean> findAllUpcomingElections() throws SQLException {
		ElectionBean electionBean = null;
		ResultSet rst=null;
		PreparedStatement ps=null;
		
		ArrayList<ElectionBean> arrayList = new ArrayList<ElectionBean>();
		ps = conn.prepareStatement("select * from EVS_TBL_ELECTION where electiondate > sysdate-1");
		rst = ps.executeQuery();
		while (rst.next()) {
			electionBean = new ElectionBean();
			electionBean.setElectionID(rst.getString(one));
			electionBean.setName(rst.getString(two));
			electionBean.setElectionDate(new java.util.Date(rst.getDate(three)
					.getTime()));
			electionBean.setDistrict(rst.getString(four));
			electionBean.setConstituency(rst.getString(five));
			electionBean.setCountingDate(new java.util.Date(rst.getDate(six)
					.getTime()));
			
			arrayList.add(electionBean);

		}
		return arrayList;
	}

	
	public int deleteElection(ArrayList<String> id) {
		// TODO Auto-generated method stub
		return 0;
	}



	public ElectionBean findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateElection(ElectionBean election) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 
	 * @return Return Type: ArrayList<ElectionBean>
	 * @throws SQLException s
	 * 
	 */
	public ArrayList<ElectionBean> findAll()  {
		ElectionBean electionBean = null;
		ResultSet rst=null;
		PreparedStatement ps=null;
		
		ArrayList<ElectionBean> arrayList = new ArrayList<ElectionBean>();
		try{
		ps = conn.prepareStatement("select * from EVS_TBL_ELECTION");
		rst = ps.executeQuery();
		while (rst.next()) {
			electionBean = new ElectionBean();
			electionBean.setElectionID(rst.getString(one));
			electionBean.setName(rst.getString(two));
			electionBean.setElectionDate(new java.util.Date(rst.getDate(three)
					.getTime()));
			electionBean.setDistrict(rst.getString(four));
			electionBean.setConstituency(rst.getString(five));
			electionBean.setCountingDate(new java.util.Date(rst.getDate(six)
					.getTime()));
			arrayList.add(electionBean);
		}
		}
		catch(Exception exception)
		{
			LogFile.logging(exception, "SQL exception");
		}
		return arrayList;
	}

}
