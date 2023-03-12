package com.test.vfs.testpackage;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.test.vfs.dto.Applicant;
import com.test.vfs.uipackage.BookingPage;
import com.test.vfs.uipackage.LoginPage;
import com.test.vfs.util.ExcelReader;

public class TestClass extends HelperClass {

	public TestClass() {
	}

	@Test
	public void doProcess() {
		try {
			//login();
			//startBooking();
			
			readExcel();

			/*
			 * try {CaptureScreenShot.getScreenShot(BrowserFactory.getDriver(),
			 * bookingDetailsFile); } catch (Exception e) {e.printStackTrace();}
			 * 
			 * loginPage.logoutPress();
			 */
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void readExcel() {
		ExcelReader excelReader = new ExcelReader();
		List<Applicant> excelRead = excelReader.readExcel();
		System.out.println(excelRead);
		
	}

	private void startBooking() throws InterruptedException {
		BookingPage bookingPage = PageFactory.initElements(driver, BookingPage.class);
		bookingPage.startNewBooking();
	}

	private void login() {
		System.out.println("in login");
		driver.get("https://visa.vfsglobal.com/ind/en/hrv/login");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginSite("rinadevi91590@gmail.com", "Avinash70!");
	}

}
