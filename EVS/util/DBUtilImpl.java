/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : DBUtilImpl.java
 *
 * Description     :Electronic Voting System.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :28-MAR-2014
 * 
 * Modification History:Modified by Jeeshan & Mayank, on date 02-APR-2014.
 **/
package com.wipro.evs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public class DBUtilImpl implements DBUtil {
	private Connection conn;

	/**
	 * 
	 * @param driverType
	 *            d
	 * @return conn
	 * @throws SQLException
	 *             Return Type: Connection Function: registering with the
	 *             Database using TYPE 4 JDBC Driver
	 * 
	 */
	public Connection getDBConnection(String driverType) {
		
			
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(	"jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			return conn;
		
	}
}
