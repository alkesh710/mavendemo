package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
// //input[@name='client_lookup']//
public class ContactPage extends TestBase {
	// td[@class='datacardtitle' and contains(text(),'Contacts')]
	@FindBy(xpath = "//*[@id=\"vContactsForm\"]/table/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement contactsLabel;

	@FindBy(xpath = "//td[@class='datatitle']//input[@type='checkbox']")
	WebElement checkbox;
	
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
@FindBy(name="client_lookup")
WebElement companyy;
	
	@FindBy(xpath=".//input[@value=\"Load From Company\"]//following::input[1]")
	WebElement saveBtn;
  
   
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactLabel() {
		return contactsLabel.isDisplayed();
	}

	public void selectContactCkeckBox() {
		checkbox.click();
		// return checkbox.isSelected();
		


	}
	public void createNewContact(String title,String fname,String lname,String company)
	{
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByValue(title);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		companyy.sendKeys(company);
		
	     saveBtn.click();
		
		
		
		
	}

}
