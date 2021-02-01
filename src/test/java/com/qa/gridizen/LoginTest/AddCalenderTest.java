package com.qa.gridizen.LoginTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.gridigen.base.TestBase;
import com.qa.gridizen.Pages.ActionCenter;
import com.qa.gridizen.Pages.AddCalender;
import com.qa.gridizen.Pages.AddMaintenance;
import com.qa.gridizen.Pages.CalenderPage;
import com.qa.gridizen.Pages.LoginPage;
import com.qa.gridizen.Pages.MaintenancePage;
import com.qa.gridizen.Pages.Properties;
import com.qa.gridizen.util.TestUtil;

public class AddCalenderTest extends TestBase {
	
		    public static LoginPage loginPage1;
			public static ActionCenter actionCenter;
			public static AddMaintenance addMaintenance;
			public static MaintenancePage maintenancepage;
			public static CalenderPage calenderPage;
			public static AddCalender addCalender;
			ExtentHtmlReporter reporter=new ExtentHtmlReporter("/Users/macbook/eclipse-workspace/gridigen-1/ExtentReports/AddCalenderTest.html");
			ExtentReports extent=new ExtentReports();
			ExtentTest test1;
			public static String screenShot(String methodName ) throws IOException {
				TakesScreenshot ts=(TakesScreenshot)driver;
		    	File src=ts.getScreenshotAs(OutputType.FILE);
		    	String path1="/Users/macbook/eclipse-workspace/gridigen-1/images/"+"AddCalendertest"+methodName+".png";
		    	File des=new File(path1);
		    	FileUtils.copyFile(src, des);
		    	return path1;
		    	
			}
			@DataProvider
			public Object[][] data() throws FileNotFoundException {
				addCalender=new AddCalender();
				Object[][] data=addCalender.addCalenderData();
				return data;
			}
			@BeforeMethod
			public void beforeMethod() throws IOException {
				intialiszation();
				loginPage1=new LoginPage();
				loginPage1.LoginClick();
				actionCenter=new ActionCenter();
				addMaintenance= new AddMaintenance();
				calenderPage=new CalenderPage();
				addCalender=new AddCalender();
				extent.attachReporter(reporter);
				actionCenter.clickCalender();
				calenderPage.clickOnAdd();
				
			}
			@Test(dataProvider="data")
			public void one(String eventName, String Description, String category) throws InterruptedException, FileNotFoundException {
				test1=extent.createTest("one");
				addCalender.select1(eventName, Description, category);
				Thread.sleep(2000);
				String url=driver.getCurrentUrl();
				Assert.assertEquals("http://portal-qa.gridizen.co.uk/portal-panel/calendar", url);
			}
			@AfterMethod
			public void afterMethod(ITestResult result) throws IOException {
				if(result.getStatus()==ITestResult.FAILURE) {
					String path=AddCalenderTest.screenShot(result.getName());
					test1.addScreenCaptureFromPath(path);
					test1.log(Status.FAIL, result.getName());
				}else if(result.getStatus()==ITestResult.SUCCESS) {
					test1.log(Status.PASS, result.getName());
				}
				else if(result.getStatus()==ITestResult.SKIP) {
					test1.log(Status.SKIP, result.getName());
				}
				extent.flush();
				driver.quit();
			}
		
		
			
}
