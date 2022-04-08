package com.crm.ObjectRepositories;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtilities.WebDriverUtility;
/**
 * Object repository to create campaign page
 * @author Padmashree
 *
 */
public class CreateCampaignPage extends WebDriverUtility {
// initialization
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
// declaration
	@FindBy(name="campaignname")
	private WebElement campaignName;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement productIcon;
	
	@FindBy(xpath="//b[text()='Campaign Information']/preceding::input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="search_text")
	private WebElement searchProduct;
	
	@FindBy(name="search_text")
	private WebElement searchButton;
	
	
	@FindBy(id="1")
	private WebElement selectProduct;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement waitForElement;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addIcon;
	
	

	
//getter methods
	
	public WebElement getCampaignName() {
		return campaignName;
	}
	


	public WebElement getSaveButton() {
		return saveButton;
	}


	public WebElement getProductIcon() {
		return productIcon;
	}
	
	public WebElement getSearchOrganization() {
		return searchProduct;
	}


	public WebElement getSearchButton() {
		return searchButton;
	}
	
	
	
	public WebElement getSelectProduct() {
		return selectProduct;
	}



	public WebElement getSearchProduct() {
		return searchProduct;
	}



	public WebElement getWaitForElement() {
		return waitForElement;
	}



	public WebElement getAddIcon() {
		return addIcon;
	}



	//business logic
	public void createCampaigns(WebDriver driver,String campaignname, String productName)
	{
		addIcon.click();
		campaignName.sendKeys(campaignname);
		productIcon.click();
		switchToWindow( driver, "Products");
		searchProduct.sendKeys(productName);
		searchButton.click();
		selectProduct.click();
		//driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		switchToWindow(driver,"Campaigns");
		
		
		saveButton.click();
		
	}
	
	public void waitforElement(WebDriver driver)
	{
		waitForElementVisibility(driver, waitForElement);	
	}
	
	
}
