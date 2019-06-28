package com.club.soft.scenario.junit;

import com.club.soft.scenario.framework.to.Account;
import com.club.soft.scenario.framework.to.Message;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ComparableTest {

    @Test
    @Parameters({"xxxxxxx, xxx, yy, yy, true"})
    public void compareAccountPositiveTest(String loginX, String passwordX,
                                           String loginY, String passwordY,  boolean isEquals) {
        Account accountX = new Account().withLogin(loginX).withPassword(passwordX).build();
        Account accountY = new Account().withLogin(loginY).withPassword(passwordY).build();
        Assert.assertEquals(isEquals, accountX.compareTo(accountY) > 0);
    }

    @Test
    @Parameters({"xx, xx, yy, yy, true"})
    public void compareAccountEqualsTest(String loginX, String passwordX,
                                           String loginY, String passwordY,  boolean isEquals) {
        Account accountX = new Account().withLogin(loginX).withPassword(passwordX).build();
        Account accountY = new Account().withLogin(loginY).withPassword(passwordY).build();
        Assert.assertEquals(isEquals, accountX.compareTo(accountY) == 0);
    }

    @Test
    @Parameters({"x, xx, yy, yy, true"})
    public void compareAccountNegativeTest(String loginX, String passwordX,
                                         String loginY, String passwordY,  boolean isEquals) {
        Account accountX = new Account().withLogin(loginX).withPassword(passwordX).build();
        Account accountY = new Account().withLogin(loginY).withPassword(passwordY).build();
        Assert.assertEquals(isEquals, accountX.compareTo(accountY) < 0);
    }

    @Test
    @Parameters({"xxxxxxx, xxx, xx, yy, yy, yy, true"})
    public void compareMessagePositiveTest(String emailX, String topicX, String textX,
                                           String emailY, String topicY, String textY,  boolean isEquals) {
        Message messageX = new Message().withEmail(emailX).withTopic(topicX).withText(textX).build();
        Message messageY = new Message().withEmail(emailY).withTopic(topicY).withText(textY).build();
        Assert.assertEquals(isEquals, messageX.compareTo(messageY) > 0);
    }

    @Test
    @Parameters({"xx, xx, xx, yy, yy, yy, true"})
    public void compareMessageEqualsTest(String emailX, String topicX, String textX,
                                           String emailY, String topicY, String textY,  boolean isEquals) {
        Message messageX = new Message().withEmail(emailX).withTopic(topicX).withText(textX).build();
        Message messageY = new Message().withEmail(emailY).withTopic(topicY).withText(textY).build();
        Assert.assertEquals(isEquals, messageX.compareTo(messageY) == 0);
    }

    @Test
    @Parameters({"x, xx, xx, yy, yy, yy, true"})
    public void compareMessageNegativeTest(String emailX, String topicX, String textX,
                                         String emailY, String topicY, String textY,  boolean isEquals) {
        Message messageX = new Message().withEmail(emailX).withTopic(topicX).withText(textX).build();
        Message messageY = new Message().withEmail(emailY).withTopic(topicY).withText(textY).build();
        Assert.assertEquals(isEquals, messageX.compareTo(messageY) < 0);
    }
}
