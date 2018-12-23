package com.crm.qa.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest  extends TestBase{
	LoginPage login;
	HomePage homepage;
	TestUtil util;
	ContactPage contactsPage;
	DealsPage dealPage;
	TaskPage taskPage;
	
	
	
	public HomePageTest()
	{
		super();	
	}
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		
		initialization();
		util=new TestUtil();
		
		 contactsPage =new ContactPage();
		login=new LoginPage();
		login.login(prop.getProperty("uname"), prop.getProperty("password"));
		
		homepage=new HomePage();
		 contactsPage =new ContactPage();
		 dealPage=new DealsPage();
		 taskPage=new TaskPage();
	}
	
	@Test(priority=1)
	public void vrifyHomePageTitlePageTest()
	{
		System.out.println(1);
	String hTitle=homepage.verifyHomePageTitle();
	System.out.println(hTitle);
	Assert.assertEquals(hTitle, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyUserLabel()
	{
		util.switchToFrame();
		boolean bool=homepage.verifyUser();
		Assert.assertTrue(bool);
	}
	
	@Test(priority=3)
	public void clickingOnContactlinkTest()
	{	util.switchToFrame();
		contactsPage=homepage.clickOnContactLink();
	}
	@Test(priority=4)
	public void clickingOnDealLinkTest()
	{
		util.switchToFrame();
		dealPage=homepage.dealLinks();
		
	}
	@Test(priority=5)
	public void clickingOnTaskLink()
	{
		util.switchToFrame();
	taskPage=homepage.tasklink();
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
