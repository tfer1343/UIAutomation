package com.sysco.qe.tests;

import com.sysco.qe.functions.*;
import com.sysco.qe.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TheAthletesFootCheckoutTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    SoftAssert  softAssert= new SoftAssert();

    @Test()
    public void testTheAthletesFootInvalidLogin() throws Exception {

        Home.loadHomePage();
        Home.clickLoginLink();
        softAssert.assertTrue(Login.verifyLoginButton(),"Login button loaded");
        Login.theAthletesFootLogin("williamjacob802@gmail.com","12345678");
        softAssert.assertEquals(Login.loginErrorMessage(), "YOU DID NOT SIGN IN CORRECTLY OR YOUR ACCOUNT IS TEMPORARILY DISABLED.");
        softAssert.assertAll();
        Home.quiteDriver();
    }

    @Test()
    public void testTheAthletesFootCheckout() throws Exception{
        Home.loadHomePage();
        Home.clickLoginLink();
        softAssert.assertTrue(Login.verifyLoginButton(),"Login button loaded");
        Login.theAthletesFootLogin("williamjacob802@gmail.com","0okmNHY6");
        softAssert.assertEquals(Home.accountUserName(),"WILLIAM JACOB");
        ViewCart.removeCartItemsIfExists();
        Home.selectCategory("Womens","Run");
        WomensRun.clickProductItem("SAUCONY GUIDE ISO WOMENS SLATE PEACH");
        String expectedProductName = RightPanel.getProductName();
        String expectedUnitPrice = RightPanel.getUnitPrice();
        RightPanel.selectSize("7");
        RightPanel.clickAddToCart();
        ViewCart.selectViewCart();
        softAssert.assertEquals(ViewCart.getProductName(), expectedProductName);
        softAssert.assertEquals(ViewCart.getUnitPrice(), expectedUnitPrice);
        ViewCart.clickSecureCheckout();
        softAssert.assertEquals(Checkout.getFirstName(), "william");
        softAssert.assertEquals(Checkout.getLastName(), "jacob");
        Checkout.clickContinueButton();
        softAssert.assertTrue(Checkout.isErrorMessagePresent(), "Error message displayed!");
        Checkout.enterStreetAddress("Barangaroo Avenue");
        Checkout.selectPostCode("2000", "BARANGAROO New South Wales");
        Checkout.enterPhoneNumber("112345678");
        Checkout.clickContinueButton();
        Payment.clickCreditCardRadioBtn();
        Payment.enterCreditCardDetails("555555555555444", "10", "2018");
        RightPanel.clickPlaceOrder();
        softAssert.assertEquals(Payment.getErrorMessageCC(), "PLEASE, ENTER VALID CREDIT CARD NUMBER");
        softAssert.assertEquals(Payment.getErrorMessageMonth(), "PLEASE, ENTER VALID EXPIRATION DATE");
        softAssert.assertEquals(Payment.getErrorMessageYear(), "PLEASE, ENTER VALID EXPIRATION DATE");
        softAssert.assertAll();
        Home.quiteDriver();
    }
}
