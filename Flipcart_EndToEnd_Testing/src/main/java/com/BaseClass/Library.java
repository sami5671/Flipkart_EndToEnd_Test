package com.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Library {

    public static WebDriver driver;
    public static Properties prop;

    public void launchapplication() throws IOException {

    FileInputStream input = new FileInputStream("src/test/resources/Properties/Config.properties");
    prop = new Properties();
    prop.load(input);

    String browser = prop.getProperty("browser");
    String url = prop.getProperty("url");

    if (browser == null || url == null) {
        throw new RuntimeException("Missing 'browser' or 'url' in Config.properties");
    }

    if ("chrome".equalsIgnoreCase(browser)) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        // ✅ unique user-data-dir (fix for DevToolsActivePort crash)
        String profilePath = System.getProperty("java.io.tmpdir")
                + java.io.File.separator
                + "selenium_chrome_profile_" + System.currentTimeMillis();
        options.addArguments("--user-data-dir=" + profilePath);

        driver = new ChromeDriver(options);

    } else if ("firefox".equalsIgnoreCase(browser)) {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(new FirefoxOptions());

    } else {
        throw new RuntimeException("Unsupported browser in config: " + browser);
    }

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.get(url);
}


    public void teardown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
