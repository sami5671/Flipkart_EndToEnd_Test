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
			
			for (int i = 0; ; i++) {
		        String keyword = excel.excelRead("TestData", i, 0);
		        if (keyword == null || keyword.trim().isEmpty()) break;
	
		        se.waitForVisible(Searchtext, 10);
		        Searchtext.clear();
		        se.EnterValue(Searchtext, keyword);
	
		        Searchtext.sendKeys(Keys.ENTER);
		        se.waits();
		        
		        if(afterSearchMenuBar.isDisplayed()) {
		        	excel.excelWrite("TestData", i, 1, "Passed");
		        }else {
		        	excel.excelWrite("TestData", i, 1, "Failed");
		        }
	
		        se.navigateback();
	
		        // ✅ IMPORTANT: wait again after back
		        se.waitForVisible(Searchtext, 10);
		    }
		}
	
}
