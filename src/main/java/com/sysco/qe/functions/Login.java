package com.sysco.qe.functions;

import com.sysco.qe.pages.LoginPage;

public class Login {

    public static LoginPage loginPage = new LoginPage();

    public static Boolean verifyLoginButton(){
        if(loginPage.loadLoginButton().isDisplayed()){
            return true;
        }else{
            return false;
        }
    }
    public static void loginToAthletestFoot(String username, String password){
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    public static String loginErrorMessage(){
        return loginPage.getLoginErrorMessage();
    }

}
