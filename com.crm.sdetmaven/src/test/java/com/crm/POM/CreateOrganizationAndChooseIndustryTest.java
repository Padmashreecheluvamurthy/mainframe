package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepositories.CreateNewOrganizationPage;
import com.crm.ObjectRepositories.HomePage;
import com.crm.ObjectRepositories.LoginPage;
import com.crm.ObjectRepositories.OrganizationInformationPage;
import com.crm.ObjectRepositories.OrganizationsPage;
import com.crm.autodesk.genericUtilities.ExcelUtility;
import com.crm.autodesk.genericUtilities.FileUtility;
import com.crm.autodesk.genericUtilities.JavaUtility;
import com.crm.autodesk.genericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This is used to create organization and choosing the industry and 
 * verifying it after  creation
 * @author Padmashree
 *
 */
public class CreateOrganizationAndChooseIndustryTest {

	public static void main(String[] args) throws Throwable {
		// create object for generic utilities
		FileUtility fil = new FileUtility();
		WebDriverUtility wil = new WebDriverUtility();
		ExcelUtility eil= new ExcelUtility();
		JavaUtility jil= new JavaUtility();
		
		
		String browser= fil.getPropertyKeyValues("browser");
		String url= fil.getPropertyKeyValues("url");
		String username= fil.getPropertyKeyValues("username");
		String password= fil.getPropertyKeyValues("password");
		 String orgName = eil.getDataFromExcel("org", 1, 1);
		 String expectedOrgName= orgName+jil.getRandomNumber();
		 String industry = eil.getDataFromExcel("org", 1, 2);
		 
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
		
		wil.waitUntilPageLoad(driver);
		
		//get url
		driver.get(url);
		
		// login to application
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(username, password);
		
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
		if(actualOrgName.contains(expectedOrgName))
		{
			System.out.println("pass , Organization is created");
		}
		else
		{
			System.out.println("fail , Organization is created");
		}
		
		// logout
		
		homepg.logout(driver);
		
		driver.quit();
				
		
		
		
		
		
		
		
	}

}
