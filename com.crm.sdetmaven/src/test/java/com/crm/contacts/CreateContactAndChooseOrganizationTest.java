package com.crm.contacts;


import java.io.IOException;






import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.crm.autodesk.genericUtilities.ExcelUtility;
import com.crm.autodesk.genericUtilities.FileUtility;
import com.crm.autodesk.genericUtilities.JavaUtility;
import com.crm.autodesk.genericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactAndChooseOrganizationTest {
	
	public static void main(String[] args) throws IOException, Throwable
	{
		/*Object creation for utilities*/
		
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib =new WebDriverUtility();
		
		/*launching browser and entering common data using library*/
		
		String browser=flib.getPropertyKeyValues("browser");
		String url=flib.getPropertyKeyValues("url");
		String username=flib.getPropertyKeyValues("username");
		String password=flib.getPropertyKeyValues("password");
		
		
		/* declare and initialize test data*/
		
		int rannum= jlib.getRandomNumber();
		
		String lastname=elib.getDataFromExcel("contacts", 2, 2)+rannum;
		String orgname=elib.getDataFromExcel("org", 1, 1)+rannum;
		
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
			
		
			//applying implicit wait
			wlib.waitUntilPageLoad(driver);
			
			
			driver.manage().window().maximize();
			
			
			//launch browser
			driver.get(url);
			
			
			//enter credentials and login
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			
			
			
			//navigate to organization and create organization
			driver.findElement(By.linkText("Organizations")).click();
			
			
			//navigate to create organization
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			//create a new org
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					
			
			//verify the page
			String actHeadr = driver.findElement(By.className("dvHeaderText")).getText();
			
			if(actHeadr.contains(orgname))
			{
				System.out.println(orgname+" is verified ==== Pass");
				
			}
			else
			{
				System.out.println(orgname+" is not verified ==== Fail");
				
			}
			
			
			WebElement ele=driver.findElement(By.linkText("Contacts"));
			
			/*applying explicit wait through library */
			wlib.waitForElementVisibility(driver, ele);
			
			
			// navigate to contact link
			
			driver.findElement(By.linkText("Contacts")).click();
			

			
			//click on create contact  page
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
			
			
			//entering mandatory field
			driver.findElement(By.name("lastname")).sendKeys(lastname);
				
			
			
			// choose organization in contacts
			driver.findElement(By.xpath("//td[text()='Organization Name 			']/following-sibling::td/img")).click();
			
			// switch to window using libabry
			wlib.switchToWindow(driver, "Accounts");
		
			driver.findElement(By.id("search_txt")).sendKeys(orgname);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
			
			//Switch back to main window using library
			wlib.switchToWindow(driver, "Contacts");
			
			
			// validate
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			String actHeadr1 = driver.findElement(By.className("dvHeaderText")).getText();
			
			if(actHeadr1.contains(lastname))
			{
				System.out.println(lastname+" is verified ==== Pass");
				
			}
			else
			{
				System.out.println(lastname+" is not verified ==== Fail");
				
			}
			
			
			//logout
			WebElement wb =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			
			//moveToelement and  actions method using library
			wlib.mouseOver(driver, wb);
			
			
			
			
			
			driver.findElement(By.linkText("Sign Out")).click();
			
			
			driver.quit();
			

}
}

