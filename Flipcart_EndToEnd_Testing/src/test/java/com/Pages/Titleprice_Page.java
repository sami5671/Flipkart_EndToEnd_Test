package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Library;
import com.ReusableFunctions.SeleniumReusable;

public class Titleprice_Page extends Library{

	SeleniumReusable se;
	
	public Titleprice_Page(WebDriver driver) {
		 
		this.driver = driver;
		PageFactory.initElements(driver, this);
		se = new SeleniumReusable(driver);
	}
	
	@FindBy(name="q")
	WebElement Search;
	
	@FindBy(xpath = "//button[@type=\'submit\']")
	WebElement searchicon;
	
	public void entersearch(String Text) {
		se.EnterValue(Search, Text);
	}
	
	public void clicksearchicon() {
		se.click(searchicon);
	}
}
