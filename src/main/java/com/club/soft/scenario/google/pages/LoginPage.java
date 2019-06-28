package com.club.soft.scenario.google.pages;

import org.openqa.selenium.By;

import static com.club.soft.scenario.framework.util.Browser.*;

public class LoginPage implements Page {

    public static final String URL = "https://mail.google.com";

    private By loginLocator = By.cssSelector("input[type=email]");
    private By goLoginButtonLocator = By.id("identifierNext");
    private By passwordLocator = By.cssSelector("input[type=password]");
    private By goPasswordButtonLocator = By.id("passwordNext");
    private By containerLocator = By.id("view_container");

    public LoginPage open() {
        getInstance().get(URL);
        return this;
    }

    public LoginPage fillLoginField(String text) {
        getInstance().sendKeys(loginLocator, text);
        return this;
    }

    public LoginPage fillPasswordField(String text) {
        getInstance().sendKeys(passwordLocator, text);
        return this;
    }

    public LoginPage clickLoginButton() {
        getInstance().click(goLoginButtonLocator);
        return this;
    }

    public MainMailPage clickPasswordButton() {
        getInstance().click(goPasswordButtonLocator);
        return new MainMailPage();
    }

    @Override
    public boolean isOnThisPage() {
        return getInstance().isElementPresent(containerLocator);
    }
}
