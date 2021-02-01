package com.qa.gridizen.LoginTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.qa.gridizen.Pages.AddMaintenance;
import com.qa.gridizen.Pages.AddProperty;
import com.qa.gridizen.Pages.LoginPage;
import com.qa.gridizen.Pages.MaintenancePage;
import com.qa.gridizen.Pages.Properties;
import com.qa.gridizen.util.TestUtil;

public class AddPropertyTest extends TestBase{
	public static LoginPage loginPage1;
	public static ActionCenter actionCenter;
	public static AddMaintenance addMaintenance;
	public static MaintenancePage maintenancepage;
	AddProperty property;
	Properties properties;
	ExtentHtmlReporter reporter=new ExtentHtmlReporter("/Users/macbook/eclipse-workspace/gridigen-1/ExtentReports/AddPropertyTest.html");
	ExtentReports extent=new ExtentReports();
	ExtentTest test1;
	TestUtil util;
	public static String screenShot(String methodName ) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
    	File src=ts.getScreenshotAs(OutputType.FILE);
    	String path1="/Users/macbook/eclipse-workspace/gridigen-1/images/"+methodName+System.currentTimeMillis()+".png";
    	File des=new File(path1);
    	FileUtils.copyFile(src, des);
    	return path1;
    	
	}
	@DataProvider
	public Object[][] addPropertyDetails(){
		util=new TestUtil();
		Object[][] data=util.addPropertyData();
		return data;
		
	}
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {
		intialiszation();
		loginPage1=new LoginPage();
		loginPage1.LoginClick();
		actionCenter=new ActionCenter();
		addMaintenance= new AddMaintenance();
		property=new AddProperty();
		properties=new Properties();
		extent.attachReporter(reporter);
		actionCenter.clickProperties();
		properties.clickOnAddProperty();
	}
	@Test(dataProvider="addPropertyDetails")
	public void addpropertyData(String propertyTitle, String postCode, String rentAmount,  String firstName, String lastName, String email, long mobile) throws InterruptedException {
		test1=extent.createTest("addData");
		property.addData(propertyTitle, postCode, rentAmount, firstName, lastName, email, mobile);
		String combineText=firstName +" "+lastName;
		properties.getPropertyListText();
		Thread.sleep(4000);
		Assert.assertEquals(Properties.a, combineText);
		//Assert.assertTrue(false);
	}
	
	@Test
	public void one() throws InterruptedException {
	    test1=extent.createTest("one");
		property.clickOnExisting();
		Boolean b=property.a;
		Boolean a=true;
		System.out.print(b);
		Assert.assertEquals(a, b);
	}
	@Test
	public void clickOnHmo() {
		property.clickHmo();
		property.clickHmo();
		Boolean b=property.roomDetails1;
		Boolean a=true;
		Assert.assertEquals(a, b);
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			String path=screenShot(result.getName());
			test1.addScreenCaptureFromPath(path);
			test1.log(Status.FAIL, result.getName());
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			test1.log(Status.PASS, result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test1.log(Status.SKIP, result.getName());
		}
		extent.flush();
		//driver.quit();
	}
	

}
