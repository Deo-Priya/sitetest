package com.test.vfs.uipackage;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.vfs.util.Constants;

public class BasePageClass {

	protected WebDriver driver;
	protected final Logger log;

	public BasePageClass() {
		super();
		System.setProperty("log.name", this.getClass().getSimpleName() + "_" + Constants.BROWSER);
		log = LoggerFactory.getLogger(this.getClass().getSimpleName() + "_" + Constants.BROWSER);
	}

}