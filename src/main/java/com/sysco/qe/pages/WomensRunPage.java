package com.sysco.qe.pages;

import com.sysco.qe.utils.PageBase;
import org.openqa.selenium.By;

public class WomensRunPage extends PageBase {

    private By lnkProductItem = By.xpath("//a[@class='product-item-link']");

    public void clickProductItem(){
        syscoLabUI.clickOnVisibleElement(lnkProductItem);
    }
}
