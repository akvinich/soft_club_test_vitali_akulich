package com.club.soft.scenario.google.service;

import com.club.soft.scenario.framework.to.Account;
import com.club.soft.scenario.google.pages.LoginPage;

public class AccountService {

    public void logIn(Account account) {
        LoginPage loginPage = new LoginPage().open();
        if (loginPage.isOnThisPage()) {
            loginPage.fillLoginField(account.getLogin()).clickLoginButton()
                    .fillPasswordField(account.getPassword()).clickPasswordButton();
        }
    }
}
