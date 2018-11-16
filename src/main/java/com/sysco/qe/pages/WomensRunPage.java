package com.sysco.qe.pages;

import com.sysco.qe.utils.PageBase;
import org.openqa.selenium.By;

public class WomensRunPage extends PageBase {

    private String lnkProductItemName = "//a[contains(text(),'ITEM')]";
    public void clickProductItem(String itemName){
        syscoLabUI.clickOnVisibleElement(By.xpath(lnkProductItemName.replace("ITEM", itemName)));
    }
}
