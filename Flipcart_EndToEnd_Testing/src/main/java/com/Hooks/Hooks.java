package com.Hooks;

import java.io.IOException;

import com.BaseClass.Library;
import com.ReusableFunctions.SeleniumReusable;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Library {
	
	SeleniumReusable se;
	public static Scenario scenario;
	
	@Before
	public void test(Scenario Cucumberscenario) throws IOException {
		scenario = Cucumberscenario;
		
		logger.info("=================================================");
	    logger.info("START Scenario: " + scenario.getName());
	    
//		launchapplication();
	}
	
	@After
	public void cleanup(Scenario scenario) {
		
		logger.info("END Scenario: " + scenario.getName() + " | Status: " + scenario.getStatus());
		
		se = new SeleniumReusable(driver);
		se.attachscreenshot(scenario);
		se.closeapp();
		
        logger.info("=================================================");

	}
}
