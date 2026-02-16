package com.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Library {

    public static WebDriver driver;
    public static Properties prop;
    public static Logger logger = Logger.getLogger(Library.class);

    public void launchapplication() throws IOException {

        FileInputStream input = new FileInputStream("src/test/resources/Properties/Config.properties");
        prop = new Properties();
        prop.load(input);

        // Logger config (only once is ok, but safe to call)
        PropertyConfigurator.configure("src/test/resources/Properties/log4j.properties");

        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");

        if (browser == null || url == null) {
            logger.error("Missing 'browser' or 'url' in Config.properties");
            throw new RuntimeException("Missing 'browser' or 'url' in Config.properties");
        }

        logger.info("Launching browser: " + browser);
        logger.info("Navigating to URL: " + url);

        if ("chrome".equalsIgnoreCase(browser)) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--start-maximized");

            String profilePath = System.getProperty("java.io.tmpdir")
                    + java.io.File.separator
                    + "selenium_chrome_profile_" + System.currentTimeMillis();
            options.addArguments("--user-data-dir=" + profilePath);

            driver = new ChromeDriver(options);

        } else if ("firefox".equalsIgnoreCase(browser)) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(new FirefoxOptions());

        } else {
            logger.error("Unsupported browser in config: " + browser);
            throw new RuntimeException("Unsupported browser in config: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(url);

        logger.info("Application launched successfully.");
    }

    public void teardown() {
        if (driver != null) {
            logger.info("Closing browser...");
            driver.quit();
            driver = null;
            logger.info("Browser closed.");
        }
    }
}
