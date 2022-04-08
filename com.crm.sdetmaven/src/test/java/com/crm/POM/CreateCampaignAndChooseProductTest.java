package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepositories.CampaignVerificationPage;


import com.crm.ObjectRepositories.CreateCampaignPage;

import com.crm.ObjectRepositories.CreateProductPage;

import com.crm.ObjectRepositories.HomePage;
import com.crm.ObjectRepositories.LoginPage;

import com.crm.ObjectRepositories.ProductPage;
import com.crm.autodesk.genericUtilities.ExcelUtility;
import com.crm.autodesk.genericUtilities.FileUtility;
import com.crm.autodesk.genericUtilities.JavaUtility;


import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Script to create campaign , choose product and verify
 * @author Padmashree
 *
 */
public class CreateCampaignAndChooseProductTest {
	public static void main(String[] args) throws Throwable {
		// create object for generic utilities
		FileUtility fil = new FileUtility();
		
		ExcelUtility eil= new ExcelUtility();
		JavaUtility jil= new JavaUtility();
		
		
		String browser= fil.getPropertyKeyValues("browser");
		String url= fil.getPropertyKeyValues("url");
		String username= fil.getPropertyKeyValues("username");
		String password= fil.getPropertyKeyValues("password");
		 String CampName = eil.getDataFromExcel("campaigns", 1, 0);
		 String expectedCampName= CampName+jil.getRandomNumber();
		 
		 String prod1=eil.getDataFromExcel("products", 1, 0);
		 String prodName=prod1+jil.getRandomNumber();
		
		 
		 WebDriver driver = null;
			
			if(browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println("launched browser is"+browser);
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println("launched browser is" +browser);
			}
			
			else
			{
				System.out.println("specify valid browser");
				
			}
			
		
		driver.manage().window().maximize();
		
		
		
		//get url
		driver.get(url);
		
		// login to application
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(username, password);
		
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
		if(actualHeaderText.contains(expectedCampName))
		{
			System.out.println("pass , Campaign is created");
		}
		else
		{
			System.out.println("fail , Campaign is not created");
		}

		homepg.logout(driver);
		
		driver.quit();

	}

}



