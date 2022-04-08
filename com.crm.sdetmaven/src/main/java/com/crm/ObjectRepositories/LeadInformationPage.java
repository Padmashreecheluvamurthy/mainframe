package com.crm.ObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 *Object Repository for Lead Information Page 
 * @author Padmashree
 *
 */
public class LeadInformationPage {
// initialization
	public LeadInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerInfo;
	
	
	
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;

//getter method
	public WebElement getHeaderInfo() {
		return headerInfo;
	}
	
	
	
	
public WebElement getLeadsLink() {
		return leadsLink;
	}







	// business logic

	public String headerinfo()
	{
		String temp=headerInfo.getText();
		String leadNum=temp.split(" ")[1];
		
		return leadNum;
		
		
	}
	
	public void clickonLeadsLink()
	{
		leadsLink.click();
		
	}
	
	public String uniqueLeadNum(WebDriver driver)
	{
		
		String newLeadNum = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		return newLeadNum;
	}
	
	

}
