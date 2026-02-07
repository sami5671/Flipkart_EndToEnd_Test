package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Library;
import com.ReusableFunctions.SeleniumReusable;

public class Fashion_page extends Library {
	SeleniumReusable se;
	
	public Fashion_page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		se = new SeleniumReusable(driver);
	}
	
	
	@FindBy(xpath="//span[text()='Fashion']")
	WebElement fashionlink;
	
	@FindBy(xpath="//a[text()='Kids']")
	WebElement Kidslink;
	
	@FindBy(linkText="Girls Dresses")
	WebElement Girlsdresslink;

	@FindBy(xpath="//div[text()='Price -- Low to High']")
	WebElement Pricelowtohigh;
	
	
	public void movefashionlink() {
		se.mousehover(fashionlink);
	}
	public void movekidslink() {
		se.mousehover(Kidslink);
	}
	public void clickgirlslink() {
		se.moveElement(Girlsdresslink);
	}
	public void clickprice() {
		se.click(Pricelowtohigh);
	}
}
