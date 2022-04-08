package com.crm.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object Repository for Leads page to click on add icon 
 * @author Padmashree
 *
 */
public class LeadsPage {
//initialization
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
// declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private  WebElement leadsAddIcon;
	
	
	
	// getter methods
	public WebElement getLeadsAddIcon() {
		return leadsAddIcon;
	}
	
	
	//business logic
	
	public void addIconClick()
	{
		leadsAddIcon.click();
	}
	
}
