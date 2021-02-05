package StepDefination;

import java.util.List;
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

public class AddCostStep {
	
	WebDriver driver;
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	@Given("^launch the browser open the application$")
	public void launch_the_browser_open_the_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver", "/Users/macbook/Desktop/drivers/geckodriver");
		driver=new FirefoxDriver();
		driver.get("https://portal.gridizen.co.uk/portal-panel/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		String classname=this.getClass().getSimpleName();
	   System.out.println(classname);
	    
	}
	@Given("^enter the credentials$")
	public void enter_the_credentials() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement username=driver.findElement(By.name("username"));
		WebElement password=driver.findElement(By.name("password"));
		username.sendKeys("cron.go@yopmail.com");
		password.sendKeys("Test@123");
		WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
	}
@Given("^click on finance$")
public void click_on_finance()  {
    // Write code here that turns the phrase above into concrete actions
	WebElement finance=driver.findElement(By.xpath("//a[@href='/portal-panel/finance']"));
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", finance);
}

@Given("^click on add$")
public void click_on_add() throws InterruptedException  {
    // Write code here that turns the phrase above into concrete actions
	Thread.sleep(2000);
	WebElement add=driver.findElement(By.xpath("//button[@type='button']//span[text()='ADD']"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", add);
}

@When("^enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
public void enter_the(String arg1, String arg2, String arg3)  {
    // Write code here that turns the phrase above into concrete actions
	WebElement money=driver.findElement(By.xpath("//input[@name='amount']"));
	WebElement card=driver.findElement(By.xpath("//mat-select[@name='cardsDropdown']"));
	//WebElement cvv=driver.findElement(By.xpath("//button[text()='ADD']']"));
	money.sendKeys(arg1);
	card.click();
	List<WebElement> list=driver.findElements(By.xpath("//div[@class='cdk-overlay-pane']//mat-option[@role='option']"));
	System.out.println(list.size());
	for(int i=0;i<list.size();i++) {
		if(list.get(i).getText().equals("497248XXXXXX0049")) {
			list.get(i).click();
			break;
		}
	}
	WebElement cvv=driver.findElement(By.xpath("//input[@name='cvv']"));
	cvv.sendKeys(arg3);
}
WebElement amount;
@When("^click on topup$")
public void click_on_topup() throws InterruptedException  {
    // Write code here that turns the phrase above into concrete actions
	WebElement topup=driver.findElement(By.xpath("//button[@class='mat-flat-button formvalid']//span[text()='TOPUP']"));
	topup.click();
 //Thread.sleep(2000);
 amount=driver.findElement(By.xpath("//div[@class='fin-body-section-main-body-amount']"));
}



@Then("^Amount should be added in the wallet \"([^\"]*)\" \"([^\"]*)\"$")
public void amount_should_be_added_in_the_wallet(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	String displayAmount=	amount.getText();
	System.out.println(displayAmount);
	String mainValue=displayAmount.substring(1, displayAmount.indexOf("."));
	String mainValue1=mainValue.replace(",", "");
	int convert=Integer.parseInt(mainValue1);
	int mainValue2=convert+arg2;
	Thread.sleep(2000);
	String displayAmount1=	amount.getText();
	String mainValue3=displayAmount1.substring(1, displayAmount.indexOf("."));
	 String mainValue4=mainValue3.replace(",", "");
	 int mainValue5=Integer.parseInt(mainValue4);
	//Assert.assertEquals(mainValue2, mainValue4);
	Assert.assertEquals(mainValue2, mainValue5);
}
}
