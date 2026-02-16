package com.Stepdefinations;

import java.io.IOException;

import com.BaseClass.Library;
import com.Pages.Searchexcelpage;
import com.ReusableFunctions.SeleniumReusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchWithExcel_Stepdefination extends Library{
	
	SeleniumReusable se;
	Searchexcelpage Sexcelp; 
	
	@Given("Enter Search Text In the Search Field")
	public void enter_search_text_in_the_search_field() throws IOException, InterruptedException {
		logger.info("Step: Enter Search Text In the Search Field");
		Sexcelp = new Searchexcelpage(driver);
		Sexcelp.Searchwithexcel();
		
	}

	@When("Click search Icon")
	public void click_search_icon() {
	    logger.info("Step: Click search Icon (Taking Screenshot)");
		se = new SeleniumReusable(driver);
		se.screenshot("src/test/resources/Screenshots/excelsearch.png");
	   
	}

	@Then("It Should Display The Relevent Result")
	public void it_should_display_the_relevent_result() {
	    logger.info("Step: It Should Display The Relevant Result (Printing Title)");
	    se.gettitle();
	}

}
