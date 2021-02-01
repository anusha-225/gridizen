package com.qa.gridizen.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.gridigen.base.TestBase;

public class ActionCenter extends TestBase {

	@FindBy(xpath="//a[@href='/portal-panel/properties']")
	WebElement properties;
	@FindBy(xpath="//a[@href='/portal-panel/calendar']")
	WebElement calender;
	@FindBy(xpath="//a[@href='/portal-panel/maintenance']")
	WebElement maintenance;
	public ActionCenter() {
		PageFactory.initElements(driver, this);
	}
	public void clickProperties() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", properties);
	}
	public void clickCalender() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", calender);
	}
	public void clickOnMaintenance() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", maintenance);
	}
}
