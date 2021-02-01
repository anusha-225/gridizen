package com.qa.gridizen.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.gridigen.base.TestBase;
import com.qa.gridizen.LoginTest.AddMantenanceTest;

public class TestUtil extends TestBase {
	static Workbook book;
	static Sheet sheet;
	public static AddMantenanceTest addMaintenanceTest= new AddMantenanceTest();
	public Object[][] createdata() {
		FileInputStream file=null;
		try {
			file=new FileInputStream("/Users/macbook/eclipse-workspace/gridigen-1/excelSheets/AddMaintenance.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		 sheet=book.getSheet("AddMaintenance");
		int lastRowNo=sheet.getLastRowNum();
		int lastColNo=sheet.getRow(0).getLastCellNum();
		int j, i;
	Object[][] data= new Object[4][4];
	
for( i=0;i<4;i++) {
			
			for( j=0;j<4;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;	
	}
	public String screenShot(String methodName, String classname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
    	File src=ts.getScreenshotAs(OutputType.FILE);
    	String path="/Users/macbook/eclipse-workspace/gridigen-1/images/"+System.currentTimeMillis()+classname+"---"+methodName+".png";
    	File des=new File(path);
    	FileUtils.copyFile(src, des);
    	return path;
	}
	public void extentReport(String methodName) {
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("/Users/macbook/eclipse-workspace/gridigen-1/ExtentReports/.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		System.out.println(methodName);
		/*ExtentTest test1=extent.createTest(addMaintenanceTest.toString());
		test1.log(Status.PASS, "passesd");
		test1.log(Status.FAIL, "hai");
		String path="/Users/macbook/eclipse-workspace/gridigen-1/images/google.png";
		//TestUtil testUtil=new TestUtil();
		try {
	        test1.fail("gh", MediaEntityBuilder.createScreenCaptureFromPath(path,"one").build());                
	     } catch (Exception e) {         
	         e.getMessage();
	         }*/
		extent.flush();
	}
	public Object[][] addPropertyData() {
		FileInputStream file=null;
		try {
			file=new FileInputStream("/Users/macbook/eclipse-workspace/gridigen-1/excelSheets/AddProperty.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		 sheet=book.getSheet("Sheet1");
		 Object[][] data=new Object[2][7];
		 for(int i=0;i<2;i++) {
			 for(int j=0;j<7;j++) {
				 if(j==6) {
					 data[i][j]=(long)sheet.getRow(i+1).getCell(j).getNumericCellValue();
				 }
				 else {
				 data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				 }
			 }
		 }
		return data;
	}
	public void getSize(String textXpath, String ItemText) {
		List<WebElement> list=driver.findElements(By.xpath(textXpath));
		for(int i=0;i<list.size();i++) {
			String selectedText=list.get(i).getText();
			System.out.println(selectedText);
			if(selectedText.equals(ItemText)) {
				list.get(i).click();
				break;
			}
	}
}
}
