package practice;

import java.io.IOException;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import practice.sdet31.ExcelLibTest;

public class Sdet2Test {
	public static void main(String[] args) throws IOException, Throwable
	{
		ExcelLibTest lib = new ExcelLibTest();
		String org1 =lib.getExcelData("org", 1, 0);
	
		Random ran= new Random();
			int rannum = ran.nextInt(1000);
			String orgname= org1 + rannum;
			
			
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			
			
			//launch browser
			driver.get("http://localhost:8888");
			//enter credentials and login
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			
			
			//create organization
			driver.findElement(By.linkText("Organizations")).click();
			
			Thread.sleep(5000);
			//navigate to create organization
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			//create a new org
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//verify
			Thread.sleep(5000);
			String actHeadr = driver.findElement(By.className("dvHeaderText")).getText();
			Thread.sleep(5000);
			if(actHeadr.contains(orgname))
			{
				System.out.println(orgname+" is verified ==== Pass");
				
			}
			else
			{
				System.out.println(orgname+" is not verified ==== Fail");
				
			}
			
			Thread.sleep(5000);
			WebElement wb =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);
			act.moveToElement(wb).perform();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Sign Out")).click();
			Thread.sleep(5000);
			
			driver.quit();
				
			
		}

	
		
		
	}


