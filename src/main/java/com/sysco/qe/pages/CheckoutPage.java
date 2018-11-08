package com.sysco.qe.pages;

import com.sysco.qe.utils.PageBase;
import org.openqa.selenium.By;

public class CheckoutPage extends PageBase {

    private By txtFirstName = By.xpath("(//input[@name='firstname'])[1]");
    private By txtLastName = By.xpath("(//input[@name='lastname'])[1]");
    private By lblErrorMessage = By.xpath("//span[text()='This is a required field.']");
    private By btnContinue = By.xpath("//button[text()='Continue']");
    private By txtPostCode = By.xpath("(//span[text()='Post Code']/../..)[1]/div/input");
    private By txtPhoneNumber = By.xpath("(//span[text()='Phone Number']/../..)[1]/div/input");
    private By txtAddressLine1 = By.xpath("(//span[text()='Street Address Line 1']/../..)[1]/div/input");

    public String getFirstName(){
        syscoLabUI.waitTillElementLoaded(txtFirstName, 3000);
        return syscoLabUI.getAttribute(txtFirstName, "aria-describedby");
    }

    public String getLastName(){
        return syscoLabUI.getText(txtLastName);
    }

    public void clickContinueBtn(){
        syscoLabUI.waitTillElementLoaded(btnContinue, 3000);
        syscoLabUI.click(btnContinue);
    }

    public boolean isErrorMessagePresent(){
        if(syscoLabUI.isDisplayed(lblErrorMessage)==true){
            return true;
        }else{
            return false;
        }
    }

    public void enterPostCode(String postCode){
        syscoLabUI.clear(txtPostCode);
        syscoLabUI.sendKeys(txtPostCode, postCode);
        syscoLabUI.sleepInMiliSeconds(4000);
    }

    public void selectPostCode(String state){
        syscoLabUI.clickOnVisibleElement(By.xpath("//a[contains(text(),'"+state+"')]"));
    }

    public void enterPhoneNumber(String phoneNumber){
        syscoLabUI.sendKeys(txtPhoneNumber, phoneNumber);
    }

    public void enterStreetAddress(String streetAddress){
        syscoLabUI.sendKeys(txtAddressLine1, streetAddress);
    }
}
