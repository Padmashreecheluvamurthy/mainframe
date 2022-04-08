package com.crm.ObjectRepositories;
/**
 * Object repository for Products  Page
 * @author Padmashree
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
// initialization
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//Declaration
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement productAddIcon;

	//getter
	public WebElement getProductAddIcon() {
		return productAddIcon;
	}
	
	//business logic
	public void ProductaddIcon(WebDriver driver)
	{
		productAddIcon.click();
	}
	
	
	
	
}

