package com.crm.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object repository for Organization Information Page
 * @author Padmashree
 *
 */
public class OrganizationInformationPage {
//initialization 
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
// declaration
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement actualHeaderText;
	
	
// getter method
	
	public WebElement getHeaderText() {
		return actualHeaderText;
	}
	
	
	// Business Logic
	public String actualHeaderText()
	{
		
		
		return  actualHeaderText.getText();
		
	}
	


	
	
	
	
	
	
	

}
