package com.club.soft.scenario.selenium;

import com.club.soft.scenario.framework.to.Account;
import com.club.soft.scenario.framework.to.Message;

public class ValidBO {

    public static Account getAccount() {
        return new Account().withLogin("vas.petr.new1@gmail.com").withPassword("vaspetr600").build();
    }

    public static Message getMessage() {
        return new Message().withEmail("vas.petr.new1@gmail.com").withTopic("job").withText("hello").build();
    }
}
