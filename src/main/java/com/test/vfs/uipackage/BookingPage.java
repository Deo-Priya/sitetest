package com.test.vfs.uipackage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BookingPage extends BasePageClass {

	public BookingPage() {
		super();
	}
	
	@FindBy(css = "mat-button-base")
	@CacheLookup
	private List<WebElement> webElements;
	
	public void startNewBooking() throws InterruptedException {
		log.debug("Start New Booking.");
		WebElement startNewBookingBtn = webElements.get(webElements.size()-1);
		startNewBookingBtn.click();
		Thread.sleep(3000);
	}
	
}
