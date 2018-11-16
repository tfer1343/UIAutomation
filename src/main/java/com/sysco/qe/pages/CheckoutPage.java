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
    private By txtAddressLine1 = By.xpath("//span[text()='Street Address Line 1']//following::input");
    private String txtState = "//a[contains(text(),'STATE')]";

    public String getFirstName(){
        syscoLabUI.waitTillElementLoaded(txtFirstName, 3000);
        return syscoLabUI.getValue(txtFirstName).trim();
    }

    public String getLastName(){
        return syscoLabUI.getValue(txtLastName);
    }

    public void clickContinueBtn(){
        syscoLabUI.waitTillElementLoaded(btnContinue, 3000);
        syscoLabUI.click(btnContinue);
    }

    public boolean isErrorMessagePresent(){
        return syscoLabUI.isDisplayed(lblErrorMessage);
    }

    public void enterPostCode(String postCode){
        syscoLabUI.clear(txtPostCode);
        syscoLabUI.waitTillElementLoaded(txtPostCode);
        syscoLabUI.sendKeys(txtPostCode, postCode);
    }

    public void selectPostCode(String state){
        syscoLabUI.waitTillElementLoaded(By.xpath(txtState.replace("STATE", state)), 5000);
        syscoLabUI.clickOnVisibleElement(By.xpath(txtState.replace("STATE", state)));
    }

    public void enterPhoneNumber(String phoneNumber){
        syscoLabUI.sendKeys(txtPhoneNumber, phoneNumber);
    }

    public void enterStreetAddress(String streetAddress){
        syscoLabUI.sendKeys(txtAddressLine1, streetAddress);
    }
}
