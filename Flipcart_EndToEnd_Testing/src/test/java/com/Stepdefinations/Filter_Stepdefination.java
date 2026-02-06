package com.Stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BaseClass.Library;
import com.Pages.Filter_page;
import com.ReusableFunctions.SeleniumReusable;

import io.cucumber.java.en.Then;

public class Filter_Stepdefination extends Library{
	
	Filter_page fp;
	SeleniumReusable se;
	
	@Then("Select Minimum and Maximum Amount")
	public void select_minimum_and_maximum_amount() throws InterruptedException {
		fp = new Filter_page(driver);
		se = new SeleniumReusable(driver);
	    
	    WebElement BeforeFilter = driver.findElement(By.xpath("//*[@id=\'container\']/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]"));
	    System.out.println("Before Filter: " + BeforeFilter.getText());
	    
	    fp.Min();
	    se.waits();
	    fp.max();
	    se.waits();
	}
	
	@Then("Select the Brand")
	public void select_the_brand() throws InterruptedException {
	    fp.brand();
	    se.waits();
	}
	
	@Then("Select the Ram")
	public void select_the_ram() throws InterruptedException {
		fp.ram();
	    se.waits();
	}
	
	@Then("Select the Battery Capacity")
	public void select_the_battery_capacity() throws InterruptedException {
	    fp.clickbattery();
	    se.waits();
	}
	
	@Then("It should display the Relevant result")
	public void it_should_display_the_relevant_result() {
		System.out.println("******************************************************");
	    WebElement AfterFilter = driver.findElement(By.xpath("//*[@id=\'container\']/div/div[3]/div/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]"));
	    System.out.println("After Filter: " + AfterFilter.getText());
	}
}
