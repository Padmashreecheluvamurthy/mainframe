package com.crm.testNg;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.ObjectRepositories.CreateLeadsPage;
import com.crm.ObjectRepositories.HomePage;
import com.crm.ObjectRepositories.LeadInformationPage;
import com.crm.ObjectRepositories.LeadsListPage;
import com.crm.ObjectRepositories.LeadsPage;
import com.crm.autodesk.genericUtilities.BaseClass;
import com.crm.autodesk.genericUtilities.ExcelUtility;
import com.crm.autodesk.genericUtilities.JavaUtility;

public class TestNGCreateNewLeadBySelectingDifferentRatingTest extends BaseClass {
	
	@Test(groups="integrationTest")
	public void createNewLeadByRating() throws Throwable
	{
		// WebDriverUtility wil = new WebDriverUtility();
				ExcelUtility eil = new ExcelUtility();
				JavaUtility jil = new JavaUtility();
				String firstName = eil.getDataFromExcel("leads", 1, 2);
				String lastname = eil.getDataFromExcel("leads", 1, 1);
				String lastName = lastname + jil.getRandomNumber();
				String rating = eil.getDataFromExcel("leads", 1, 7);
				
				String createLeadpgVerify = eil.getDataFromExcel("leads", 8, 2);
				String compname = eil.getDataFromExcel("leads", 1, 3);
				
				
				// create leads
				HomePage homepg = new HomePage(driver);
				homepg.leadLink();

				// click on add icon
				LeadsPage leadsPage = new LeadsPage(driver);
				leadsPage.addIconClick();

				// enetr fields in create lead page and verify the create lead page
				CreateLeadsPage createleadpg = new CreateLeadsPage(driver);
				if (driver.getCurrentUrl().contains(createLeadpgVerify)) {
					System.out.println("Create Lead page displayed ");

				} else {
					System.out.println("Create Lead page not displayed ");
				}

				createleadpg.createLeadsAndRating(firstName, lastName, compname, rating);
		// verify lead creation
				LeadInformationPage leadinfopg = new LeadInformationPage(driver);
				String actualHeader = leadinfopg.uniqueLeadNum(driver);
				if (actualHeader.contains(lastName)) {
					System.out.println("New Lead is created");
				} else {
					System.out.println("New Lead is not created");
				}

				// click on leads link
				
				 String leadNumber = leadinfopg.headerinfo();
				
				 leadinfopg.clickonLeadsLink();
				 
				 
				 //search lead num in leads list page
				 
				 LeadsListPage leadsListpg = new LeadsListPage(driver); 
				 leadsListpg.searchInLeadsList(leadNumber);
				 
				// verify unique lead number
				
					  
					  List<WebElement> leadsList = leadsListpg.getLeadlist(); 
					  int count = 0; 
					  for (WebElement ele : leadsList) 
					  { 
						
						  if(ele.getText().equals(leadNumber))
						  { 
							  System.out.println(ele.getText());
							  count++;
					  
					  }
					  
					  }
					  Assert.assertTrue(count == 1, "Lead is Unique");
					  

	}

}
