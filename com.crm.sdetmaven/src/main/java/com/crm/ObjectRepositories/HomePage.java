package com.crm.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtilities.WebDriverUtility;
/**
 * Object Repository for Home page
 * @author Padmashree
 *
 */

public class HomePage extends WebDriverUtility {
//initialization of webelement
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	// declaration of webelement
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement mouseHover;
	
	@FindBy(linkText="Sign Out")
	private WebElement logOut;
	
	@FindBy(linkText = "Contacts")
	private  WebElement contactsLink;
	
	@FindBy(linkText = "Campaigns")
	private  WebElement campaignsLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreImage;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	
	
	
	
	
	
	

// getter method 
	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}
	
	public WebElement getContactsLink() {
		return contactsLink;
	}
	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	
	
	public WebElement getLogOut() {
		return logOut;
	}

	public WebElement getMoreImage() {
		return moreImage;
	}

	public WebElement getMouseHover() {
		return mouseHover;
	}


	
	

	public WebElement getProductLink() {
		return productLink;
	}
			

	public WebElement getLeadsLink() {
		return leadsLink;
	}
	

	// businesss logic for organization link
	public void clickOnOrganizationLink()
	{
		OrganizationsLink.click();
	}
	
	
		public void contactsLink(WebDriver driver)
		{
			contactsLink.click();
		}
		
		
	
	public void logout(WebDriver driver)
	{
	
		mouseOver(driver, mouseHover);
		logOut.click();
		
	}
	
	public void moreImage(WebDriver driver)
	{
		mouseOver(driver,moreImage);
		
	}
	
	public void campaignsLink(WebDriver driver)
	{
		campaignsLink.click();
	}
	
	public void productsLink(WebDriver driver)
	{
		productLink.click();
	}
	
	public void leadLink()
	{
		leadsLink.click();
	}
	
	
	

}
