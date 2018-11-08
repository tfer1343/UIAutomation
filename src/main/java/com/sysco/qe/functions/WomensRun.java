package com.sysco.qe.functions;

import com.sysco.qe.pages.WomensRunPage;

public class WomensRun {

    public static WomensRunPage womensRunPage = new WomensRunPage();

    public static void clickProductItem(){
        womensRunPage.clickProductItem();
    }
}
