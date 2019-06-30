package com.club.soft.scenario.google.pages;

import org.openqa.selenium.By;

import static com.club.soft.scenario.framework.util.Browser.*;

public class MainMailPage implements Page {

    private By firstLetterIconLocator = By.xpath("//a[contains(@href,'SignOutOptions')]");
    private By logoutLocator = By.xpath("//a[contains(@href,'Logout')]");
    private By writeButtonLocator = By.cssSelector("div[gh=cm]");
    private By topicLocator = By.cssSelector("input[name=subjectbox]");
    private By textLocator = By.cssSelector("div[role=textbox]");
    private By emailLocator = By.cssSelector("textarea[name=to]");
    private By sendLocator = By.cssSelector("table[role=group] div[role=button]:first-child");
    private By newMailLocator = By.cssSelector("div.UI table tr.zE");
    private By topicInMailLocator = By.cssSelector("tr h2.hP");
    private By textInMailLocator = By.cssSelector("tr div[role=listitem] div[dir=ltr]");

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

    public MainMailPage openReceivedMail() {
        getInstance().click(newMailLocator);
        return this;
    }

    public LoginPage logOut() {
        getInstance().click(firstLetterIconLocator);
        getInstance().click(logoutLocator);
        getInstance().acceptAlert();
        return new LoginPage();
    }

    public String getTopicOfReceivedMessage() {
        return getInstance().getText(textInMailLocator);
    }

    public String getTextOfReceivedMessage() {
        return getInstance().getText(topicInMailLocator);
    }
}
