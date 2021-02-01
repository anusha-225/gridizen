package com.qa.gridizen.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.gridigen.base.TestBase;

public class Properties extends TestBase {
	public static String a;

	@FindBy(xpath="//button[@type='submit']//span[text()='Add Property']")
	WebElement addProperty;
	@FindBy(xpath="//table//tr[1]//td[3]")
	WebElement propertyList;
	public Properties() {
		PageFactory.initElements(driver, this);
	}
	public void clickOnAddProperty() throws InterruptedException {
		Thread.sleep(2000);
		addProperty.click();
	}
	
	public void getPropertyListText() throws InterruptedException {
		Thread.sleep(2000);
	   a=propertyList.getText();
	}
	
}
