package com.crm.autodesk.genericUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;

import com.crm.ObjectRepositories.HomePage;
import com.crm.ObjectRepositories.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass  {
	//create object for generic utilities
	public WebDriver driver=null;
	public FileUtility fUtil= new FileUtility();
	public static WebDriver sDriver;
	 
	
	@BeforeSuite(groups= {"smokeTest","functionalTest","systemTest","integrationTest","regressionTest"})
	public void beforeSuite() {
		System.out.println("establish database connection");
	}
	
	@BeforeTest(groups= {"smokeTest","functionalTest","systemTest","integrationTest","regressionTest"})
	public void beforeTest()
	{
		System.out.println("exceute in parallel mode");
	}
	//@Parameters("browsername")
	@BeforeClass(groups= {"smokeTest","functionalTest","systemTest","integrationTest","regressionTest"})
	public void beforeClass() throws Throwable
	{
		//launch the browser
		String browser = fUtil.getPropertyKeyValues("browser");
		String url = fUtil.getPropertyKeyValues("url");
	
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
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get(url);
		 sDriver=driver;
		
	}
	
	@BeforeMethod(groups= {"smokeTest","functionalTest","systemTest","integrationTest","regressionTest"})
	public void beforeMethod() throws Throwable
	{
		//login to application
		LoginPage loginpage = new LoginPage(driver);
		String userName= fUtil.getPropertyKeyValues("username");
		String passWord= fUtil.getPropertyKeyValues("password");		
		loginpage.login(userName,passWord);
	}
	
	@AfterMethod(groups= {"smokeTest","functionalTest","systemTest","integrationTest","regressionTest"})
	public void afterMethod()
	{
		//logout from application
		HomePage homePage = new HomePage(driver);
		homePage.logout(driver);
		
	}
	
	@AfterClass(groups= {"smokeTest","functionalTest","systemTest","integrationTest","regressionTest"})
	public void afterClass()
	{
		//close the browser
		driver.quit();
	}
	
	@AfterTest(groups= {"smokeTest","functionalTest","systemTest","integrationTest","regressionTest"})
	public void afterTest()
	{
		System.out.println("closing parallel execution mode");
	}
	
	@AfterSuite(groups= {"smokeTest","functionalTest","systemTest","integrationTest","regressionTest"})
	public void afterSuite()
	{
		System.out.println("closing the database connection");
	}
}
