package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//page factory :OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[3]//a[contains(text(),'Sign')]")
	WebElement signUp;
	
	@FindBy(xpath="//img[@alt='free crm logo']")
	WebElement logo;
	
	//now we are initializing page factory
	public LoginPage()
	{
	PageFactory.initElements(driver, this);
	}
	
	//this are Actions//means features available on page
	
	//this method validate pagetitle
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	//this method validate logo
	public Boolean validateImage()
	{
		return logo.isDisplayed();
	}
	//this method send uname and passsword
	public HomePage login(String un,String pass)throws InterruptedException
	{
		
		username.sendKeys(un);
		password.sendKeys(pass);
        Thread.sleep(2000);
		loginBtn.click();
		
		
		return new HomePage();//why i am returning homepage bcoz while  clicking on click button it will redirected to homepage
	//we have done here on this class ,,,,now we are created test cases for this class test cases in com.crm.qa.testCases package
	
	}

}
