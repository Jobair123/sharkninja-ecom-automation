package com.srk.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.srk.pageObject.IndexPage;
import com.srk.utilities.ExcelUtils;

public class SearchTest extends BaseClass {
	int i=0;
	
	@Test(dataProvider="searchData")
	public void searchTest(String search_key, String expected) {
		
		IndexPage pg = new IndexPage(driver);
	 if(i==0) {
		 first();
		 i++;
	 }
	 pg.clickOnSearch();
	 logger.info("search button clicked");
	
	 
	 if(expected.equals("valid")) {
		
		pg.search_prod(search_key);
		
			String getMessage = pg.getProductName();
			System.out.println(getMessage);
		    Assert.assertTrue(getMessage.toLowerCase().contains(search_key.toLowerCase()));
			  
		} else {
		
			 pg.search_prod(search_key);
			String getMessage = pg.errorResult();
			//System.out.println(getMessage);
			Assert.assertEquals(getMessage, "We are sorry, but no results were found for:");
			
		}
		
	}
	


	public void first() {
		logger.info("url opened");
		IndexPage pg = new IndexPage(driver);
		pg.cerosol();
		pg.declineCookie();
	}
	
	@DataProvider(name = "searchData")
	public Object[][] loginCredentials() throws IOException {
	    String path = System.getProperty("user.dir") + "/src/main/resources/searchData.xlsx";
	    return ExcelUtils.getExcelData(path, "Sheet1");
	}

}
