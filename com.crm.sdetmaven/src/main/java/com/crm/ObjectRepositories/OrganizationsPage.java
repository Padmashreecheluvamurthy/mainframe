package com.crm.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object repository for organization page 
 * @author Padmashree
 *
 */
public class OrganizationsPage {
// initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	// declaration 
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addIconimage;


// getter method 

	public WebElement getAddIconimage() {
		return addIconimage;
	}
	
	//business logic
	/**
	 * this method is used to click on add icon for creating organization
	 */
	
	public void clickOnAddIconImageForOrganization()
	{
		addIconimage.click();
	}
}
