package com.crm.testNg;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.ObjectRepositories.CampaignVerificationPage;
import com.crm.ObjectRepositories.CreateCampaignPage;
import com.crm.ObjectRepositories.CreateProductPage;
import com.crm.ObjectRepositories.HomePage;
import com.crm.ObjectRepositories.ProductPage;
import com.crm.autodesk.genericUtilities.BaseClass;
import com.crm.autodesk.genericUtilities.ExcelUtility;
import com.crm.autodesk.genericUtilities.JavaUtility;

public class TestNGCreateCampaignAndChooseProductTest extends BaseClass {
	
	@Test(groups="smokeTest")
	public void createCampaignandChooseProduct() throws Throwable
	{
		
		ExcelUtility eil= new ExcelUtility();
		JavaUtility jil=new JavaUtility();
		
		
		String CampName = eil.getDataFromExcel("campaigns", 1, 0);
		 String expectedCampName= CampName+jil.getRandomNumber();
		 
		 String prod1=eil.getDataFromExcel("products", 1, 0);
		 String prodName=prod1+jil.getRandomNumber();
		// Click on product link
				HomePage homepg = new HomePage(driver);
				homepg.productsLink(driver);
				
				//click on addicon
				ProductPage addIcon=new ProductPage(driver);
				addIcon.ProductaddIcon(driver);
			
				
				//create Product and save
				CreateProductPage createNewProd = new CreateProductPage(driver);
				createNewProd.createProduct(driver, prodName);
				
				// Explicitwait
				CreateCampaignPage campaignpage= new CreateCampaignPage(driver);
				campaignpage.waitforElement(driver);
				
				// click on campaigns  link
				createNewProd.moreImage(driver);
				createNewProd.campaignsLink(driver);
				
				
				
				// click on add icon of campaign and create campaign
				
				campaignpage.createCampaigns(driver,expectedCampName,prodName);
				
				
				//create  object for headertext
				CampaignVerificationPage actualHeader= new CampaignVerificationPage(driver);
				String actualHeaderText=actualHeader.headerinfo(driver);
				
				//verification
				Assert.assertEquals(actualHeaderText.contains(expectedCampName), true);
				
		
	}

}
