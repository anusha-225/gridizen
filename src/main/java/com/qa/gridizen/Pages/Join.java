package com.qa.gridizen.Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.gridigen.base.TestBase;
import com.qa.gridizen.util.TestUtil;

public class Join extends TestBase{
	@FindBy(xpath="//input[@name='business_name']")
	WebElement organisationName;
	@FindBy(xpath="//mat-select[@name='Title']")
	WebElement organaistionType;
	@FindBy(xpath="//mat-select[@id='mat-select-1']")
	WebElement title;
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	@FindBy(xpath="//input[@name='last_name']")
	WebElement last_name;
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	@FindBy(xpath="//input[@name='mobile_num']")
	WebElement mobile_num;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//input[@name='cpassword']")
	WebElement cpassword;
	@FindBy(xpath="//input[@name='terms']")
	WebElement terms;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	public static JavascriptExecutor js=(JavascriptExecutor)driver;
	public static TestUtil testUtil=new TestUtil();
	public static Workbook book;
	public static Sheet sheet;
	public Join() {
		PageFactory.initElements(driver, this);
	}
	public void addDetails() {
		organisationName.sendKeys("anugraha");
		organaistionType.click();
		testUtil.getSize("//div[@class='cdk-overlay-pane']//mat-option[@role='option']", "LANDLORD");
		title.click();
		testUtil.getSize("//div[@class='cdk-overlay-pane']//mat-option[@role='option']", "Mr");
		firstName.sendKeys("anu");
		last_name.sendKeys("latha");
		email.sendKeys("anusha@gmail.com");
		mobile_num.sendKeys("8655667788");
		password.sendKeys("Test@123");
		cpassword.sendKeys("Test@123");
		js.executeScript("arguments[0].click();", terms);
		js.executeScript("arguments[0].click();", submit);
		
	}	
	public Object[][] excelAddData()   {
		FileInputStream file=null;
		 try {
			file=new FileInputStream("/Users/macbook/eclipse-workspace/gridigen-1/excelSheets/AddJoinData.xlsx");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=book.getSheetAt(0);
		Object[][] data=new Object[4][9];
		for(int i=0;i<4;i++) {
			for(int j=0;j<9;j++) {
				if(j==6) {
					data[i][j]=(long) sheet.getRow(i+1).getCell(j).getNumericCellValue();
				}
				else
				{
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			
		}	
	}
		}
		return data;
	}
}






