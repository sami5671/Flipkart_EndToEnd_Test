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
		launchapplication();
	}
	
	@After
	public void cleanup(Scenario scenario) {
		se = new SeleniumReusable(driver);
		se.attachscreenshot(scenario);
		se.closeapp();
	}
}
