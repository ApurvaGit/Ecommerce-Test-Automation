package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BrowserUtility {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    Logger logger = LoggerUtility.getLogger(this.getClass());

    public WebDriver getDriver() {
        return driver.get();
    }
    // public static Logger logger;

    public BrowserUtility(WebDriver driver) {
        this.driver.set(driver);
    }

    public BrowserUtility(Browser browserName) {
     /*   if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else{
            System.err.println("Invalid browser name! Please select between Chrome or Firefox");
        }*/
        //Used Enum class and replace the above code with the following
        if (browserName == Browser.CHROME) {
            driver.set(new ChromeDriver());
        } else if (browserName == Browser.FIREFOX) {
            driver.set(new FirefoxDriver());
        }
    }

    public BrowserUtility(Browser browserName, boolean isHeadless) {
     /*   if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else{
            System.err.println("Invalid browser name! Please select between Chrome or Firefox");
        }*/
        logger.info("launching browser for " + browserName);
        //Used Enum class and replace the above code with the following
        if (browserName == Browser.CHROME) {
            if (isHeadless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=old"); //headless
                options.addArguments("--window-size=1920,1000");
                driver.set(new ChromeDriver(options));
            } else {
                driver.set(new ChromeDriver());
            }
        } else if (browserName == Browser.FIREFOX) {
            if (isHeadless) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless-old");
                driver.set(new FirefoxDriver(options));
            } else {
                driver.set(new FirefoxDriver());
            }
        }
    }

    public void goToWebsite(String url) {
        logger.info("Launching the url");
        driver.get().get(url);
    }

    public void tearDown() {
        driver.get().quit();
    }

    public void maximiseWindow() {
        logger.info("Maximize the window");
        driver.get().manage().window().maximize();
    }

    public void clickOn(By locator) {
        logger.info("Performing click on found by the locator" + locator);
        WebElement element = driver.get().findElement(locator);      //wd need By type of variable which we got from By class using By.xpath
        element.click();
    }

    public void enterText(By locator, String textToEnter) {
        WebElement element = driver.get().findElement(locator);
        element.sendKeys(textToEnter);
    }

    public String getText(By locator) {
        WebElement element = driver.get().findElement(locator);
        return element.getText();
    }

    public String getVisibleText(By locator){
        logger.info("Finding element with the locator"+ locator);

        WebElement element = driver.get().findElement(locator);
        logger.info("Element found and returning the visible text "+ element.getText());
        return element.getText();
    }

    public String takeScreenShot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        String timestamp = format.format(date);
        //String path = System.getProperty("user.dir") + "//screenshots//" + name + " - " + timestamp + ".png";
        String path = System.getProperty("./screenshots/" + name + " - " + timestamp + ".png");
        File screenshotfile = new File(path);
        try {
            FileUtils.copyFile(screenshotData, screenshotfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}