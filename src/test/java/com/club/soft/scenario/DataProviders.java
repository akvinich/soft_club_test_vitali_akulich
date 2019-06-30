package com.club.soft.scenario;

import com.club.soft.scenario.framework.to.Account;
import com.club.soft.scenario.framework.to.Message;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "Valid data for login")
    public static Object[][] validAccount() {
        return new Object[][] {
                {new Account()
                        .withLogin("vas.petr.new1@gmail.com").withPassword("vaspetr600").build() },

        };
    }

    @DataProvider(name = "New message")
    public static Object[][] newMessage() {
        return new Object[][] {
                {new Message()
                        .withEmail("vas.petr.new1@gmail.com")
                        .withTopic("job")
                        .withText("hello")
                        .build() },
        };
    }
}
