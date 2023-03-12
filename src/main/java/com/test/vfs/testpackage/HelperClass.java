package com.test.vfs.testpackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.test.vfs.BrowserFactory;
import com.test.vfs.util.Constants;

public class HelperClass {
		 
		public WebDriver driver;
		BrowserFactory obj1;
		 
		public HelperClass(){
		}
		 
		@BeforeSuite
		public void beforeSuite(){
		 
		}
		 
		@BeforeClass
		public void beforeClass(){
		System.out.println("in @BeforeClass");
		}
		 
		@BeforeMethod
		public void beforeMethodClass(){
		System.out.println("in @BeforeMethod");
		obj1 = new BrowserFactory();
		this.driver = obj1.getDriver(Constants.BROWSER);
		 
		}
		 
		@AfterMethod
		public void close()
		{
		//this.driver.close();
		}
		 
		@AfterClass
		public void afterClass(){
		 
		}
		 
		@AfterSuite
		public void afterSuite() throws IOException{
		 
		driver.quit();
		}
}
