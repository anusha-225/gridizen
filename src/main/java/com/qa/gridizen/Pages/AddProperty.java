package com.qa.gridizen.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.gridigen.base.TestBase;

public class AddProperty extends TestBase {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public static Boolean a;
	public static Boolean roomDetails1;

	@FindBy(xpath="//input[@ng-reflect-name='propertyTitle']")
	WebElement propertyTitle;
	@FindBy(xpath="//input[@ng-reflect-name='postcode']")
	WebElement postcode;
	@FindBy(xpath="//input[@ng-reflect-name='address']")
	WebElement address;
	@FindBy(xpath="//mat-option[@tabindex='0']")
	WebElement address1;
	@FindBy(xpath="//*[contains(text(),' Occupied ')]")
	WebElement  occupied ;
	@FindBy(xpath="//input[@ng-reflect-name='rentalAmount']")
	WebElement rentalAmount;
	@FindBy(xpath="//mat-select[@name='rentFrequency']")
	WebElement rentFrequency;
	@FindBy(xpath="//mat-option[@ng-reflect-value='MONTHLY']")
	WebElement monthly;
	@FindBy(xpath="//input[@ng-reflect-name='endDate']")
	WebElement endDate;
	@FindBy(xpath="//div[@class='mat-calendar-content']//table[@class='mat-calendar-table']//tr//*[contains(text(),'12')]")
	WebElement endDateValue;
	@FindBy(xpath="//div[@class='mat-calendar-header']//button[@aria-label='Next month']")
	WebElement nextMonth;
	@FindBy(xpath="//mat-select[@ng-reflect-name='Title_0']")
	WebElement title;
	@FindBy(xpath="//mat-option[@ng-reflect-value='Mr']")
	WebElement title1;
	@FindBy(xpath="//input[@ng-reflect-placeholder='First Name']")
	WebElement firstName;
	@FindBy(xpath="//input[@ng-reflect-placeholder='Last Name']")
	WebElement lastName;
	@FindBy(xpath="//input[@type='email']")
	WebElement email;
	@FindBy(xpath="//input[@ng-reflect-placeholder='Mobile']")
	WebElement Mobile;
	@FindBy(xpath="//input[@ng-reflect-name='nextRentDate']")
	WebElement nextRentDate;
	@FindBy(xpath="//button[@aria-label='Next month']")
	WebElement nextRentDateMonth;
	@FindBy(xpath="//div[@class='mat-calendar-content']//table[@class='mat-calendar-table']//tr//*[contains(text(),'1')]")
	WebElement nextRentDateValue;
    @FindBy(xpath="//*[text()='Add Property']")
    WebElement addProperty;
    @FindBy(xpath="//div[text()=' Existing ']")
    WebElement existing;
    @FindBy(xpath="//div[text()=' HMO ']")
    WebElement hmo;
    @FindBy(xpath="//div[text()='ROOM DETAILS']")
    WebElement roomDetails;
	public AddProperty() {
		PageFactory.initElements(driver, this);
	}
	public void addData(String propertyTitle1, String postCode1, String rentAmount1,  String firstName1, String lastName1, String email1, long mobile2) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	   propertyTitle.sendKeys(propertyTitle1);
		postcode.sendKeys(postCode1);
		address.sendKeys("23");
		Thread.sleep(1000);
		address1.click();
		Thread.sleep(1000);
		occupied.click();
		rentalAmount.sendKeys(rentAmount1);
		rentFrequency.click();
		Thread.sleep(1000);
		monthly.click();
		endDate.click();
		nextMonth.click();
		endDateValue.click();
		occupied.click();
		title.click();
		Thread.sleep(1000);
		title1.click();
		firstName.sendKeys(firstName1);
		lastName.sendKeys(lastName1);
		email.sendKeys(email1);
		Mobile.sendKeys(String.valueOf(mobile2));
		js.executeScript("arguments[0].click();", nextRentDate);
		Thread.sleep(1000);
		nextRentDateMonth.click();
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", nextRentDateValue);
		Thread.sleep(1000);
		addProperty.click();
		
	}
	public void clickOnExisting() {
	 a=propertyTitle.isEnabled();
	}
	public void clickHmo() {
		hmo.click();
		roomDetails1=roomDetails.isEnabled();
	}
}
