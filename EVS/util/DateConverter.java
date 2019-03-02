/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : DateConverter.java
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


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public class DateConverter {

	/**
	 * @param today Today
	 * @return date Date
	 */
	public static java.sql.Date convertToSql (final java.util.Date today) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String todayStr = fmt.format(today);
		java.sql.Date sqlDate = java.sql.Date.valueOf(new String(todayStr));
		return sqlDate;
	}
	
	public static java.util.Date convertToUtil(String today){
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//String startDate = "2013-09-25";
		try {
			java.util.Date frmDate = sdf.parse(today);
			return frmDate;

		} catch (ParseException exception) {
			// TODO Auto-generated catch block
			LogFile.logging(exception, "ParseException");
		}
		return null; 
	}
	
	
	/**
	 * @param args string
	 */
	public static void main (final String[] args) {
		
	}
}

