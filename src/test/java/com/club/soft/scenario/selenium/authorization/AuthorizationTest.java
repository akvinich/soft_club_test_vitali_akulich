package com.club.soft.scenario.selenium.authorization;

import com.club.soft.scenario.DataProviders;
import com.club.soft.scenario.framework.to.Account;
import com.club.soft.scenario.google.pages.MainMailPage;
import com.club.soft.scenario.google.service.AccountService;
import com.club.soft.scenario.selenium.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationTest extends BaseTest {

    @Test(dataProvider = "Valid data for login", dataProviderClass = DataProviders.class)
    public void successfulAuthorizationTest(Account account) {
        new AccountService().logIn(account);
        Assert.assertEquals(new MainMailPage().isOnThisPage(), true);
    }
}
