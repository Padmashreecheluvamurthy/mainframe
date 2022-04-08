package com.crm.testNg;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.ObjectRepositories.ContactsInformationPage;
import com.crm.ObjectRepositories.Contactspage;
import com.crm.ObjectRepositories.CreateNewOrganizationPage;
import com.crm.ObjectRepositories.CreatingNewContactsPage;
import com.crm.ObjectRepositories.HomePage;
import com.crm.ObjectRepositories.OrganizationsPage;
import com.crm.autodesk.genericUtilities.BaseClass;
import com.crm.autodesk.genericUtilities.ExcelUtility;

import com.crm.autodesk.genericUtilities.JavaUtility;


public class TestNGCreateContactAndChooseOrganizationTest extends BaseClass{
	@Test(groups="smokeTest")
	public void createContactAndChooseOrganization() throws Throwable
	{
		
		ExcelUtility eil= new ExcelUtility();
		JavaUtility jil= new JavaUtility();
		String orgName = eil.getDataFromExcel("org", 1, 1);
		 String expectedOrgName= orgName+jil.getRandomNumber();
		 
		 String lastName=eil.getDataFromExcel("contacts", 1, 2);
		
		 
		 
			

		// Click on organization link
		HomePage homepg = new HomePage(driver);
		homepg.clickOnOrganizationLink();
		
		//click on add icon
		OrganizationsPage organizationpage = new OrganizationsPage(driver);
		organizationpage.clickOnAddIconImageForOrganization();
		
		//create organization and save
		CreateNewOrganizationPage createNewOrg = new CreateNewOrganizationPage(driver);
		createNewOrg.createOrg(expectedOrgName);
		
		// Explicitwait
		Contactspage getContactspage= new Contactspage(driver);
		getContactspage.waitForElement(driver);
		
		// click on contacts link
		
		getContactspage.clickOnContactslink();
		
		// click on add icon of contact
		
		getContactspage.contactsAddIcon(driver);
		
		// create contact
		CreatingNewContactsPage createContact = new CreatingNewContactsPage(driver);
		createContact.enterMandatoryFielldOfContact(driver, lastName,expectedOrgName);
		
		//create  object for headertext
		ContactsInformationPage actualHeader= new ContactsInformationPage(driver);
		String actualHeaderText=actualHeader.headerinfo(driver);
		
		//verification
		Assert.assertEquals(actualHeaderText.contains(lastName), true);
		
	}

}
