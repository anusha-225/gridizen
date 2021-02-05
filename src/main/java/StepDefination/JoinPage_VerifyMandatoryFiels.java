package StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class JoinPage_VerifyMandatoryFiels {
	WebDriver driver;
	
	@Given("^launch the firefox browser and open the application$")
	public void launch_the_firefox_browser_and_open_the_application() {
		System.setProperty("webdriver.gecko.driver", "/Users/macbook/Desktop/drivers/geckodriver");
		driver=new FirefoxDriver();
		driver.get("https://portal.gridizen.co.uk/portal-panel/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}
	@When("^click on join$")
	public void click_on_join()  {
	    WebElement join=driver.findElement(By.xpath("//a[@href='/portal-panel/signup']"));
	    join.click();   
	}
	@When("^fill some of the mandatory values$")
	public void fill_some_of_the_mandatory_values()  {
	    // Write code here that turns the phrase above into concrete actions
		WebElement organisationName= driver.findElement(By.xpath("//input[@name='business_name']"));
		WebElement organaistionType= driver.findElement(By.xpath("//mat-select[@name='Title']"));
		WebElement firstName= driver.findElement(By.xpath("//input[@name='first_name']"));
		organisationName.sendKeys("anugraha");
		firstName.sendKeys("anusjha");
	}
	@Then("^verify submit button$")
	public void verify_submit_button()  {
	    // Write code here that turns the phrase above into concrete actions
		WebElement submit= driver.findElement(By.xpath("//button[@type='submit']"));
		Boolean a=submit.isEnabled();
		WebElement email= driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("vuhuh");
		WebElement mobile= driver.findElement(By.xpath("//input[@name='mobile_num']"));
		mobile.click();
		WebElement div=driver.findElement(By.xpath("//*[@id='mat-error-0']"));
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].getText();", div);
		String c=div.getText();
		System.out.println(c);
		Boolean b=false;
		Assert.assertEquals(b, a);
	}	
}
