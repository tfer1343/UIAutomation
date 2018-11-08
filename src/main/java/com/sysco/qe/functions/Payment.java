package com.sysco.qe.functions;

import com.sysco.qe.pages.PaymentPage;

public class Payment {

    public static PaymentPage paymentPage = new PaymentPage();

    public static void enterCreditCardDetails(String cardNo, String month, String year){
        paymentPage.enterCardNumber(cardNo);
        paymentPage.enterMonth(month);
        paymentPage.enterYear(year);
    }

    public static String getErrorMessageCC(){
        return paymentPage.getErrorMessageCC();
    }

    public static String getErrorMessageMonth(){
        return paymentPage.getErrorMessageMonth();
    }

    public static String getErrorMessageYear(){
        return paymentPage.getErrorMessageYear();
    }

    public static void clickCreditCardRadioBtn(){
        paymentPage.clickCreditCardBtn();
    }
}
