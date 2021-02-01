package com.qa.gridigen.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public static void intialiszation() throws IOException {
		FileInputStream file= new  FileInputStream("/Users/macbook/eclipse-workspace/gridigen-1/config.properties");
		prop=new Properties();
		prop.load(file);
		System.setProperty("webdriver.gecko.driver", "/Users/macbook/Desktop/drivers/geckodriver");
		driver= new FirefoxDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}
}
