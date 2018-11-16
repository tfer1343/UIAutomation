package com.sysco.qe.tests;

import com.sysco.qe.data.*;
import com.sysco.qe.functions.*;
import com.sysco.qe.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TheAthletesFootCheckoutTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Online Shopping - Checkout");
    }

    SoftAssert  softAssert= new SoftAssert();

    @Test(priority = 1)
    public void testTheAthletesFootInvalidLogin() throws Exception {

        Home.loadHomePage();
        Home.clickLoginLink();
        softAssert.assertTrue(Login.verifyLoginButton(),"Login button loaded");
        Login.loginToAthletestFoot(LoginData.username,LoginData.invalidPassword);
        softAssert.assertEquals(Login.loginErrorMessage(), LoginData.loginErrorMessage);
        softAssert.assertAll();
        Home.quiteDriver();
    }

    @Test(priority = 2)
    public void testTheAthletesFootCheckout() throws Exception{
        Home.loadHomePage();
        Home.clickLoginLink();
        softAssert.assertTrue(Login.verifyLoginButton(),"Login button loaded");
        Login.loginToAthletestFoot(LoginData.username,LoginData.validPassword);
        softAssert.assertEquals(Home.accountUserName(), HomeData.expectedAccountUsername);
        ViewCart.removeCartItemsIfExists();
        Home.selectCategory(HomeData.parentMenuName,HomeData.subMenuName);
        WomensRun.clickProductItem(CategoryData.itemName);
        String expectedProductName = RightPanel.getProductName();
        String expectedUnitPrice = RightPanel.getUnitPrice();
        RightPanel.selectSize("7");
        RightPanel.clickAddToCart();
        ViewCart.selectViewCart();
        softAssert.assertEquals(ViewCart.getProductName(), expectedProductName);
        softAssert.assertEquals(ViewCart.getUnitPrice(), expectedUnitPrice);
        ViewCart.clickSecureCheckout();
        softAssert.assertEquals(Checkout.getFirstName(), CheckoutData.expectedFirstName);
        softAssert.assertEquals(Checkout.getLastName(), CheckoutData.expectedLastName);
        Checkout.clickContinueButton();
        softAssert.assertTrue(Checkout.isErrorMessagePresent(), "Error message displayed!");
        Checkout.enterStreetAddress(CheckoutData.streetAddress);
        Checkout.selectPostCode(CheckoutData.postCode, CheckoutData.state);
        Checkout.enterPhoneNumber(CheckoutData.phoneNumber);
        Checkout.clickContinueButton();
        Payment.clickCreditCardRadioBtn();
        Payment.enterCreditCardDetails(PaymentData.creditCardNumber, PaymentData.expiryMonth, PaymentData.expiryYear);
        RightPanel.clickPlaceOrder();
        softAssert.assertEquals(Payment.getErrorMessageCC(), PaymentData.expectedErrorMessageCC);
        softAssert.assertEquals(Payment.getErrorMessageMonth(), PaymentData.expectedErrorMessageMonth);
        softAssert.assertEquals(Payment.getErrorMessageYear(), PaymentData.expectedErrorMessageYear);
        softAssert.assertAll();
        Home.quiteDriver();
    }
}
