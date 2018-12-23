package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[@class='headertext']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement taskLink;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	public boolean verifyUser()
	{
		return userNameLabel.isDisplayed();
		
	}
	public ContactPage clickOnContactLink()
	{
		
	contactsLink.click();
	return new ContactPage();
		
	}
	
	public DealsPage dealLinks()
	{
		dealsLink.click();
	return new DealsPage();
		
	}
	
	public TaskPage tasklink()
	{
		taskLink.click();
		return new TaskPage();
	}
	public void clickOnNewContactLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
		
	}
	

}
