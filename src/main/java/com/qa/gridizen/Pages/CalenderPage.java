package com.qa.gridizen.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.gridigen.base.TestBase;

public class CalenderPage extends TestBase {
	@FindBy(xpath="//button[@type='submit']//i[@class='gd gridicon-plus']")
	WebElement add;
	JavascriptExecutor js;

	public CalenderPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnAdd() {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", add);
	}
	
	
}
