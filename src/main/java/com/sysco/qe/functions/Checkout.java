package com.sysco.qe.functions;

import com.sysco.qe.pages.CheckoutPage;

public class Checkout {

    public static CheckoutPage checkoutPage = new CheckoutPage();

    public static String getFirstName(){
        return checkoutPage.getFirstName();
    }

    public static String getLastName(){
        return checkoutPage.getLastName();
    }

    public static void clickContinueButton(){
        checkoutPage.clickContinueBtn();
    }

    public static boolean isErrorMessagePresent(){
        return checkoutPage.isErrorMessagePresent();
    }

    public static void selectPostCode(String postCode, String state){
        checkoutPage.enterPostCode(postCode);
        checkoutPage.selectPostCode(state);
    }

    public static void enterPhoneNumber(String phoneNumber){
        checkoutPage.enterPhoneNumber(phoneNumber);
    }

    public static void enterStreetAddress(String streetAddress){
        checkoutPage.enterStreetAddress(streetAddress);
    }

}
