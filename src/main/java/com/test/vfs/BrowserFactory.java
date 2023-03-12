package com.test.vfs;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.vfs.util.Constants;

public class BrowserFactory {

	private final Logger log;
	public WebDriver driver;

	public static Duration duration = Duration.of(45, ChronoUnit.SECONDS);

	public static String logName = new StringBuilder(Constants.RUN).append("_").append(LocalDateTime.now().toString())
			.append(".log").toString();

	public BrowserFactory() {
		System.setProperty("log.name", logName);
		log = LoggerFactory.getLogger(this.getClass().getSimpleName() + "_" + Constants.BROWSER);
	}

	public WebDriver getDriver() {
		log.debug("getDriver for Chrome");
		if (driver == null) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver", "C:\\browser-driver\\Chrome-driver-110\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(duration);
			driver.manage().timeouts().pageLoadTimeout(duration);
		}
		return driver;
	}

	public WebDriver getDriver(String browserName) {
		log.debug("getDriver for :: {}", browserName);
		if (driver == null) {
			if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\browser-driver\\geckodriver-110\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(duration);
				driver.manage().timeouts().pageLoadTimeout(duration);
			} else if (browserName.equalsIgnoreCase("chrome")) {
				System.out.println("in chrome");
				System.setProperty("webdriver.chrome.driver",
						"C:\\browser-driver\\Chrome-driver-110\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(duration);
				driver.manage().timeouts().pageLoadTimeout(duration);
			} else if (browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						"C:\\browser-driver\\IEDriverServer_x64_4.8.1\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(duration);
				driver.manage().timeouts().pageLoadTimeout(duration);
			} else if (browserName.equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.ie.driver", "C:\\browser-driver\\edgedriver_win64_110\\msedgedriver.exe");
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(duration);
				driver.manage().timeouts().pageLoadTimeout(duration);
			}
		}
		return driver;
	}

}
