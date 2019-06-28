package com.club.soft.scenario.framework.util;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public final class Browser implements WrapsDriver {

    public static final int PRESENT_ELEMENT_TIME_OUT = 5;
    public static final int DEFAULT_TIMEOUT_SECONDS = 10;

    private static ThreadLocal<Browser> instance = new ThreadLocal<>();

    private WebDriver wrappedWebDriver;

    private Browser() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        WebDriver webDriver = null;
        DesiredCapabilities desiredCapabilities;
        desiredCapabilities = DesiredCapabilities.chrome();
        webDriver = new ChromeDriver(desiredCapabilities);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        wrappedWebDriver = webDriver;
    }

    public static synchronized Browser getInstance() {
        if (instance.get() == null) {
            instance.set(new Browser());
        }
        return instance.get();
    }

    @Override
    public WebDriver getWrappedDriver() {
        return wrappedWebDriver;
    }

    public void get(String url) {
        wrappedWebDriver.navigate().to(url);
    }

    public void stopBrowser() {
        try {
            if (getWrappedDriver() != null) {
                getWrappedDriver().quit();
            }
        } catch (WebDriverException e) {
            e.printStackTrace();
        } finally {
            instance.set(null);
        }
    }

    public boolean isElementPresent(By by) {
        try {
            wrappedWebDriver.manage().timeouts().implicitlyWait(PRESENT_ELEMENT_TIME_OUT, TimeUnit.SECONDS);
            return wrappedWebDriver.findElements(by).size() > 0;
        } finally {
            wrappedWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        }
    }

    public WebElement waitForVisibilityOfElement(By by) {
        return this.waitForVisibilityOfElement(by, DEFAULT_TIMEOUT_SECONDS);
    }

    public WebElement waitForVisibilityOfElement(By by, long timeout) {
        return new WebDriverWait(wrappedWebDriver, timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForPresenceOfElement(By by) {
        return new WebDriverWait(wrappedWebDriver, DEFAULT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public String getText(By by) {
        return waitForVisibilityOfElement(by).getText();
    }

    public void click(By by) {
        waitForVisibilityOfElement(by).click();
    }

    public void sendKeys(By by, String text) {
        waitForVisibilityOfElement(by).sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
    }

    public void useActionsCtrlEnter(By by) {
        new Actions(wrappedWebDriver).moveToElement(waitForPresenceOfElement(by))
                .sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER)).build().perform();
    }
}
