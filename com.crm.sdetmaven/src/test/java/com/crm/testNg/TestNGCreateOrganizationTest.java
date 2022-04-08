package com.crm.testNg;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepositories.CreateNewOrganizationPage;
import com.crm.ObjectRepositories.HomePage;
import com.crm.ObjectRepositories.OrganizationInformationPage;
import com.crm.ObjectRepositories.OrganizationsPage;
import com.crm.autodesk.genericUtilities.BaseClass;
import com.crm.autodesk.genericUtilities.ExcelUtility;
import com.crm.autodesk.genericUtilities.JavaUtility;

@Listeners(com.crm.autodesk.genericUtilities.ListenerImplementationClass.class)
public class TestNGCreateOrganizationTest extends BaseClass{
	
	@Test(groups="smokeTest")
	public void createOrganization() throws Throwable
	{	
		// create object for testdata utility
		ExcelUtility eUtil= new ExcelUtility();
		JavaUtility jUtil= new JavaUtility();
		
		
		
		
		//declaring names 
		String orgName= eUtil.getDataFromExcel("org", 1, 1);
		String expectedOrgName=orgName+jUtil.getRandomNumber();
		
		
		
		
		// Click on organization link
		HomePage homePage=new HomePage(driver);
		
		homePage.clickOnOrganizationLink();
		
		//click on add icon
		OrganizationsPage organizationpage = new OrganizationsPage(driver);
		organizationpage.clickOnAddIconImageForOrganization();
		
		//create organization
		CreateNewOrganizationPage createNewOrg = new CreateNewOrganizationPage(driver);
		createNewOrg.createOrg(expectedOrgName);
		
		//Assert.fail();
		
		// organization information verification
		OrganizationInformationPage orgInfopage = new OrganizationInformationPage(driver);
		String actualOrgName= orgInfopage.actualHeaderText();
		
		// verify the organization created
		Assert.assertEquals(actualOrgName.contains(expectedOrgName), true);
				
		
		
	}

}
