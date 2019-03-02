/**
 *
 * Copyright 2014 Jeeshan & Mayank All rights reserved.
 * 
 * Customer specific copyright notice     :All Rights reserved.
 *
 * File Name       : ProfileBean.java
 *
 * Description     :Electronic Voting System.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :28-MAR-2014
 * 
 * Modification History:Modified by Jeeshan & Mayank, on date 02-APR-2014.
 **/
package com.wipro.evs.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Jeeshan & Mayank APR 08, 2014
 * @version 1.0.0.
 */
public class ProfileBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 183289734157815530L;
	private String userID;
	private String password;
	private String confirmPassword;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private String street;
	private String location;
	private String city;
	private String state;
	private String pincode;
	private String mobileNo;
	private String emailID;

	/**
	 * 
	 */
	public ProfileBean() {
		super();
		userID = "";
	}

	/**
	 * @return the userID
	 */
	public String getUserID () {
		return userID;
	}

	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID (final String userID) {
		this.userID = userID;
	}

	/**
	 * @return the password
	 */
	public String getPassword () {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword (final String password) {
		this.password = password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword () {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword
	 *            the confirmPassword to set
	 */
	public void setConfirmPassword (final String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName () {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName (final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName () {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName (final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth () {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth (final Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the gender
	 */
	public String getGender () {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender (final String gender) {
		this.gender = gender;
	}

	/**
	 * @return the street
	 */
	public String getStreet () {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet (final String street) {
		this.street = street;
	}

	/**
	 * @return the location
	 */
	public String getLocation () {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation (final String location) {
		this.location = location;
	}

	/**
	 * @return the city
	 */
	public String getCity () {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity (final String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState () {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState (final String state) {
		this.state = state;
	}

	/**
	 * @return the pincode
	 */
	public String getPincode () {
		return pincode;
	}

	/**
	 * @param pincode
	 *            the pincode to set
	 */
	public void setPincode (final String pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo () {
		return mobileNo;
	}

	/**
	 * @param mobileNo
	 *            the mobileNo to set
	 */
	public void setMobileNo (final String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the emailID
	 */
	public String getEmailID () {
		return emailID;
	}

	/**
	 * @param emailID
	 *            the emailID to set
	 */
	public void setEmailID (final String emailID) {
		this.emailID = emailID;
	}

}
