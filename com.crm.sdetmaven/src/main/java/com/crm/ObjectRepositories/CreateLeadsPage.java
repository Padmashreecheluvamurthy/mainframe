package com.crm.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtilities.WebDriverUtility;

/**
 * object repository for Create leads page
 * @author Padmashree
 *
 */
public class CreateLeadsPage extends WebDriverUtility{
// initialization
	public CreateLeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
// declaration
	
	
	@FindBy(name="firstname")
	private WebElement firstNameTextField;
	
	@FindBy(name="lastname")
	private WebElement lastNameTextField;
	
	@FindBy(name="company")
	private WebElement companyNameTextField;
	
	@FindBy(id="designation")
	private WebElement titleTextField;
	
	
	@FindBy(xpath="//b[text()='Lead Information']/preceding::input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="leadstatus")
	private WebElement leadstatusDropDown;
	
	@FindBy(name="rating")
	private WebElement ratingDropDown;

// getter methods
	
	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}


	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}


	public WebElement getCompanyNameTextField() {
		return companyNameTextField;
	}


	public WebElement getTitleTextField() {
		return titleTextField;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
public WebElement getLeadstatusDropDown() {
		return leadstatusDropDown;
	}

public WebElement getRatingDropDown() {
	return ratingDropDown;
}

	// business logic
	public void createLeadsAndLeadsStatus(String firstname, String lastname, String compName,String dropDownValue)
	{
		firstNameTextField.sendKeys(firstname);
		lastNameTextField.sendKeys(lastname);
		companyNameTextField.sendKeys(compName);
		select(leadstatusDropDown, dropDownValue);
		saveButton.click();
	}
		
	public void createLeadsAndRating(String firstname, String lastname,String compName, String dropDownValue)
	{
		firstNameTextField.sendKeys(firstname);
		lastNameTextField.sendKeys(lastname);
		companyNameTextField.sendKeys(compName);
		select(ratingDropDown, dropDownValue);
		saveButton.click();
	}
}
