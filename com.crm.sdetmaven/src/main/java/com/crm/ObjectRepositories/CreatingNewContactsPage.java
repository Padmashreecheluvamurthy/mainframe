package com.crm.ObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtilities.WebDriverUtility;
/**
 * Object repository for Creating New Contact
 * @author Padmashree
 *
 */

public class CreatingNewContactsPage extends WebDriverUtility {
	
	// initialization
	public CreatingNewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//declaration of webelement
	@FindBy(name="lastname")
	private WebElement lastname;

	
	@FindBy(xpath="//td[text()='Organization Name 			']/following-sibling::td/img")
	private WebElement addOrganization;
	
	//for child window elements
	@FindBy(name="search_text")
	private WebElement searchOrganization;
	
	
	@FindBy(name="search")
	private WebElement searchButton;

	@FindBy(xpath="//b[text()='Contact Information']/preceding::input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	
	//getter methods 
	
	public WebElement getCreateNewContact() {
		return lastname;
	}

	public WebElement getAddOrganization() {
		return addOrganization;
	}
	
	public WebElement getSearchOrganization() {
		return searchOrganization;
	}


	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business logic 
	
	
	
	public void enterMandatoryFielldOfContact(WebDriver driver,String lastName,String orgName)
	{
		lastname.sendKeys(lastName);
		
		addOrganization.click();
		switchToWindow( driver, "Accounts");
		searchOrganization.sendKeys(orgName);
		searchButton.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver,"Contacts");
		
		saveButton.click();
		
		
	}
	
	
	
	
	
	
	
	
	

}
