package com.qa.gridizen.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.gridigen.base.TestBase;

public class AddMaintenance extends TestBase {
	public static JavascriptExecutor js;
	//String one="//mat-option[@ng-reflect-value='Alarm & Smoke Detectors']";
	@FindBy(xpath="//input[@name='s1electedIssueType']")
	WebElement s1electedIssueType;
	//@FindBy(xpath=one)
	//WebElement alaram;
	@FindBy(xpath="//textarea[@name='description']")
	WebElement textarea;
	@FindBy(xpath="//mat-select[@name='category']")
	WebElement category;
	@FindBy(xpath="//mat-option[@ng-reflect-value='Carpenters']")
	WebElement Carpenters;
	@FindBy(xpath="//input[@name='property']")
	WebElement property;
	@FindBy(xpath="//span[text()='aa1']")
	WebElement address;
	@FindBy(xpath="//span[text()=' Add Issue ']")
	WebElement addIssue;
	public AddMaintenance() {
		PageFactory.initElements(driver, this);
	}
	public void enterData(String discription, String one, String selectCategory) throws InterruptedException {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", s1electedIssueType);
		Thread.sleep(1000);
		driver.findElement(By.xpath(one)).click();
		//alaram.click();
		textarea.sendKeys(discription);
		category.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(selectCategory)).click();
		property.sendKeys("23");
		Thread.sleep(1000);
		address.click();
		addIssue.click();
	}
}
