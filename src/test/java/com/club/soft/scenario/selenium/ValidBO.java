package com.club.soft.scenario.selenium;

import com.club.soft.scenario.framework.to.Account;
import com.club.soft.scenario.framework.to.Message;

public class ValidBO {

    public static Account getAccount() {
        return new Account().withLogin("vital.test.600@gmail.com").withPassword("testtest600").build();
    }

    public static Message getMessage() {
        return new Message().withEmail("vital.test.600@gmail.com").withTopic("job").withText("hello").build();
    }
}
