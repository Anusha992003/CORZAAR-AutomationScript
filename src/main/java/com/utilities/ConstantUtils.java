package com.utilities;

import com.utilities.ConfigReader;

public class ConstantUtils {
	public static final int IMPLICIT_WAIT_TIME = 10;

	public static final int EXPLICIT_WAIT_TIME = 10;

	public static final int PAGE_LOAD_TIME = 20;

	public static final String MOBILENUMBER = ConfigReader.getProperty("validmobile");

	public static final String NAME = ConfigReader.getProperty("validname");
	
	public static final String OTP = ConfigReader.getProperty("otp");

}
