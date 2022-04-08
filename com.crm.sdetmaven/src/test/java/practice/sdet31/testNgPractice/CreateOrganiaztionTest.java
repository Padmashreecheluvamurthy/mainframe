package practice.sdet31.testNgPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genericUtilities.BaseClass;
import com.crm.autodesk.genericUtilities.ExcelUtility;
import com.crm.autodesk.genericUtilities.JavaUtility;
import com.crm.autodesk.genericUtilities.WebDriverUtility;
@Listeners(com.crm.autodesk.genericUtilities.ListenerImplementationClass.class)

public class CreateOrganiaztionTest extends BaseClass {
	
	
	@Test
	public void createOrganization() throws Throwable
	{
		
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib =new WebDriverUtility();
		JavaUtility jlib=new JavaUtility();
         int rannum= jlib.getRandomNumber();
		
		
		String orgname=elib.getDataFromExcel("org", 1, 1)+rannum;
	
	
	
	//navigate to organization and create organization
	driver.findElement(By.linkText("Organizations")).click();
	
	
	//navigate to create organization
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	//create a new org
	driver.findElement(By.name("accountname")).sendKeys(orgname);
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
	
	//verify the page
	String actHeadr = driver.findElement(By.className("dvHeaderText")).getText();
	Assert.assertEquals(actHeadr.contains(orgname), true);
	
	WebElement wb =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	//moveToelement and  actions method using library
	wlib.mouseOver(driver, wb);
}
	@Test
	public void exception()
	{
		
		 throw new SkipException("skipped");
	}
}
