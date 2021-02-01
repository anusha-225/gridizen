package com.qa.gridizen.Pages;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.gridigen.base.TestBase;
import com.qa.gridizen.util.TestUtil;

public class AddCalender extends TestBase {
	public static FileInputStream file=null;
	public static Workbook book;
	public static Sheet sheet;
	public static JavascriptExecutor js=(JavascriptExecutor)driver;
	TestUtil testutil=new TestUtil();
	@FindBy(xpath="//input[@name='eventname']")
	WebElement eventName;
	@FindBy(xpath="//input[@name='eventdescription']")
	WebElement description;
	@FindBy(xpath="//*[@name='category']")
	WebElement category;
	@FindBy(xpath="//mat-option[@tabindex='0']")
	WebElement maintenance;
	@FindBy(xpath="//input[@name='propertylinkedevent']")
	WebElement propertyCheckbox;
	@FindBy(xpath="//input[@name='property']")
	WebElement Property;
	@FindBy(xpath="//mat-option[@tabindex='0']")
	WebElement propname;
	@FindBy(xpath="//button[@form='addEventForm']")
	WebElement addEvent;
	@FindBy(xpath="//div[@class='cdk-overlay-pane']//mat-option")
	WebElement one;
	public AddCalender() {
		PageFactory.initElements(driver, this);
	}
	public void select1(String eventName1, String Discription1, String category1) throws InterruptedException {
		eventName.sendKeys(eventName1);
		description.sendKeys(Discription1);
		category.click();
		testutil.getSize("//div[@class='cdk-overlay-pane']//mat-option",category1);
		Property.sendKeys("23");
		testutil.getSize("//div[@class='cdk-overlay-pane mat-autocomplete-panel-above']//mat-option//i","230 Petticoat Square,London");
		System.out.println("hello");
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", addEvent);
}
	public Object[][] addCalenderData() throws FileNotFoundException {
		 file=new FileInputStream("/Users/macbook/eclipse-workspace/gridigen-1/excelSheets/AddCalender.xlsx");
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
		Object[][] data=new Object[5][3];
		for(int i=0;i<5;i++) {
			for(int j=0; j<3;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}
