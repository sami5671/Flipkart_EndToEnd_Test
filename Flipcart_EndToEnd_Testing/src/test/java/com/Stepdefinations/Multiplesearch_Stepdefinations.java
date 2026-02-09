package com.Stepdefinations;

import com.BaseClass.Library;
import com.Pages.Multiplesearch;
import com.ReusableFunctions.SeleniumReusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Multiplesearch_Stepdefinations extends Library {
	
	Multiplesearch ms;
	SeleniumReusable se;
	
	@Given("Enter the {string} in the search field")
	public void enter_the_in_the_search_field(String searchtext) {
		
		ms =  new Multiplesearch(driver);
		ms.Entersearch(searchtext);
	}

	@When("click the search button")
	public void click_the_search_button() {
		
		ms.clicksearch();
	}

	@Then("It should navigate to the next page and display the corresponding page")
	public void it_should_navigate_to_the_next_page_and_display_the_corresponding_page() {
	    
		se = new SeleniumReusable(driver);
		se.gettitle();
		System.out.println("***************************************************");
		se.screenshot("src/test/resources/Screenshots/search.png");
	}
}
