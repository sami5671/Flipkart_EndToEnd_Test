package com.Stepdefinations;

import com.BaseClass.Library;
import com.Pages.Fashion_page;
import com.ReusableFunctions.SeleniumReusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Fashion_Stepdefination extends Library {
	
	
	Fashion_page fp;
	SeleniumReusable se;
	
	
	@Given("User to move to the Fashion link")
	public void user_to_move_to_the_fashion_link() throws InterruptedException{
		
        se = new SeleniumReusable(driver);
        fp = new Fashion_page(driver);
        
		System.out.println("Before clicking fashionlink");
		se.gettitle();
		fp.movefashionlink();
	}
	
	@When("Cursor to move to the Kids link")
	public void cursor_to_move_to_the_kids_link() {
		fp.movekidslink();
	}
	
	@When("Move to girls dress and click")
	public void move_to_girls_dress_and_click() {
	    fp.clickgirlslink();
	}
	
	@When("Click the price high to low link")
	public void click_the_price_high_to_low_link() {
	    fp.clickprice();
	}
	
	@Then("It should display the relevent details and get the title")
	public void it_should_display_the_relevent_details_and_get_the_title() {
		System.out.println("After clicking fashionlink");
		se.gettitle();
	}

}
