package com.crm.testNg;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.ObjectRepositories.CreateNewOrganizationPage;
import com.crm.ObjectRepositories.HomePage;
import com.crm.ObjectRepositories.OrganizationInformationPage;
import com.crm.ObjectRepositories.OrganizationsPage;
import com.crm.autodesk.genericUtilities.BaseClass;
import com.crm.autodesk.genericUtilities.ExcelUtility;
//import com.crm.autodesk.genericUtilities.FileUtility;
import com.crm.autodesk.genericUtilities.JavaUtility;
//import com.crm.autodesk.genericUtilities.WebDriverUtility;

public class TestNGCreateOrganizationAndChooseIndustryTest extends BaseClass {
	@Test(groups="systemTest")
	public void CreateorganizationChooseIndustry() throws Throwable
	{
		// create object for generic utilities
				//FileUtility fil = new FileUtility();
				//WebDriverUtility wil = new WebDriverUtility();
				ExcelUtility eil= new ExcelUtility();
				JavaUtility jil= new JavaUtility();
				String orgName = eil.getDataFromExcel("org", 1, 1);
				 String expectedOrgName= orgName+jil.getRandomNumber();
				 String industry = eil.getDataFromExcel("org", 1, 2);
				// Click on organization link
					HomePage homepg = new HomePage(driver);
					homepg.clickOnOrganizationLink();
					
					//click on add icon
					OrganizationsPage organizationpage = new OrganizationsPage(driver);
					organizationpage.clickOnAddIconImageForOrganization();
					
					// create organization and choose industry and save
					CreateNewOrganizationPage createNewOrg = new CreateNewOrganizationPage(driver);
					createNewOrg.createOrganization(expectedOrgName, industry);
					
					OrganizationInformationPage orgInfopage = new OrganizationInformationPage(driver);
					String actualOrgName= orgInfopage.actualHeaderText();
					
					// verify the organization created
					Assert.assertEquals(actualOrgName.contains(expectedOrgName), true);
					
					
	}

}
