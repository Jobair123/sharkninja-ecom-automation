package com.srk.pageObject;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
	WebDriver driver;
	WebDriverWait wait;
	public AccountPage(WebDriver driver){
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(className="account-dashboard__welcome")
	WebElement name;
	
	 public boolean findName() {
		    try {
		        wait.until(ExpectedConditions.visibilityOf(name));
		        return name.isDisplayed();
		    } catch (NullPointerException e) {
		        System.out.println("Element not found or not visible: " + e.getMessage());
		        return false;
		    }
		}

}
