package com.test.vfs.uipackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePageClass {

	public LoginPage() {
		super();
	}

	@FindBy(how = How.ID, using = "mat-input-0")
	@CacheLookup
	WebElement username;
	@FindBy(how = How.ID, using = "mat-input-1")
	@CacheLookup
	WebElement password;
	@FindBy(how = How.CLASS_NAME, using = "mat-btn-lg")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(how=How.XPATH,using="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/tbody/tr/td[3]/a/img")
	@CacheLookup
	WebElement logout;
	 
	public void loginSite(String use, String pass) {
		log.debug("Login into site using username: {} and Password: {}",use,pass);
		try {
			username.sendKeys(use);
			password.sendKeys(pass);
			//WebElement loginBtn = Btns.get(Btns.size()-1);
			loginBtn.click();
		} catch (Exception e) {
			log.error("Unexpected error:: ",e);
		}
	}
	
	public void logoutVfs(){
		log.debug("Logout...");
		logout.click();
		}
}
