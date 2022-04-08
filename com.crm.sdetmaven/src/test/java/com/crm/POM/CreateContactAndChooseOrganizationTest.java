package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepositories.ContactsInformationPage;
import com.crm.ObjectRepositories.Contactspage;
import com.crm.ObjectRepositories.CreateNewOrganizationPage;
import com.crm.ObjectRepositories.CreatingNewContactsPage;
import com.crm.ObjectRepositories.HomePage;
import com.crm.ObjectRepositories.LoginPage;
import com.crm.ObjectRepositories.OrganizationsPage;
import com.crm.autodesk.genericUtilities.ExcelUtility;
import com.crm.autodesk.genericUtilities.FileUtility;
import com.crm.autodesk.genericUtilities.JavaUtility;
import com.crm.autodesk.genericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Script to create contact and choose organization and verify 
 * @author Padmashree
 */
public class CreateContactAndChooseOrganizationTest {

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
		 
		 String lastName=eil.getDataFromExcel("contacts", 1, 2);
		
		 
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
		if(actualHeaderText.contains(lastName))
		{
			System.out.println("pass , Contact is created");
		}
		else
		{
			System.out.println("fail , Contact  is  not created");
		}

		homepg.logout(driver);
		
		driver.quit();

	}

}
