package com.crm.autodesk.genericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * this class contains java specific generic libraries
 * @author Padmashree
 *
 */

public class JavaUtility {
	/**
	 * It is used to generate the random number with in the boundary of 0 to 10000 
	 * @return intData
	 */
	
	public int getRandomNumber()
	{
		Random random = new Random();
		int ranNum = random.nextInt(10000);
		return ranNum;
		
	}
	
	/**
	 * It is used to get the current system date and time
	 * @return String
	 */
	
	public String getSystemDate() 
	{
		Date date = new Date();
		String systemDateAndTime = date.toString().replace(":", "-");
		return systemDateAndTime;
	}
	/**
	 * its used to get the current system date with YYYY-MM-DD format
	 * @return String
	 */
	public String getSystemDateYYYY_MM_DD()
	{
		Date date = new Date();
		String systemDateAndTime = date.toString();
		System.out.println(systemDateAndTime);
		String[] arr = systemDateAndTime.split("");
		
		String DD=arr[2];
		String YYYY=arr[5];
		@SuppressWarnings("deprecation")
		int MM = date.getMonth()+1;
		
		String finalFormat=YYYY+"-"+MM+"-"+DD;
		return finalFormat;
		
	}
	
	
	
		
	 
 
}
