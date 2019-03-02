/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : User.java
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

import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.bean.ProfileBean;

/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public interface User {

	String changePassword(final CredentialsBean credentialsBean, final String id);

	String login(final CredentialsBean credentialsBean);

	boolean logout(final String userId);

	String register(final ProfileBean profileBean);
}
