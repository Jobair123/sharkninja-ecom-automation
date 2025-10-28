package com.srk.testCases;

import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.srk.pageObject.IndexPage;
import com.srk.utilities.ReadConfig;


public class BaseClass {
	
ReadConfig rd = new ReadConfig();
String url = rd.getUrl();
String browser = rd.getBrowser();

public static WebDriver driver;
public static Logger logger;

WebDriverWait wait;
@BeforeClass
public void setup() {
	System.out.println("Starting setup...");
    System.out.println("Browser: " + browser);
    System.out.println("URL: " + url);
	switch(browser.toLowerCase()) {
	case "chrome":
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		break;
	case "edge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
		
		default:
			driver = null;
			break;

	}
	
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	logger = LogManager.getLogger(BaseClass.class);
	logger.debug("Log4j is working!");
	
    driver.manage().window().maximize();
    driver.get(url);
}



@AfterClass
public void tearDown() {
	driver.quit();

}
}
