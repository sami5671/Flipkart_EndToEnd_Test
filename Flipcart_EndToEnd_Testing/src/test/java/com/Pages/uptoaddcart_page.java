package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Library;
import com.ReusableFunctions.SeleniumReusable;

public class uptoaddcart_page extends Library{
		
	SeleniumReusable se;
	
	public uptoaddcart_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		se = new SeleniumReusable(driver);
	}
	
	@FindBy(linkText="Login")
	WebElement Loginlink;
	
	@FindBy(xpath = "//a[@title='Flipkart Plus Zone']")
    WebElement Flipkartpluszone;
	
	@FindBy(xpath = "//span[text()='Home & Furniture']")
	WebElement Homefurniturelink;
	
	@FindBy(xpath = "//a[contains(text(),'Wall')]")
	WebElement Walllamplink;
	
	@FindBy(xpath="(//div[@data-id]//a[@target='_blank' and @title])[1]")
	WebElement clickonelamp;
	
	@FindBy(id = "pincodeInputId")
	WebElement Pincode;
	
	@FindBy(xpath = "//span[text()='Check']")
	WebElement checklink;
	
	public void Moveloginlink() {
		se.mousehover(Loginlink);
	}
	public void Moveflipkartplus() {
	    se.moveElement(Flipkartpluszone);
	}

	public void movehomefurniture() {
	    se.mousehover(Homefurniturelink);
	}

	public void clickwalllamp() {
	    se.moveElement(Walllamplink);
	}
	
	public void clickoneresult() {
	    se.windowhandeling(clickonelamp);
	}

	public void enterpincode() {
		se.waitForVisible(Pincode, 15);
		Pincode.clear();
	    Pincode.sendKeys("600083");
	}

	public void Clickchecklink() {
	    se.click(checklink);
	}
	
}	
