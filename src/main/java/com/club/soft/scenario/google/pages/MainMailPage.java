package com.club.soft.scenario.google.pages;

import org.openqa.selenium.By;

import static com.club.soft.scenario.framework.util.Browser.*;

public class MainMailPage implements Page {

    public static final String NAME_MAIN_FOLDER = "inbox";

    private By firstLetterIconLocator = By.xpath("//a[contains(@href,'SignOutOptions')]");
    private By logoutLocator = By.xpath("//a[contains(@href,'Logout')]");
    private By writeButtonLocator = By.cssSelector("div[gh=cm]");
    private By topicLocator = By.cssSelector("input[name=subjectbox]");
    private By textLocator = By.cssSelector("div[role=textbox]");
    private By emailLocator = By.cssSelector("textarea[name=to]");
    private By sendLocator = By.cssSelector("table[role=group] div[role=button]:first-child");
    private By isMailSendLocator = By.id("link_undo");

    @Override
    public boolean isOnThisPage() {
        return getInstance().isElementPresent(firstLetterIconLocator);
    }

    public MainMailPage openMessageForm() {
        getInstance().click(writeButtonLocator);
        return this;
    }

    public MainMailPage typeEmail(String email) {
        getInstance().sendKeys(emailLocator, email);
        return this;
    }

    public MainMailPage typeText(String text) {
        getInstance().sendKeys(textLocator, text);
        return this;
    }

    public MainMailPage typeTopic(String topic) {
        getInstance().sendKeys(topicLocator, topic);
        return this;
    }

    public MainMailPage sendMessage() {
        getInstance().click(sendLocator);
        return this;
    }

    public boolean isMailSent() {
        getInstance().waitForVisibilityOfElement(isMailSendLocator);
        return true;
    }

    public boolean isMailReceived() {
        return true;
    }

    public LoginPage logOut() {
        getInstance().click(firstLetterIconLocator);
        getInstance().click(logoutLocator);
        return new LoginPage();
    }
}
