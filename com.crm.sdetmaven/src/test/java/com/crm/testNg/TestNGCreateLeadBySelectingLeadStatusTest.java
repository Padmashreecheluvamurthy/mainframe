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

public class TestNGCreateLeadBySelectingLeadStatusTest extends BaseClass{
 @Test(groups ="integrationTest")
 public void createLeadBySelectingLeadStatus() throws Throwable
 {
	// create object for generic utilities
			//FileUtility fil = new FileUtility();
			//WebDriverUtility wil = new WebDriverUtility();
			ExcelUtility eil= new ExcelUtility();
			JavaUtility jil= new JavaUtility();
			String firstName = eil.getDataFromExcel("leads", 1, 2);
			 String lastName=eil.getDataFromExcel("leads",1, 1);
			 String expectedName= lastName+jil.getRandomNumber();
			 String leadStatus = eil.getDataFromExcel("leads", 1, 9);
			 //String loginverify=eil.getDataFromExcel("leads", 8, 0);
			 //String homepageVerify= eil.getDataFromExcel("leads", 8, 1);
			 String createLeadpgVerify= eil.getDataFromExcel("leads", 8, 2);
			 String compName=eil.getDataFromExcel("leads",1, 3);
			 String expectedCompName= compName+jil.getRandomNumber();
			 
			//create leads
			 HomePage homepg=new HomePage(driver);
			 homepg.leadLink();
			 
			 // click on add icon
			 LeadsPage leadsPage=new LeadsPage(driver);
			 leadsPage.addIconClick();
			 
			 // enetr fields in create lead page and verify the create lead page
			 CreateLeadsPage createleadpg=new CreateLeadsPage(driver);
		Assert.assertEquals(driver.getCurrentUrl().contains(createLeadpgVerify), true);
			
			 
			 createleadpg.createLeadsAndLeadsStatus(firstName, expectedName, expectedCompName,leadStatus);
			 
			
			 // verify the lead creation
			 LeadInformationPage leadinfopg= new LeadInformationPage(driver);
			 String actualHeader = leadinfopg.uniqueLeadNum(driver);
			 Assert.assertEquals(actualHeader.contains(expectedName), true);
			 
			  
			 // verify the unique lead number
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
