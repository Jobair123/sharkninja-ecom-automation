package com.srk.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.srk.pageObject.AccountPage;
import com.srk.pageObject.IndexPage;
import com.srk.pageObject.LoginPage;
import com.srk.utilities.ExcelUtils;

public class LoginTest extends BaseClass {
	int i=0;
	
	@Test(dataProvider = "loginData")
    public void tc01(String email, String pass, String expectedCondition) {
		
		
		if(i==0) {
			readyTest();
			i++;
		}
    	
    	LoginPage lg = new LoginPage(driver);
    	lg.enterEmail(email);
    	lg.enterPass(pass);
    	lg.lgBtn();
    	
    	AccountPage ap = new AccountPage(driver);
    	
    	if(expectedCondition.equals("valid")) {
    		Assert.assertTrue(ap.isLogin());
    	} else if(expectedCondition.equals("Email is mandatory.") || expectedCondition.equals("Please enter a valid email address.")) {
    		String actual = lg.isEmailValid();
    		Assert.assertEquals(actual,expectedCondition);
    		
    	} else {
    		String actual = lg.invalidCredentials();
    		Assert.assertEquals(actual, "Your E-mail/Password combination is incorrect. Please try again.");
    		
    	}
    	
    	
   	    
   	    
   	    driver.get("https://www.sharkninja.com/login");
    	
    }
	
	public void readyTest() {
		logger.info("url opened");
		IndexPage pg = new IndexPage(driver);
		pg.cerosol();
		pg.declineCookie();
		pg.clickOnSignin();
	}
	
	@DataProvider(name = "loginData")
	public Object[][] loginCredentials() throws IOException {
	    String path = System.getProperty("user.dir") + "/src/main/resources/LoginData.xlsx";
	    return ExcelUtils.getExcelData(path, "Sheet1");
	}

}
