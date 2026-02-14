package com.ReusableFunctions;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BaseClass.Library;

import io.cucumber.java.Scenario;

public class SeleniumReusable extends Library{
	
	Actions act;
	
	public SeleniumReusable(WebDriver driver) {
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
	
	public void MultipleGettext(List<WebElement> element) {
		List<WebElement>text=element;
		System.out.println(text.size());
		
		for(WebElement textcount:text) {
			String Totallist = textcount.getText();
			System.out.println("**************************************************8");
			System.out.println(Totallist);
		}
	}
	
	public void Getvalue(WebElement element) {
		String Text = element.getText();
		System.out.println(Text);
	} 
	
	public void dropdown(WebElement element, String Text) {
		
		Select drp = new Select(element);
		drp.selectByValue(Text);

	}
	public void Scrolldown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public void waits() throws InterruptedException{
		Thread.sleep(2000);
	}
	
	public void mousehover(WebElement element) {
		act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public void moveElement(WebElement element) {
		act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
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
		
		public void windowhandeling(WebElement element) {
		    String parent = driver.getWindowHandle();
		    element.click();

		    new WebDriverWait(driver, Duration.ofSeconds(10))
		            .until(ExpectedConditions.numberOfWindowsToBe(2));

		    Set<String> all = driver.getWindowHandles();
		    for (String win : all) {
		        if (!win.equals(parent)) {
		            driver.switchTo().window(win);
		            break;
		        }
		    }
		}
		
		public void waitForClickable(WebElement element, int seconds) {
		    new WebDriverWait(driver, Duration.ofSeconds(seconds))
		            .until(ExpectedConditions.elementToBeClickable(element));
		}

		public void waitForVisible(WebElement element, int seconds) {
		    new WebDriverWait(driver, Duration.ofSeconds(seconds))
		            .until(ExpectedConditions.visibilityOf(element));
		}

		//screenshot
		public void attachscreenshot(Scenario CucumberScenario) {
			final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			CucumberScenario.attach(screenshot, "image/png", "FlipkartAutomation");
		}
		
		public void closeapp() {
			driver.close();
			System.out.println("Browser closed");
		}
	
}
