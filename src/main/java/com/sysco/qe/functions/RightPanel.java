package com.sysco.qe.functions;

import com.sysco.qe.pages.RightPanelPage;

public class RightPanel {

    public static RightPanelPage rightPanelPage = new RightPanelPage();

    public static void clickAddToCart(){
        rightPanelPage.clickAddToCartButton();
    }

    public static void selectSize(String size){
        rightPanelPage.clickProductSize(size);
    }

    public static String getProductName(){
        return rightPanelPage.getProductName();
    }

    public static String getUnitPrice(){
        return rightPanelPage.getProductPrice();
    }

    public static void clickPlaceOrder(){
        rightPanelPage.clickPlaceOrderButton();
    }
}
