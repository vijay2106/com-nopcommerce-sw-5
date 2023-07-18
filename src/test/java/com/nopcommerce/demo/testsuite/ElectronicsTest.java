package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.ElectronicsPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class ElectronicsTest extends BaseTest {
    ElectronicsPage electronics;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        electronics = new ElectronicsPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        electronics.mouseHoverOnElectronics();
        electronics.mouseHoverAndClickOnCellPhones();
        electronics.GetTextCellPhones();

        String expectedText = "Cell phones";
        String actualText = electronics.GetTextCellPhones();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        electronics.mouseHoverOnElectronics();
        Thread.sleep(1000);
        electronics.mouseHoverAndClickOnCellPhones();
        Thread.sleep(1000);
        electronics.GetTextCellPhones();
        Thread.sleep(1000);
        String expectedText = "Cell phones";
        String actualText = electronics.GetTextCellPhones();
        Assert.assertEquals(actualText, expectedText);
        Thread.sleep(1000);
        electronics.clickOnListViewTab();
        Thread.sleep(1000);
        electronics.clickOnNokiaLumia1020();
        Thread.sleep(1000);
        String expectedTextNokiaLumia = "Nokia Lumia 1020";
        String actualTextNokiaLumia = electronics.getTextNokiaLumia1020();
        Assert.assertEquals(expectedTextNokiaLumia, actualTextNokiaLumia);
        Thread.sleep(1000);
        String expectedPrice = "$349.00";
        String actualPrice = electronics.getToVerifyThePrice();
        Assert.assertEquals(expectedPrice, actualPrice);
        Thread.sleep(1000);
        electronics.changeQuantityTo2();
        Thread.sleep(1000);
        electronics.clickAddToCart();
        Thread.sleep(1000);
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = electronics.getToVerifyTheMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
        Thread.sleep(1000);
        electronics.closeTheBarClickingOnTheCrossButton();
        Thread.sleep(1000);
        electronics.mouseHoverShoppingCart();
        Thread.sleep(1000);
        electronics.clickToGoCart();
        Thread.sleep(1000);
        String expectedShoppingCartText = "Shopping cart";
        String actualShoppingCartText = electronics.getShoppingCartMessage();
        Assert.assertEquals(expectedShoppingCartText, actualShoppingCartText);

        Thread.sleep(1000);
        //   String expectedShoppingCartQuantity = "2";
        //  String actualShoppingCartQuantity = electronics.getVerifyTheQuantity();
        //  Assert.assertEquals(expectedShoppingCartQuantity, actualShoppingCartQuantity);

        String expectedTotalValue = "$698.00";
        String actualTotalValue = electronics.getToVerifyTheTotal();
        Assert.assertEquals(expectedTotalValue, actualTotalValue);
        Thread.sleep(1000);
        electronics.clickToCheckBox();
        Thread.sleep(1000);
        electronics.clickToCheckOut();
        Thread.sleep(1000);
        String expectedWelcomeMessage = "Welcome, Please Sign In!";
        String actualWelcomeMessage = electronics.getToVerifyWelcomeMessage();
        Assert.assertEquals(expectedWelcomeMessage, actualWelcomeMessage);
        Thread.sleep(1000);
        electronics.clickOnRegister();
        Thread.sleep(1000);
        String expectedRegisterMessage = "Register";
        String actualRegisterMessage = electronics.getToVerifyRegisterText();
        Assert.assertEquals(expectedRegisterMessage, actualRegisterMessage);
        Thread.sleep(1000);
        electronics.clickOnGenderField();
        Thread.sleep(1000);
        electronics.firstNameField("KKR");
        Thread.sleep(1000);
        electronics.lastNameField("RAM");
        Thread.sleep(1000);
        electronics.emailField("VIJAY@gmail.com");
        Thread.sleep(1000);
        electronics.passwordField("BHA@21");
        Thread.sleep(1000);
        electronics.confirmPasswordField("Bha@21");
        Thread.sleep(1000);
        electronics.clickOnRegisterTab();
        Thread.sleep(1000);
        electronics.getToVerifyRegisteraionComplete();
        Thread.sleep(1000);
        electronics.clickOnContinueAfterRegistration();
        Thread.sleep(1000);
        // Login again because cart is empty
        electronics.clickOnLoginAbove();
        Thread.sleep(1000);
        electronics.inputOnEmailLoginField("Vijay@gmail.com");
        Thread.sleep(1000);
        electronics.inputOnPasswordLoginField("Bha@111");
        Thread.sleep(1000);
        electronics.clickOnLoginButton();
        Thread.sleep(1000);
        String expectedShoppingCartMessage = "Shopping cart";
        String actualShoppingCartMessage = electronics.getToVerifyShoppingCartText();
        Assert.assertEquals(expectedShoppingCartMessage, actualShoppingCartMessage);
        Thread.sleep(1000);
        electronics.clickOnCheckBox();
        Thread.sleep(1000);
        electronics.clickOnFinalCheckOut();
        Thread.sleep(2000);
        // 2.27 Fill the Mandatory fields
        electronics.selectCountryField("7");
        Thread.sleep(2000);
        electronics.selectStateField("21");
        Thread.sleep(2000);
        electronics.inputOnCityField("London");
        Thread.sleep(2000);
        electronics.inputOnAddressField("harrow");
        Thread.sleep(2000);
        electronics.inputOnPostalField("789456");
        Thread.sleep(2000);
        electronics.inputOnPhoneNumber("1597534569");
        Thread.sleep(2000);
        electronics.clickOnContinueAfterAllMandatoryFields();
        electronics.clickOnShipping2Option();
        electronics.clickOnContinueButtonAfterSelectingShippingOption();
        // 2.31 Select Radio Button “Credit Card”
        electronics.clickOnRadioButton();
        electronics.continueAfterCreditCard();

        electronics.selectCreditCardType("visa");
        electronics.inputCardHolderName("Bha jkj");
        electronics.inputCardNumberField("753159456987123");
        electronics.selectExpiryDateField("3");
        electronics.selectExpiryYearField("2025");
        electronics.inputCreditCardCode("786");
        //2.34 Click on “CONTINUE”
        electronics.continueAftersSuccessfullyProcessed();
        //2.35 Verify “Payment Method” is “Credit Card”
        String expectedPaymentMethodMessage = "Payment Method: Credit Card";
        String actualPaymentMethodMessage = electronics.getToVerifyPaymentMethodByCard();
        Assert.assertEquals(expectedPaymentMethodMessage, actualPaymentMethodMessage);

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String expectedShippingMethodMessage = "Shipping Method: 2nd Day Air";
        String actualShippingMethodMessage = electronics.getToVerifyShippingMethod();
        Assert.assertEquals(expectedShippingMethodMessage, actualShippingMethodMessage);

        //2.37 Verify Total is “$698.00”

        String expectedTotalFinalPayment = "$698.00";
        String actualTotalFinalPayment = electronics.getToVerifyTotalFinalAmount();
        Assert.assertEquals(expectedTotalFinalPayment, actualTotalFinalPayment);
        Thread.sleep(1000);
        //2.38 Click on “CONFIRM”
        electronics.clickOnConfirmAfterPayment();

        //2.39 Verify the Text “Thank You”
        Thread.sleep(1000);
        String expectedThankYouMessage = "Thank you";
        String actualThankYouMessage = electronics.getToVerifyThankYouMessage();
        Assert.assertEquals(expectedThankYouMessage, actualThankYouMessage);


        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedSuccessfullyProcessed = "Your order has been successfully processed!";
        String actualSuccessfullyProcessed = electronics.getToVerifySuccessfullyProcessedMessage();
        Assert.assertEquals(expectedSuccessfullyProcessed, actualSuccessfullyProcessed);


        //2.41 Click on “CONTINUE”
        electronics.clickOnContinueAfterSuccessfullyMessage();

        //2.42 Verify the text “Welcome to our store”
        String expectedWelcomeToOurStoreMessage = "Welcome to our store";
        String actualWelcomeToOurStoreMessage = electronics.getToVerifyWelcomeToOurStoreMessage();
        Assert.assertEquals(expectedWelcomeToOurStoreMessage, actualWelcomeToOurStoreMessage);


        //2.43 Click on “Logout” link
        electronics.clickOnLogOut();
    }
}