package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BrowserUtility {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private Logger logger = LoggerUtility.getLogger(this.getClass());
    private WebDriverWait wait;

    public WebDriver getDriver() {
        return driver.get();
    }
    // public static Logger logger;

    public BrowserUtility(WebDriver driver) {
        this.driver.set(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
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
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        } else if (browserName == Browser.FIREFOX) {
            driver.set(new FirefoxDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
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
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            } else {
                driver.set(new ChromeDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
        } else if (browserName == Browser.FIREFOX) {
            if (isHeadless) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless-old");
                driver.set(new FirefoxDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            } else {
                driver.set(new FirefoxDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
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
        //WebElement element = driver.get().findElement(locator);      //wd need By type of variable which we got from By class using By.xpath
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void clickOn(WebElement element) {
        logger.info("Performing click on the element" + element);
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clickOnCheckbox(WebElement element) {
        logger.info("Performing click on the element" + element);
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
      //  WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        element1.click();
    }

    public void enterText(By locator, String textToEnter) {
        //WebElement element = driver.get().findElement(locator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(textToEnter);
    }

    public void enterSpecialKey(By locator, Keys keyToEnter) {
        //WebElement element = driver.get().findElement(locator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(keyToEnter);
    }

    public String getText(By locator) {
        WebElement element = driver.get().findElement(locator);
        return element.getText();
    }

    public String getVisibleText(By locator) {
        logger.info("Finding element with the locator" + locator);

        WebElement element = driver.get().findElement(locator);
        logger.info("Element found and returning the visible text " + element.getText());
        return element.getText();
    }

    public String getVisibleText(WebElement element) {
        logger.info("Return the visible text" + element.getText());
        return element.getText();
    }

    public List<String> getAllVisibleTexts(By locator) {
        logger.info("Finding all elements with the locator" + locator);

        List<WebElement> elements = driver.get().findElements(locator);
        logger.info("Elements found and returning the list of elements ");
        List<String> visibleTextList = new ArrayList<>();
        for (WebElement element : elements) {
            System.out.println(getVisibleText(element));
            visibleTextList.add(getVisibleText(element));
        }
        return visibleTextList;
    }

    public List<WebElement> getAllElements(By locator) {
        logger.info("Finding all elements with the locator" + locator);
        List<WebElement> elementsList = driver.get().findElements(locator);

        logger.info("Elements found and returning the list of elements ");
        return elementsList;
    }

    public void clearText(By textboxLocator) {
        //WebElement element = driver.get().findElement(textboxLocator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textboxLocator));
        element.clear();
    }

    public void selectFromDropdown(By dropdownLocator, String optionToSelect) {
        logger.info("finding element with the locator" + dropdownLocator);
        WebElement stateDropdown = driver.get().findElement(dropdownLocator);
        Select select = new Select(stateDropdown);
        logger.info("Selecting dopdown option " + optionToSelect);
        select.selectByVisibleText(optionToSelect);
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