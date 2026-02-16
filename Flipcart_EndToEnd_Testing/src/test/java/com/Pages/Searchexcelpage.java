package com.Pages;


import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BaseClass.Library;
import com.ReusableFunctions.SeleniumReusable;
import com.Utilities.ExcelUtility;


public class Searchexcelpage extends Library{
	
	SeleniumReusable se;
	WebDriverWait wait;
	
	public Searchexcelpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
	}
	
	@FindBy(xpath="//input[@name='q']")
	WebElement Searchtext;
	
    @FindBy(xpath = "//*[@id=\'container\']/div/div[2]")
    WebElement afterSearchMenuBar;
    
	public void Searchwithexcel() throws IOException, InterruptedException {
			
			se = new SeleniumReusable(driver); 
			ExcelUtility excel = new ExcelUtility();
			
			logger.info("Starting Search with Excel keywords...");
			
			for (int i = 0; ; i++) {
		        String keyword = excel.excelRead("TestData", i, 0);
		        
		        
		        if (keyword == null || keyword.trim().isEmpty()) {
		            logger.info("No more keywords found. Stopping loop at row: " + i);
		            break;
		        }

		        logger.info("Searching keyword: " + keyword + " (Row: " + i + ")");
	
		        se.waitForVisible(Searchtext, 10);
		        Searchtext.clear();
		        se.EnterValue(Searchtext, keyword);
	
		        Searchtext.sendKeys(Keys.ENTER);
		        se.waits();
		        
		        if(afterSearchMenuBar.isDisplayed()) {
		        	logger.info("Result displayed for keyword: " + keyword + " => PASSED");
		        	excel.excelWrite("TestData", i, 1, "Passed");
		        }else {
		            logger.warn("Result NOT displayed for keyword: " + keyword + " => FAILED");
		        	excel.excelWrite("TestData", i, 1, "Failed");
		        }
		        logger.info("Navigating back to home page...");
		        se.navigateback();
	
		        // ✅ IMPORTANT: wait again after back
		        se.waitForVisible(Searchtext, 10);
		    }
			
			 logger.info("Search with Excel completed.");
		}
	
}
