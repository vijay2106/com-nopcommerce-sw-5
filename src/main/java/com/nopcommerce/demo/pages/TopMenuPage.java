package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;



    public class TopMenuPage extends Utility {

        @CacheLookup
        @FindBy(xpath = "//ul[@class='top-menu notmobile']")
        List<WebElement> topMenuTab;
        @CacheLookup
        @FindBy(xpath = "//h1[contains(text(),'Computers')]")
        WebElement computerText;

        public String verifyComputerText() {
            Reporter.log("Get text Computer" + computerText.toString());
            CustomListeners.test.log(Status.PASS, "Get text Computer");
            return getTextFromElement(computerText);
        }
        public void selectMenu(String menu) {
            try {
                List<WebElement> list = topMenuTab;
                for (WebElement listOfElement : list) {
                    if (listOfElement.getText().equals(menu)) {
                        listOfElement.click();
                    }
                }
            } catch (StaleElementReferenceException e) {
                List<WebElement> list = topMenuTab;
            }
            CustomListeners.test.log(Status.PASS, "Click on Top Menu");
            Reporter.log("Click on Top Menu" + topMenuTab.toString());
        }
    }

