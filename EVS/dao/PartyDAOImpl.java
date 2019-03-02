/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : PartyDAOImpl.java
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

import com.wipro.evs.bean.PartyBean;
import com.wipro.evs.util.DBUtil;
import com.wipro.evs.util.DBUtilImpl;
import com.wipro.evs.util.LogFile;
/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public class PartyDAOImpl implements PartyDAO {
	private static final int one = 1;
	private static final int two = 2;
	private static final int three = 3;
	private static final int four = 4;
	private static final int five = 5;
	private static final int six = 6;
	private Connection conn;
	private PartyBean partyBean;

	private String result = "FAIL";
	public PartyDAOImpl() {
		try {
			conn = new DBUtilImpl().getDBConnection("Type 4");
		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "SQL exception");
		}
	}
	/**
	 * @param partyBeanPara
	 *            p
	 * @return String
	 */
	public String createParty(PartyBean partyBeanPara) {
		ResultSet rst = null;
		PreparedStatement ps = null;
		int count=0;
		try {
			ps = conn
					.prepareStatement("select * from EVS_TBL_Party where name=?");
			ps.setString(1, partyBeanPara.getName());
			rst = ps.executeQuery();
			if (rst.next()) {
				
		if(rst.getString("name").equalsIgnoreCase(partyBeanPara.getName()))
			{
				count++;
			}
			}
			ps.close();
			System.out.println("count++"+count);
			if(count==0)
			{
			ps = conn
					.prepareStatement("select EVS_SEQ_PARTYID.nextval from dual");

			rst = ps.executeQuery();
			if (rst.next()) {
				partyBeanPara.setPartyID(rst.getString(one));
			}
			ps.close();
			partyBeanPara.setPartyID((partyBeanPara.getName().substring(0, two)
					.toLowerCase()) + (partyBeanPara.getPartyID()));

			ps = conn
					.prepareStatement("insert into EVS_TBL_Party values(?,?,?,?)");
			ps.setString(one, partyBeanPara.getPartyID());
			ps.setString(two, partyBeanPara.getName());
			ps.setString(three, partyBeanPara.getLeader());
			ps.setString(four,  partyBeanPara.getSymbol());
			if (ps.executeUpdate() == one) {
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
		}
		catch (Exception exception) {
			LogFile.logging(exception, "SQL exception");
			result="ERROR";
		}
		return result;
	}
	public int deleteParty(ArrayList<String> id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 * @return Return Type: ArrayList<PartyBean>
	 * @throws SQLException
	 * 
	 */
	public ArrayList<PartyBean> findAll() {
		ResultSet rst = null;
		PreparedStatement ps = null;
		
		ArrayList<PartyBean> arrayList = new ArrayList<PartyBean>();
		try {
			ps = conn.prepareStatement("select * from EVS_TBL_Party");

			rst = ps.executeQuery();
			while (rst.next()) {

				partyBean = new PartyBean();
				partyBean.setPartyID(rst.getString(one));
				partyBean.setName(rst.getString(two));
				partyBean.setLeader(rst.getString(three));
				partyBean.setSymbol(rst.getString(four));
				arrayList.add(partyBean);
			}
		} catch (SQLException exception) {
			LogFile.logging(exception, "SQL exception");
		}
		return arrayList;
	}

	public PartyBean findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateParty(PartyBean party) {
		// TODO Auto-generated method stub
		return false;
	}

}
