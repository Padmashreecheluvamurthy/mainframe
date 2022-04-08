package practice.sdet31.testNgPractice;

import org.testng.annotations.Test;

public class SampleTestNgTest {
	
	@Test(groups="smokeTest")
	public void  ceateAccount() 
			//throws Exception
	{
		System.out.println("Login");
		System.out.println("Create Account");
		System.out.println("Login");
		//throw new Exception();
	}
	
	@Test(groups="functionalTest")
	public void  modifyAccount()
	{
		System.out.println("Login");
		System.out.println("Modify Account");
		System.out.println("Login");
	}

	@Test(groups="integrationTest")
	public void  deleteAccount()
	{
		System.out.println("Login");
		System.out.println("Modify Account");
		System.out.println("Login");
	}
	

}
