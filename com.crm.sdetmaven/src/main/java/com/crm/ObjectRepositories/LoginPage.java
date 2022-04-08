package com.crm.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object repository for login page
 * @author Padmashree
 *
 */


public class LoginPage {
	
	
	//initialization of webelement using pageFactory
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//Declaration of Webelement using annotation
	@FindBy(name="user_name")
	private WebElement usernameTextField;
	
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//providing getter methods

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//create business logic
	
	public void login(String username,String password)
	{
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
