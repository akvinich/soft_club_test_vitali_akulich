package com.club.soft.scenario.selenium.mail;

import com.club.soft.scenario.DataProviders;
import com.club.soft.scenario.framework.to.Message;
import com.club.soft.scenario.selenium.BaseAccountTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class SendMailTest extends BaseAccountTest {

    @Test(dataProvider = "New message", dataProviderClass = DataProviders.class)
    public void checkMessageSendingTest(Message message) {
        mainMailPage.openMessageForm().typeEmail(message.getEmail()).typeTopic(message.getTopic())
                .typeText(message.getText()).sendMessage().isMailSent();
    }

    @AfterClass
    public void exit() {
        Assert.assertEquals(mainMailPage.logOut().isOnThisPage(), true);
    }
}
