package com.crm.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtilities.WebDriverUtility;

/**
 * Object repository for Contacts Link 
 * @author Padmashree
 *
 */
public class Contactspage extends WebDriverUtility{

	public Contactspage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	// declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private  WebElement contactsAddIcon;
	
	@FindBy(linkText="Contacts")
	private WebElement clickOnContactsLink;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement waitForElement;
	
	//getter method
	public WebElement getContactsAddIcon() {
		return contactsAddIcon;
	}
	
	
	public WebElement getClickOnContactsLink() {
		return clickOnContactsLink;
	}
	
	public WebElement getWaitForElement() {
		return waitForElement;
	}
	
	

	//business logic
	
	public void waitForElement(WebDriver driver)
	{
		waitForElementVisibility(driver, waitForElement);	
	}


	public void clickOnContactslink()
	{
		clickOnContactsLink.click();
	}
	public void contactsAddIcon(WebDriver driver)
	{
		contactsAddIcon.click();	
	}
	
	
	


	}


