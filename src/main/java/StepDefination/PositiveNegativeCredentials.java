package StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;


public class PositiveNegativeCredentials {
	WebDriver driver;
   JavascriptExecutor js=(JavascriptExecutor)driver;
	

	@Given("^launch the browser and open the application$")
	public void launc_the_browser_and_open_the_application() {
		System.setProperty("webdriver.gecko.driver", "/Users/macbook/Desktop/drivers/geckodriver");
		driver=new FirefoxDriver();
		driver.get("https://portal.gridizen.co.uk/portal-panel/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}
	@When("^credentials are siven$")
	public void credentials_are_siven() {
		WebElement username=driver.findElement(By.name("username"));
		WebElement password=driver.findElement(By.name("password"));
		username.sendKeys("ac1.go@yopmail.com");
		password.sendKeys("Test@123");
	}
	@And ("^click on submit$")
	public void click_on_submit() {
		WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
	}
	@Then ("^verify actioncenter url$")
	public void verify_actioncenter_url() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals("https://portal.gridizen.co.uk/portal-panel/home", driver.getCurrentUrl());
	}
	@When("^valid \"(.*)\" is given and invalid \"(.*)\"$")
	public void valid_username_is_given_and_invalid_password(String username, String  password)   {
	    // Write code here that turns the phrase above into concrete actions
		WebElement username1=driver.findElement(By.name("username"));
		WebElement password1=driver.findElement(By.name("password"));
		username1.sendKeys(username);
		password1.sendKeys(password);
	}
	
	@Then("^verify the login \"(.*)\"$")
	public void verify_the_login_url(String url) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		Assert.assertEquals(url, driver.getCurrentUrl());

}
	@When ("^invalid \"(.*)\" is given and valid \"(.*)\"$")
	public void invalid_username_is_given_and_valid_password(String username, String  password) {
		WebElement username1=driver.findElement(By.name("username"));
		WebElement password1=driver.findElement(By.name("password"));
		username1.sendKeys(username);
		password1.sendKeys(password);
		
	}
	@When ("^invalid user name is given and invalid password$")
	public void invalid_user_name_is_given_and_invalid_password() {
		WebElement username=driver.findElement(By.name("username"));
		WebElement password=driver.findElement(By.name("password"));
		username.sendKeys("ac11.go@yopmail.com");
		password.sendKeys("Test@1234");
		
	}
	@When("^valid \"(.*)\" and \"([^\"]*)\"are given$")
	public void valid_and_are_given(String arg1, String arg2)  {
	    // Write code here that turns the phrase above into concrete actions
		WebElement username=driver.findElement(By.name("username"));
		WebElement password=driver.findElement(By.name("password"));
		username.sendKeys(arg1);
		password.sendKeys(arg2);
	    
	}

	@Then("^verify the login-one \"([^\"]*)\"$")
	public void verify_the_login_one(String arg1) throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		Assert.assertEquals(arg1, driver.getCurrentUrl());
	    
	}

}
