package com.srk.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.srk.pageObject.AccountPage;
import com.srk.pageObject.IndexPage;
import com.srk.pageObject.LoginPage;

public class LoginTest extends BaseClass {
	int i=0;
	
	@Test(dataProvider = "loginData")
    public void tc01(String email, String pass) {
		driver.get(url);
		
		if(i==0) {
			readyTest();
			i++;
		}
    	
    	LoginPage lg = new LoginPage(driver);
    	lg.enterEmail(email);
    	lg.enterPass(pass);
    	lg.lgBtn();
    	
    	AccountPage pa = new AccountPage(driver);
    	
   	    Assert.assertTrue(pa.findName());
    	
    }
	
	public void readyTest() {
		logger.info("url opened");
		IndexPage pg = new IndexPage(driver);
		pg.cerosol();
		pg.declineCookie();
		pg.clickOnSignin();
	}
	
	
	
    @DataProvider(name = "loginData")
    public Object[][] loginCredentials() {
        return new Object[][] {
            {"jobair@qa.team", "AerdAs23#"},
            {"admin@qateam", "Admin123!"},
            {"jobair@qa.team", "Testhj@456"},
            {"jobair56@qa.team", "AerdAs23#"},
            {"", ""},
            {"jobair@qa.team", "AERDAs23#"},
            {"jobair@qa.team", "AerdAs23#"}
        };
    }
}
