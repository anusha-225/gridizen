 package com.qa.gridizen.LoginTest;
 import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
 import org.testng.annotations.BeforeTest;
 import org.testng.annotations.Test;
 import com.qa.gridigen.base.TestBase;
import com.qa.gridizen.Pages.ActionCenter;
//import com.qa.gridizen.loginPages.LoginPage;
import com.qa.gridizen.Pages.LoginPage;
import com.qa.gridizen.Pages.Properties;

public class LoginTest extends TestBase{
public static LoginPage loginPage1;
public static ActionCenter actionCenter;
public static Properties properties;
	    @Test
	     public void one() throws IOException, InterruptedException {
	    	intialiszation();
	    	loginPage1=new LoginPage();
	    	properties=new Properties();
	    	//loginPage1.clickJoin();
	    	loginPage1.LoginClick();
	    	actionCenter=new ActionCenter();
	    	//actionCenter.clickProperties();
	    	//properties.clickOnAddProperty();
	    	actionCenter.clickCalender();
	    } 
	}