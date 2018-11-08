package com.sysco.qe.pages;

import com.sysco.qe.utils.PageBase;
import org.openqa.selenium.By;

public class PaymentPage extends PageBase {

    private By txtCardNumber = By.id("credit-card-number");
    private By txtMonth = By.id("expiration-month");
    private By txtYear = By.id("expiration-year");
    private By lblErrorMsgCC = By.xpath("//span[text()='Card Number']/../../../div/div[2]/span");
    private By lblErrorMsgMonth = By.xpath("//div[@id='braintree_expirationMonth']/../div[2]/span");
    private By lblErrorMsgYear = By.xpath("//div[@id='braintree_expirationYear']/../div[2]/span");
    private By lblCreditCard = By.xpath("//strong[text()='Credit Card']");
    private By lblCardNumber = By.xpath("//span[text()='Card Number']/../../..");
    private By iframeCardNo = By.id("braintree-hosted-field-number");
    private By iframeExpirationMonth = By.id("braintree-hosted-field-expirationMonth");
    private By iframeExpirationYear = By.id("braintree-hosted-field-expirationYear");

    public void enterCardNumber(String cardNo){
        syscoLabUI.waitTillElementLoaded(lblCardNumber, 5000);
        syscoLabUI.switchToDefaultFrame();
        syscoLabUI.switchToFrame(iframeCardNo);
        syscoLabUI.clickOnVisibleElement(txtCardNumber);
        syscoLabUI.sendKeys(txtCardNumber, cardNo);
        syscoLabUI.switchToDefaultFrame();
    }

    public void enterMonth(String month){
        syscoLabUI.switchToDefaultFrame();
        syscoLabUI.switchToFrame(iframeExpirationMonth);
        syscoLabUI.clickOnVisibleElement(txtMonth);
        syscoLabUI.sendKeys(txtMonth, month);
        syscoLabUI.switchToDefaultFrame();
    }

    public void enterYear(String year){
        syscoLabUI.switchToDefaultFrame();
        syscoLabUI.switchToFrame(iframeExpirationYear);
        syscoLabUI.clickOnVisibleElement(txtYear);
        syscoLabUI.sendKeys(txtYear, year);
        syscoLabUI.switchToDefaultFrame();
    }

    public String getErrorMessageCC(){
        return syscoLabUI.getText(lblErrorMsgCC);
    }

    public String getErrorMessageMonth(){
        return syscoLabUI.getText(lblErrorMsgMonth);
    }

    public String getErrorMessageYear(){
        return syscoLabUI.getText(lblErrorMsgYear);
    }

    public void clickCreditCardBtn(){
        syscoLabUI.waitTillElementLoaded(lblCreditCard, 3000);
        syscoLabUI.clickOnVisibleElement(lblCreditCard);
    }
}
