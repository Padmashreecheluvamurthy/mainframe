package practice.sdet31.testNgPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserTest {
	
	@Test(retryAnalyzer= com.crm.autodesk.genericUtilities.RetryAnalyzerImplementationClass.class)
	public void create()
	{
		System.out.println("retry");
		Assert.assertEquals(false, true);
		
	}

}
