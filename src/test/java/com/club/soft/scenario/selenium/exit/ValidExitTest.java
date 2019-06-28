package com.club.soft.scenario.selenium.exit;

import com.club.soft.scenario.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class ValidExitTest extends BaseAccountTest {

    @Test
    public void checkExitTest() {
        Assert.assertEquals(mainMailPage.logOut().isOnThisPage(), true);
    }
}
