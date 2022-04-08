package com.crm.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtilities.WebDriverUtility;
/**
 * Object repository for Create Organizations page
 * @author Padmashree
 *
 */

public class CreateNewOrganizationPage extends WebDriverUtility {
// initialization 
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	// declaration
	@FindBy(name="accountname")
	private WebElement organizationNameTextField;
	
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath="//td[text()='Organization Name 			']/ancestor::table[@class='small']"
			+ "/descendant::div[@align='center']/input[@title='Save [Alt+S]']")
				private WebElement saveButton;

	//getter method
	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	//business logic
	/**
	 * This method will create organization and select industry and save button
	 * @param organizationName
	 * @param dropDownValue
	 */
	public void createOrganization(String organizationName, String dropDownValue)
	{
		organizationNameTextField.sendKeys(organizationName);
		select(industryDropDown, dropDownValue);
		
		saveButton.click();
	}
	
	 public void createOrg(String organizationName)
	 {
		 organizationNameTextField.sendKeys(organizationName);
		 saveButton.click();
	 }
	
					
	
	
}
