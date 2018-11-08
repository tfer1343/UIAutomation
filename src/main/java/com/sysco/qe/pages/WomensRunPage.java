package com.sysco.qe.pages;

import com.sysco.qe.utils.PageBase;
import org.openqa.selenium.By;

public class WomensRunPage extends PageBase {

    public void clickProductItem(String itemName){
        syscoLabUI.clickOnVisibleElement(By.xpath("//a[contains(text(),'"+itemName+"')]"));
    }
}
