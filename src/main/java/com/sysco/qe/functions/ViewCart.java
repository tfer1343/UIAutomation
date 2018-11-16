package com.sysco.qe.functions;

import com.sysco.qe.data.HomeData;
import com.sysco.qe.pages.HomePage;
import com.sysco.qe.pages.ViewCartPage;
import com.sysco.qe.utils.Log;

public class ViewCart {

    public static ViewCartPage viewCartPage = new ViewCartPage();
    public static HomePage homePage = new HomePage();

    public static void removeCartItemsIfExists(){
        if(homePage.checkCartItemsExists().equalsIgnoreCase(HomeData.emptyMiniCartClassName)){
            Log.logInfo("Cart is empty!");
        }else if(homePage.checkCartItemsExists().equalsIgnoreCase(HomeData.miniCartClassName)){
            homePage.clickCartIcon();
            homePage.clickViewCartBtn();
            viewCartPage.removeCartItems();
        }
    }

    public static void selectViewCart(){
        homePage.clickCartIcon();
        homePage.clickViewCartBtn();
    }
    
    public static String getProductName(){
        return viewCartPage.getProductName();
    }

    public static String getUnitPrice(){
        return viewCartPage.getUnitPrice();
    }

    public static void clickSecureCheckout(){
        viewCartPage.clickSecureCheckout();
    }
}
