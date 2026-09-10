package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumInteractions {

    private static WebDriver driver;
    public static WebDriverWait wait;
    public static String randomEmail;

    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 60);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static String navigateTo() {
        driver.get("https://ntorque.n-thesis.com/");
        return driver.getCurrentUrl();
    }

    public static String getText(String elementXpath) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))).getText();
    }

    public static void clickOn(String elementXpath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))).click();
    }

    public static void typeIn(String elementXPath, String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXPath))).sendKeys(text);
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isDisplayed(String elementXpath) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))).isDisplayed();
    }

    public static void clear(String elementXpath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))).clear();
    }

    public static void scrollToElement(String elementXpath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)))
        );
    }

    public static void end() {
        driver.quit();
    }

}
