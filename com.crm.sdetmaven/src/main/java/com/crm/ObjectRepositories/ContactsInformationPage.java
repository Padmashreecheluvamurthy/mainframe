package com.crm.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object repository for Contacts Information Page
 * @author Padmashree
 *
 */
public class ContactsInformationPage {
// initialization
	public ContactsInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
// declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerInfo;

//getter method
	public WebElement getHeaderInfo() {
		return headerInfo;
	}
	
// business logic
	
	public String headerinfo(WebDriver driver)
	{
		return headerInfo.getText();
		
	}
	
	

	
	
}
