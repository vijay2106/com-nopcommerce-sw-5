package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.TopMenuPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {
    TopMenuPage topMenu = new TopMenuPage();


    @Test(groups = {"regression"})
    public void verifyPageNavigation() {
        topMenu.selectMenu("Computers");
        String expectedMessage = "Computers";
        String actualMessage = topMenu.verifyComputerText();
        Assert.assertEquals(actualMessage, expectedMessage, "Computers page not display");
    }
}
