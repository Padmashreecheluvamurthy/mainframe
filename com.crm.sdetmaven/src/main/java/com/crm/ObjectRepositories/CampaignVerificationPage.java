package com.crm.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Object repository for campaign verification page
 * @author Padmashree
 *
 */
public class CampaignVerificationPage {

	public CampaignVerificationPage(WebDriver driver)
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
	/**
	 * method used to get headertext in information page
	 * @param driver
	 * @return String
	 */
	public String headerinfo(WebDriver driver)
	{
		return headerInfo.getText();
		
	}
	

}
