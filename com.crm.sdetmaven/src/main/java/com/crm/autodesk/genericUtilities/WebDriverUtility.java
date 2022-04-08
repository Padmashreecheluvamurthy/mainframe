package com.crm.autodesk.genericUtilities;


import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * The class contains webdriver specific generic methods
 * @author Padmashree
 *
 */
	public class WebDriverUtility {
	
		
	
	/**
	 * this method waits  20 seconds for page load
	 * @param driver 
	 */
	public void waitUntilPageLoad(WebDriver driver )
	{
		driver.manage().timeouts().implicitlyWait(IPathConstants.ITO,TimeUnit.SECONDS);
		
	}
	
	
	
	
	/**
	 * This method wait for the element to be visible 
	 * @param driver
	 * @param 
	 */
	public void waitForElementVisibility(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));	
		
	}
	
	
	
	
	
	/**
	 * This method wait for the element to be clicked , its custom wait created to avoid
	 *  elemenInterAceptable Exception
	 *  @param element
	 *  @throws throwable
	 */
	public void waitAndClick(WebElement element)throws InterruptedException
	{
		int count=0;
		while(count<20)
			try{
				element.click();
				break;
			}
		catch(Throwable e)
		{
			Thread.sleep(1000);
			count++;
		}
	}
	
	
	
	/**
	 * this method enables user to handle dropdown using visible text		
	 * @param element
	 * @param option
	 */	
	public void select(WebElement element, String option)
	{
		Select select=new Select(element);
		select.selectByVisibleText(option);
	}
	
	
	
	/**
	 * This method enables users to handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	
		
	
	
	
	/*
	 * This method  will perform mouse hover action
	 * @param driver
	 * @param element
	 */	
	public void mouseOver(WebDriver driver, WebElement element) 
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	
	
	
	/**
	 * This method perform right click operation
	 * @param driver
	 * @param element
	 */
		public void rightClick(WebDriver driver, WebElement element)
		{
			Actions act=new Actions(driver);
			act.contextClick(element).perform();
		}
		
		
	/**
	 * This method helps to switch from one window to another
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		Set<String>window=driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String winId=it.next();
			String title= driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	
	public void switchFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
		
	}
	
	public void switchFrame(WebDriver driver,WebElement ele)
	{
		driver.switchTo().frame(ele);
		
	}
	
	public void switchFrame(WebDriver driver,String idOrName )
	{
		driver.switchTo().frame(idOrName);
		
	}
	
	public String takesScreenshot(WebDriver driver, String screenshotName)throws Throwable
	{
		JavaUtility jil= new JavaUtility();
		
		String timeStamp = jil.getSystemDate();
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+timeStamp+screenshotName+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}
	}
	
	
	
	
	
