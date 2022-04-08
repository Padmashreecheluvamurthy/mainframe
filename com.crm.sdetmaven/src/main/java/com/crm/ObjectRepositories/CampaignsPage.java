package com.crm.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object Repository for campaigns add icon image
 * @author Padmashree
 *
 */
public class CampaignsPage {
// initialization
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
// declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addIcon;

	
	
	
	
	//getter
	public WebElement getAddIcon() {
		return addIcon;
	}
	
	
	//business logic
	/**
	 * methos used to click on add icon image
	 * @param driver
	 */
	public void campaignsAddIcon(WebDriver driver)

	{
		addIcon.click();
	}
}

