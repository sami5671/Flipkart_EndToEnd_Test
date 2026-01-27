package com.ReusableFunctions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BaseClass.Library;

public class SeleniumReusable extends Library{
	
	private void SeleniumReusable(WebDriver driver) {
		this.driver = driver;
	}
	
	// Enter the text of element
	public void EnterValue(WebElement element, String Text) {
		try {
			element.sendKeys(Text);
		} catch (Exception e) {
			System.out.println("No such element Exception");
		}
	}
	
	// click the element
	public void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("No such element Exception");
		}
	}
	
	// get the title of the page
	public void gettitle() {
		try {
			System.out.println(driver.getTitle());
		} catch (Exception e) {
			System.out.println("Could not get the title");
		}
	}
	
	// takes screenshot of the test case 
	public void screenshot(String path) {
		TakesScreenshot TS = (TakesScreenshot)driver;
		File source = TS.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(source, new File(path));
		} catch (Exception e) {
			System.out.println("Screenshot not found");
		}
	}
	
}
