package com.club.soft.scenario.junit;

import com.club.soft.scenario.framework.to.Account;
import com.club.soft.scenario.framework.to.Message;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class CloneTest {

    @Test
    @Parameters({"vital.test.600@gmail.com, testtest600, true"})
    public void cloneAccountNoChangeTest(String login, String password, boolean isEquals) {
        Account account = new Account().withLogin(login).withPassword(password).build();
        Account clone = account.clone();
        Assert.assertEquals(isEquals, clone.equals(account));
    }

    @Test
    @Parameters({"vital.test.600@gmail.com, testtest600, false"})
    public void cloneAccountChangeTest(String login, String password, boolean isEquals) {
        Account account = new Account().withLogin(login).withPassword(password).build();
        Account clone = account.clone();
        clone = clone.withLogin(password).withPassword(login);
        Assert.assertEquals(isEquals, clone.equals(account));
    }

    @Test
    @Parameters({"vital.test.600@gmail.com, job, hello, true"})
    public void cloneMessageNoChangeTest(String email, String topic, String text, boolean isEquals) {
        Message message = new Message().withEmail(email).withTopic(topic).withText(text).build();
        Message clone = message.clone();
        Assert.assertEquals(isEquals, clone.equals(message));
    }

    @Test
    @Parameters({"vital.test.600@gmail.com, job, hello, false"})
    public void cloneMessageChangeTest(String email, String topic, String text, boolean isEquals) {
        Message message = new Message().withEmail(email).withTopic(topic).withText(text).build();
        Message clone = message.clone();
        clone = clone.withEmail(topic);
        Assert.assertEquals(isEquals, clone.equals(message));
    }

}

