package com.Stepdefinations;

import org.openqa.selenium.By;

import com.BaseClass.Library;
import com.Pages.Titleprice_Page;
import com.ReusableFunctions.SeleniumReusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Titleprice_Stepdefinations extends Library {
	
	Titleprice_Page tp;
	SeleniumReusable se;
	
	@Given("Enter the search text in the search field")
	public void enter_the_search_text_in_the_search_field() {
		tp = new Titleprice_Page(driver);
		tp.entersearch("Shirts");
	}

	@When("Click the search icon")
	public void click_the_search_icon() {
		tp.clicksearchicon();
	    
	}

	@Then("It should display the search result and get the title and price")
	public void it_should_display_the_search_result_and_get_the_title_and_price() {
	    
		 se = new SeleniumReusable(driver);
		 se.MultipleGettext(driver.findElements(By.xpath("//a[@class=\'atJtCj\']/..")));
	}


}
