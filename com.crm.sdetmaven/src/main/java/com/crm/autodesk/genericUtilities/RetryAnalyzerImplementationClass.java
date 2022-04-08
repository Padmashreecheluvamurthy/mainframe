package com.crm.autodesk.genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides the implementation of iRetryanalyser interface
 * @author Padmashree
 *
 */
public class RetryAnalyzerImplementationClass implements IRetryAnalyzer{
int count=0;
int retry=5;
	public boolean retry(ITestResult result) {
		if(count<retry)
		{
			count++;
			return true;
		}
		
		return false;
	}
	
	
	

}
