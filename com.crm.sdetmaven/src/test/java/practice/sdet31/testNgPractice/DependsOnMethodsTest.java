package practice.sdet31.testNgPractice;

import org.testng.annotations.Test;

public class DependsOnMethodsTest {
	
	@Test(groups="functionalTest")
	public void  ceateAccount() 
			//throws Exception
	{
		System.out.println("Login");
		System.out.println("Create Account");
		System.out.println("Login");
		//throw new Exception();
	}
	
	@Test(groups="regressionTest",dependsOnMethods = "ceateAccount")
	public void  modifyAccount()
	{
		System.out.println("Login");
		System.out.println("Modify Account");
		System.out.println("Login");
	}

	@Test(groups="integrationTest",dependsOnMethods = {"ceateAccount","modifyAccount"})
	public void  deleteAccount()
	{
		System.out.println("Login");
		System.out.println("Modify Account");
		System.out.println("Login");
	}
	

}
