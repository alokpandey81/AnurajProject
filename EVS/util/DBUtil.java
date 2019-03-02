/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : DBUtil.java
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
import java.sql.SQLException;

/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public interface DBUtil {
	
	/**
	 * 
	 * @param driverType d
	 * @return
	 * Return Type: Connection
	 * @throws SQLException s
	 *
	 */
Connection getDBConnection(String driverType) ;

}
