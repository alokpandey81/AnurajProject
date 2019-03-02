/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : CredentialDAOImpl.java
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

import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.util.DBUtilImpl;
import com.wipro.evs.util.LogFile;

/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public class CredentialDAOImpl implements CredentialsDAO {
	private Connection connection;

	
	public CredentialDAOImpl() {
		try {
			connection = new DBUtilImpl().getDBConnection("Type 4");
		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "SQL exception");
		}
	}

	/* (non-Javadoc)
	 * @see com.wipro.evs.dao.CredentialsDAO#createCredentials(com.wipro.evs.bean.CredentialsBean)
	 */
	public String createCredentials(CredentialsBean credentials) {
		String query="null"; String result="null";
		
		int index=0;
		try
		{String userID=credentials.getUserID();
		String password=credentials.getPassword();
		String usertype=credentials.getUserType();
		int Loginstatus=credentials.getLoginStatus();
			query="insert into EVS_TBL_USER_CREDENTIALS values (?,?,?,?)";
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(++index,userID);
			statement.setString(++index,password);
			statement.setString(++index,usertype);
			statement.setInt(++index,Loginstatus);
			
		int counter= statement.executeUpdate();
		
			if(counter>0)
			{
				result="SUCCESS";
			}
			else
			{
				result="FAILURE";
			}
		}
		catch(SQLException exception)
		{
			LogFile.logging(exception, "SQL exception");	
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.wipro.evs.dao.CredentialsDAO#deleteCredentials(java.util.ArrayList)
	 */
	public int deleteCredentials(ArrayList<String> id) {
		// TODO Auto-generated method stubEVS_TBL_USER_CREDENTIALS
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.wipro.evs.dao.CredentialsDAO#findAll()
	 */
	public ArrayList<CredentialsBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wipro.evs.dao.CredentialsDAO#findByID(java.lang.String)
	 */
	public CredentialsBean findByID(String id) {
		CredentialsBean cb=new CredentialsBean();
		// TODO Auto-generated method stub
				String query="null"; String result="null";
				
				int index=0;
				try
				{
					
					query="select * from EVS_TBL_USER_CREDENTIALS where USERID=?";
					PreparedStatement statement=connection.prepareStatement(query);
					statement.setString(++index, id);
					ResultSet resultset= statement.executeQuery();
				    index=0;
					if(resultset.next())
					{
						cb.setUserID(resultset.getString(++index));
						cb.setPassword(resultset.getString(++index));
						cb.setUserType(resultset.getString(++index));
						cb.setLoginStatus(resultset.getInt(++index));
						
						
					
					}
				}
				catch(SQLException exception)
				{
					LogFile.logging(exception, "SQL exception");
				}
				return cb;
	}
	public String findID() {
		// TODO Auto-generated method stub
		String query="null"; String result="null";
		int index=0;
		
		try
		{
			query="select evs_seq_userid.nextval from dual";
			Statement statement=connection.createStatement();
			ResultSet resultset= statement.executeQuery(query);
			if(resultset.next())
			{
				result=resultset.getString(++index);
			}
		}
		catch(SQLException exception)
		{
			LogFile.logging(exception, "SQL exception");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.wipro.evs.dao.CredentialsDAO#updateCredentials(com.wipro.evs.bean.CredentialsBean)
	 */
	public boolean updateCredentials(CredentialsBean credentials,String id)
	{String query="null"; int result=0;
	boolean update=false;
	int index=0;
	
	
	try
	{
		query="Update EVS_TBL_USER_CREDENTIALS set PASSWORD=? where USERID=? ";
		PreparedStatement statement=connection.prepareStatement(query);
		statement.setString(++index,credentials.getPassword());
		statement.setString(++index, id);
		
		result= statement.executeUpdate();
		if(result>0)
		{
			update=true;
		}
		else
		{
			update=false;
		}
	}
	catch(SQLException exception)
	{
		update=false;
		LogFile.logging(exception, "SQL exception");
		
	}
	
		return update;
	}
	public boolean updateCredentials(CredentialsBean credentials) {
		String query="null"; int result=0;
		boolean update=false;
		int index=0;
		 
		try
		{
			query="Update EVS_TBL_USER_CREDENTIALS set LOGINSTATUS=? where USERID=? ";
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setInt(++index,credentials.getLoginStatus());
			statement.setString(++index, credentials.getUserID());
			
			result= statement.executeUpdate();
			if(result>0)
			{
				update=true;
			}
			else
			{
				update=false;
			}
		}
		catch(SQLException exception)
		{
			update=false;
			LogFile.logging(exception, "SQL exception");
		}
		return update;
	}

}
