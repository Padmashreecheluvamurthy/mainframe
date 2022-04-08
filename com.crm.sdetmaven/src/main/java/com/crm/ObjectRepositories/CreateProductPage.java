package com.crm.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtilities.WebDriverUtility;
/**
 * Object Repository for Create Product
 * @author Padmashree
 *
 */
public class CreateProductPage extends WebDriverUtility{
//initialization
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declaration
	@FindBy(name="productname")
	private WebElement productName;
	
	@FindBy(xpath="//b[text()='Product Information']/preceding::input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreImage;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	
	//getter 
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	public WebElement getMoreImage() {
		return moreImage;
	}
	
	

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	//business logic
	public void createProduct(WebDriver driver, String productname)
	{
		productName.sendKeys(productname);
		saveButton.click();
		
	}
	public void moreImage(WebDriver driver)
	{
		mouseOver(driver,moreImage);
	}
	
	
	public void campaignsLink(WebDriver driver)
	{
		campaignsLink.click();
	}
	
	
	
}
