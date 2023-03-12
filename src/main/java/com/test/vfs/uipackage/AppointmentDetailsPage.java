package com.test.vfs.uipackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AppointmentDetailsPage {

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname='centerCode']")
	@CacheLookup
	WebElement centre;
	
	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname='selectedSubvisaCategory']")
	@CacheLookup
	WebElement category;
	
	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname='visaCategoryCode']")
	@CacheLookup
	WebElement subCategory;
	
}
