package com.qa.gridizen.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.gridigen.base.TestBase;

public class MaintenancePage extends TestBase {
	WebDriverWait wait=new WebDriverWait(driver, 2);
	Boolean explicitwait;
	@FindBy(xpath="//button[@type='submit']")
	WebElement addIssue;

	
	public MaintenancePage() {
		PageFactory.initElements(driver, this);
	}
	public void clickOnAdd() {
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click;", addIssue);
		addIssue.click();
	}
	public static String text;
	public void verifyTable() throws InterruptedException {
		
		List <WebElement> column=driver.findElements(By.xpath("//table[@class='gridizen-table ml-container-table mat-table ng-star-inserted']/thead//tr/th"));
		//explicitwait=wait.until(ExpectedConditions.attributeContains(row, attribute, value));
		WebElement row=driver.findElement(By.xpath("//table[@class='gridizen-table ml-container-table mat-table ng-star-inserted']//tbody//tr//td[1]//a"));
		Thread.sleep(2000);
		text=driver.findElement(By.xpath("//table[@class='gridizen-table ml-container-table mat-table ng-star-inserted']//tbody//tr//td[1]//a")).getText();
		 System.out.println(text);
	}
}
