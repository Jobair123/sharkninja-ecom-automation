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
	
	@FindBy(className="search-toggle")
	WebElement src;
	
	@FindBy(name="q")
	WebElement search;
	
	@FindBy(xpath="//*[@id=\"product-search-results\"]/div[1]/div[2]/div/div[1]/div/div/div[2]/div[1]/a")
	WebElement product_name;
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div/div[2]/span[1]")
	WebElement error;
	
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
	
	public void clickOnSearch() {
		wait.until(ExpectedConditions.elementToBeClickable(src));
		src.click();
	}
	
	public void search_prod(String value) {
		wait.until(ExpectedConditions.visibilityOf(search));
		search.clear();
		search.sendKeys(value);
		search.sendKeys(Keys.ENTER);
	}
	
	public String getProductName() {
		wait.until(ExpectedConditions.visibilityOf(product_name));
		String getname = product_name.getText();
		return getname;
	}
	public String errorResult() {
		wait.until(ExpectedConditions.visibilityOf(error));
		String getError = error.getText().trim();	
		return getError;
	}
	    
}
