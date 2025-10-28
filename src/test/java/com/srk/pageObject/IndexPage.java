package com.srk.pageObject;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {
	WebDriver driver;
	WebDriverWait wait;
	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
    
	@FindBy(className="ltkpopup-close")
	WebElement no_thanks;
	
	@FindBy(id="CybotCookiebotDialogBodyButtonDecline")
	WebElement decline;
	
	@FindBy(xpath="/html/body/div[3]/header/nav/div[1]/div[2]/div[3]/div[3]/div/a/i")
	WebElement guestUserElement;
	
	public void clickOnSignin() {
		wait.until(ExpectedConditions.elementToBeClickable(guestUserElement));
		guestUserElement.click();
	}
	
	public void declineCookie() {
		wait.until(ExpectedConditions.elementToBeClickable(decline));
		decline.sendKeys(Keys.ENTER);
	}
	
	public void cerosol() {
		wait.until(ExpectedConditions.elementToBeClickable(no_thanks));
		no_thanks.click();
	}
	
}
