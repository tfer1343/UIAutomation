package com.sysco.qe.functions;

import com.sysco.qe.common.Constants;
import com.sysco.qe.pages.HomePage;
import com.sysco.qe.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Home {

    public static HomePage homePage = new HomePage();

    public static void loadHomePage() {

        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            homePage.loadHomePage(capabilities, Constants.APP_URL);
            homePage.waitForLoginLink();
        } else {
            homePage.loadHomePage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
            homePage.waitForLoginLink();
        }
    }


    public static void quiteDriver() {
        homePage.quitDriver();
    }

    public static void clickLoginLink(){
        homePage.clickLoginLink();

    }

    public static String accountUserName(){
        return homePage.getAccountUserName();
    }

    public static void selectCategory(String parentMenu, String subMenu){
        homePage.clickCategory(parentMenu);
        homePage.clickSubCategory(subMenu);
    }

    public static void clickProductItem(){
        homePage.clickProductItem();
    }

    public static void goToHomePage(){
        homePage.goToHomePage();
    }
}
