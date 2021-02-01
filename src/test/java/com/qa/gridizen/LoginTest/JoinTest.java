package com.qa.gridizen.LoginTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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
import com.qa.gridizen.Pages.Join;
import com.qa.gridizen.Pages.LoginPage;
import com.qa.gridizen.util.TestUtil;

public class JoinTest extends TestBase {
	public static LoginPage loginPage1;
	public ExtentHtmlReporter reporter=new ExtentHtmlReporter("/Users/macbook/eclipse-workspace/gridigen-1/ExtentReports/JoinTest.html");
	public ExtentReports extent=new ExtentReports();
	public ExtentTest test;
	public static TestUtil testUtil;
   public  String className=this.getClass().getSimpleName();
 //  public static Join join;
   @DataProvider
   public Object[][] addDataJoin() throws IOException   {
	 Join join=new Join();
	   Object[][] data1=join.excelAddData();
		return data1;
   }
	@BeforeMethod
	public void beforeMethod() throws IOException{
		intialiszation();
		loginPage1=new LoginPage();
		testUtil=new TestUtil();
		//loginPage1.clickJoin();
		extent.attachReporter(reporter);
	}
	@Test(dataProvider="addDataJoin")
	public void addData(String organisationName, String organaisationType, String title, String firstname, String lastName,  String email,long num, String password, String cpassword ) {
		test=extent.createTest("addData");
		System.out.println(cpassword);
		Assert.assertTrue(false);
		
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			String path=testUtil.screenShot(result.getName(),className);
			test.addScreenCaptureFromPath(path);
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, result.getName());
		}
		extent.flush();
		
	}

}
