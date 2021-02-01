package com.qa.gridizen.Pages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.qa.gridigen.base.TestBase;

public class Experiance extends TestBase {
	
	public static LoginPage loginPage1;
	public static ActionCenter actionCenter;
	public static AddMaintenance addMaintenance;
	public static MaintenancePage maintenancepage;
	public static Join join;
	AddProperty property;
	Properties properties;
	/*@Test
	public void one() throws InterruptedException, IOException, SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/anu1","root","jesus225");
		Statement stmt = con.createStatement();
		ResultSet rs= stmt.executeQuery("select *  from table1");	
		while (rs.next()){
			String myName = rs.getString(1);
			System.out.println(myName);
			
		}
		con.close();
		
	}*/
	@Test
	public void one1() throws IOException {
		//intialiszation();
		join=new Join();
		//loginPage1=new LoginPage();
		//loginPage1.clickJoin();
		//join.addDetails();
		join.excelAddData();
	}
	}

