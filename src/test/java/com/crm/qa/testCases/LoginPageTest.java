package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest  extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	
	LoginPageTest()
	{
		super();
	}
	
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage=new LoginPage();
		
	}
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		
	}
	@Test(priority=2)
	public void crmLogoTest()
	{
		boolean flag=loginpage.validateImage();
		Assert.assertTrue(flag);
		
	}
	@Test(priority=3)
	public void loginTest() throws InterruptedException 
	{
		// here how can i used prop variable we are not defining property prop in this class 
		//why bcoz we inherit also property of property class we declared inside base class
		//below method return homepage object,,,so we declared at class level Homepage homepage 
		homepage=loginpage.login(prop.getProperty("uname"),prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
