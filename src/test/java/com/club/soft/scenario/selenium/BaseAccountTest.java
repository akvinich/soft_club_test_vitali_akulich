package com.club.soft.scenario.selenium;

import com.club.soft.scenario.framework.to.Account;
import com.club.soft.scenario.google.pages.MainMailPage;
import com.club.soft.scenario.google.service.AccountService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class BaseAccountTest extends BaseTest {

    protected MainMailPage mainMailPage;

    protected Account account = ValidBO.getAccount();

    @BeforeClass
    public void login() {
        new AccountService().logIn(account);
        mainMailPage = new MainMailPage();
        Assert.assertEquals(mainMailPage.isOnThisPage(), true);
    }
}
