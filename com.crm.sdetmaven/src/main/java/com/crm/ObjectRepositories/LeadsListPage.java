package com.crm.ObjectRepositories;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * object repository for leads list page
 * @author Padmashree
 *
 */
public class LeadsListPage {
// initialization
	
	 public LeadsListPage(WebDriver driver) 
	 { 
		 PageFactory.initElements(driver,this);
	 }
	 
	 
	
	
// declaration
	@FindBy(xpath="//div[@id='basicsearchcolumns_real']/child::select[@id='bas_searchfield']")
	private WebElement inSearch;
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchFor;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchButton;
	
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[2]")
	private List<WebElement> leadlist;
	
	//getter methods

	public WebElement getInSearch() {
		return inSearch;
	}

	public WebElement getSearchFor() {
		return searchFor;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	
	
	public List<WebElement> getLeadlist() {
		return leadlist;
	}
    
	
		//Business logic
	public void searchInLeadsList(String leadNum) throws Throwable
	{
		searchFor.sendKeys(leadNum);
	
		searchButton.click();
		Thread.sleep(5000);
		
	}
	
	
	
	
		
		
			
			
			
		}
	
	
	



