package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	
	LoginPage login;
	HomePage homepage;
	TestUtil util;
	DealsPage dealPage;
	TaskPage taskPage;
	
	ContactPage contactPage;
	public static String sheetname="contact";
	
	public ContactPageTest()
	{
		super();
		
	}
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		util=new TestUtil();
		
		contactPage =new ContactPage();
		login=new LoginPage();
		login.login(prop.getProperty("uname"), prop.getProperty("password"));
		
		homepage=new HomePage();
	    dealPage=new DealsPage();
		 taskPage=new TaskPage();
		 
		 util.switchToFrame();
		 //why we used this line becoz now i want to click to contact link and contact link present on homepage and now want to click
		 //contact link and it will give you contact page return type contactpage,,,,and want to click to contact page
		 //but contact page present in another frame so we want to switch the frame by using utils class
		 contactPage=homepage.clickOnContactLink();
		 
		 
		
	}
	
	
	/*@Test(priority=1)
	public void checkingContactLabelTest()
	{
	boolean lable=contactPage.verifyContactLabel();
	Assert.assertTrue(lable);	
	}
	
	@Test(priority=2)
	public void contactCheckingTest()
	{
		 contactPage.selectContactCkeckBox();
		
	}*/
/*	
	@DataProvider(name="alkesh")
	public void getCRMTestData() 
	{
		try {
		TestUtil.getData(sheetname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/
	
	@Test//(priority=3,dataProvider="alkesh")
	public void validateCreateNewContact()
	{//homepage
		homepage.clickOnNewContactLink();
		contactPage.createNewContact("Mr.","amol","devmadgu","alsis");
	}
	

	
@AfterMethod
public void tearDown()
{
	// driver.quit();
}
	

}
