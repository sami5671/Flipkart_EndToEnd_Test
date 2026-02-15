package com.Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BaseClass.Library;
import com.ReusableFunctions.SeleniumReusable;
import com.Utilities.ExcelUtility;


public class SearchPage extends Library{
	
	SeleniumReusable se;
	WebDriverWait wait;

	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
	
	}
	
	@FindBy(xpath="//input[@name='q']")
	WebElement Searchtext;
	
	@FindBy(xpath="//html[@lang='en-IN']")
	WebElement Homepage;
	
	// ✅ Use product links as "results loaded" indicator
    @FindBy(css = "a[href*='/p/'], a[href*='pid=']")
    List<WebElement> productLinks;
    
    @FindBy(xpath = "//*[@id=\'container\']/div/div[3]/div[1]/div[2]/div/div/div/div/a/div[2]/div[1]")
    List<WebElement> Entireresult;
    
    @FindBy(xpath = "//*[@id=\'container\']/div/div[3]/div[1]/div[2]/div[4]/div/div/div")
    WebElement ThirdResult;
	
	
	public void Search(String Text) {
		se = new SeleniumReusable(driver);
		wait.until(ExpectedConditions.visibilityOf(Searchtext));
		se.EnterValue(Searchtext, Text);
	}
	
	public void Clicksearch() {
		Searchtext.sendKeys(Keys.ENTER);
	}
	
	public void homescreen() {
        wait.until(ExpectedConditions.visibilityOf(Homepage));
		System.out.println("Home page: " + Homepage.isDisplayed());
	}
	
	public void Result() {
		// ✅ wait for search page URL
        wait.until(ExpectedConditions.or(
            ExpectedConditions.urlContains("search"),
            ExpectedConditions.urlContains("q=")
        ));

        // ✅ wait until at least 1 product appears
        wait.until(driver -> productLinks.size() > 0);

        System.out.println("Search Results Loaded: " + (productLinks.size() > 0));
        System.out.println("Title is: " + driver.getTitle());
	}
	
	public void printentireresult() {
		System.out.println("----------Here is Entire results-----");
		se.MultipleGettext(Entireresult);
		System.out.println("----------END of Entire results-----");
	}
	
	public void Print3rdresult() {
		System.out.println("----------Third value -----");
		se.Getvalue(ThirdResult);
	}
	
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

	        se.navigateback();

	        // ✅ IMPORTANT: wait again after back
	        se.waitForVisible(Searchtext, 10);
	    }
	}
	
	
	
	
	
	
	
}
