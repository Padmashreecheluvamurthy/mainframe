package com.crm.POM;

import java.util.List;

//import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepositories.CreateLeadsPage;
import com.crm.ObjectRepositories.HomePage;
import com.crm.ObjectRepositories.LeadInformationPage;
import com.crm.ObjectRepositories.LeadsListPage;
//import com.crm.ObjectRepositories.LeadsListPage;
import com.crm.ObjectRepositories.LeadsPage;
import com.crm.ObjectRepositories.LoginPage;
import com.crm.autodesk.genericUtilities.ExcelUtility;
import com.crm.autodesk.genericUtilities.FileUtility;
import com.crm.autodesk.genericUtilities.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * script to create new lead by selecting diffrenet rating drop down
 * @author Padmashree
 *
 */

public class CreateNewLeadBySelectingDifferentRatingDropDownTest {
	public static void main(String[] args) throws Throwable {

		// create object for generic utilities
		FileUtility fil = new FileUtility();
		// WebDriverUtility wil = new WebDriverUtility();
		ExcelUtility eil = new ExcelUtility();
		JavaUtility jil = new JavaUtility();

		String browser = fil.getPropertyKeyValues("browser");
		String url = fil.getPropertyKeyValues("url");
		String username = fil.getPropertyKeyValues("username");
		String password = fil.getPropertyKeyValues("password");
		String firstName = eil.getDataFromExcel("leads", 1, 2);
		String lastName = eil.getDataFromExcel("leads", 1, 1);
		String expectedName = lastName + jil.getRandomNumber();
		String rating = eil.getDataFromExcel("leads", 1, 7);
		String loginverify = eil.getDataFromExcel("leads", 8, 0);
		String homepageVerify = eil.getDataFromExcel("leads", 8, 1);
		String createLeadpgVerify = eil.getDataFromExcel("leads", 8, 2);
		//String compName = eil.getDataFromExcel("leads", 1, 3);
		String expectedleadName = lastName + jil.getRandomNumber();
		//String lead = eil.getDataFromExcel("leads", 1, 8);

		WebDriver driver = null;

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("launched browser is" + browser);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("launched browser is" + browser);
		}

		else {
			System.out.println("specify valid browser");

		}

		driver.manage().window().maximize();

		// get url
		driver.get(url);

		// login to application and verify

		LoginPage loginpage = new LoginPage(driver);

		if (driver.getTitle().contains(loginverify)) {
			System.out.println("Login page displayed");
		} else {
			System.out.println("Login page not displayed");
		}

		loginpage.login(username, password);

		// Home page verification
		if (driver.getTitle().contains(homepageVerify)) {
			System.out.println("Home page displayed");
		} else {
			System.out.println("Home page not displayed");
		}

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

		createleadpg.createLeadsAndRating(firstName, expectedName, expectedleadName, rating);
// verify lead creation
		LeadInformationPage leadinfopg = new LeadInformationPage(driver);
		String actualHeader = leadinfopg.uniqueLeadNum(driver);
		if (actualHeader.contains(expectedName)) {
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
			 
			  if (count == 1) 
			  { 
				  System.out.println("Lead is Unique "); 
				  } 
			  else
				  {
			  System.out.println(" Lead Is not Unique");
			  
			  }
			 
		homepg.logout(driver);

		driver.quit();

	}
}
