package com.sysco.qe.pages;

import com.sysco.qe.utils.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase {

    private By txtEmail = By.id("email");
    private By txtPassword = By.id("pass");
    private By btnLogin = By.id("send2");
    private By lblErrorMessage = By.xpath("//strong[text()='Join MyFit Rewards']/../../../../../../../div[2]/div/div/div/div");

    public WebElement loadLoginButton(){
        syscoLabUI.waitTillElementLoaded(btnLogin, 3000);
        return syscoLabUI.findElement(btnLogin);
    }

    public void enterUsername(String username){
        syscoLabUI.sendKeys(txtEmail, username);
    }

    public void enterPassword(String password){
        syscoLabUI.sendKeys(txtPassword, password);
    }

    public void clickLoginButton(){
        syscoLabUI.click(btnLogin);
    }

    public String getLoginErrorMessage(){
        syscoLabUI.waitTillElementLoaded(lblErrorMessage, 3000);
        return syscoLabUI.getText(lblErrorMessage);
    }

}
