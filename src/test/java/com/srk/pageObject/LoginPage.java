package com.srk.pageObject;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	 WebDriverWait wait;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@FindBy(id="login-form-email")
	WebElement email;
	
	@FindBy(id="login-form-password")
	WebElement pass;
	
	@FindBy(xpath="//*[@id=\"maincontent\"]/div/div/div[4]/form/button")
	WebElement btn;
	
	@FindBy(id="form-email-error")
	WebElement em_error;
	
	@FindBy(id="form-password-error")
	WebElement pass_error;
	
	@FindBy(className="toast-body")
	WebElement validationerror;
	

	
	public void enterEmail(String e) {
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		email.sendKeys(e);
	}
	public void enterPass(String p) {
		wait.until(ExpectedConditions.visibilityOf(pass));
		pass.clear();
		pass.sendKeys(p);
	}
	public void lgBtn() {
		//wait.until(ExpectedConditions.elementToBeClickable(btn));
		if(btn.isEnabled()) {
			btn.sendKeys(Keys.ENTER);
		}
		
	}
	
	public String isEmailValid() {
		wait.until(ExpectedConditions.visibilityOf(em_error));
		return em_error.getText();
	}
	
	public String PassError() {
		wait.until(ExpectedConditions.visibilityOf(pass_error));
		return pass_error.getText();
	}
	
	public String invalidCredentials() {
		wait.until(ExpectedConditions.visibilityOf(validationerror));
		return validationerror.getText();
	}
	
	
	

}
