package com.crm.autodesk.genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class contains common data generic files
 * @author Padmashree
 *
 */
public class FileUtility {
	/**
	 * It is used to get commondata.properties file
	 *  based on Key which we pass as argument
	 *  @param key
	 *  @throws Throwable
	 */
	public String getPropertyKeyValues(String key)throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.PROPERTYFILE_PATH);
		Properties proObj= new Properties();
		proObj.load(fis);
		String value=proObj.getProperty(key);
		return value;
	}
	
	
		
		
	}


