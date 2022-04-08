package com.crm.products;


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


public class CreateProductTest {

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
		
		String prodname=elib.getDataFromExcel("products", 1, 0)+rannum;
		
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
		
		//create product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.name("productname")).sendKeys(prodname);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		
		//verification of product
		String actHeadr1 = driver.findElement(By.className("lvtHeaderText")).getText();
		
		if(actHeadr1.contains(prodname))
		{
			System.out.println(prodname+" prodname is verified ==== Pass");
			
		}
		else
		{
			System.out.println(prodname+" prodname is not verified ==== Fail");
			
		}
		
		//logout
		WebElement wb1 =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		//moveToelement and  actions method using library
		wlib.mouseOver(driver, wb1);
		

		
		
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		
		driver.quit();
		
		
		
		
}
}
		
			
		