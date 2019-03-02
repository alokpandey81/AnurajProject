/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : VoterDAO.java
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

import java.util.ArrayList;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.ResultBean;

/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public interface VoterDAO {


	/**
	 * 
	 * @param deleteVoterDetails arraylist
	 * @return Return Type: int
	 * 
	 */
	int deleteVoterDetails(ArrayList<String> deleteVoterDetails);

/*	*//**
	 * 
	 * @param VoterBean object
	 * @return Return Type: boolean
	 * 
	 *//*
	boolean updateVoterDetails(VoterBean VoterBean);*/

	/**
	 * 
	 * @param id id
	 * @return Return Type: VoterBean
	 * 
	 */
	ApplicationBean findByID(String id);

	/**
	 * 
	 * @return Return Type: ArrayList<VoterBean>
	 * 
	 */
/*ArrayList<VoterBean> findAll();
*/
	/**
	 * 
	 * @return
	 * Return Type: ArrayList<ResultBean>
	 *
	 */
	ArrayList<ResultBean> findAll();

}
