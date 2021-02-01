package com.qa.gridizen.Pages;
   

	import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.qa.gridigen.base.TestBase;

	//import com.gridizen.qa.com.TestBase;

	public class LoginPage extends TestBase{
		@FindBy(xpath="//input[@name='username']")
		WebElement userName;
		@FindBy(xpath="//input[@name='password']")
		WebElement password;
		@FindBy(xpath="//button[@type='submit']")
		WebElement submit;
		@FindBy(xpath="//a[@href='/portal-panel/signup']")
		WebElement join;
		
		
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		public void clickJoin() {
		join.click();
		}
		public void LoginClick() {
			userName.sendKeys("anusha.berachah@gmail.com");
			password.sendKeys("Test@123");
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", submit);
			//submit.click();
		}
	}




