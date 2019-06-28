package com.club.soft.scenario.selenium;

import org.testng.annotations.AfterClass;

import static com.club.soft.scenario.framework.util.Browser.*;

public class BaseTest {

    @AfterClass
    public void closeBrowser() {
        getInstance().stopBrowser();
    }
}
