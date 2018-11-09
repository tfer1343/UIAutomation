package com.sysco.qe.pages;

import com.sysco.qe.utils.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewCartPage extends PageBase {

    private By lblCartRemoveIcon = By.xpath("//tbody[@class=\"cart item\"]/tr/td/div/a[2]");
    private By lblProductName = By.xpath("//div[@class='item-details']/strong/a");
    private By lblUnitPrice = By.xpath("//td[@class='col price']/span/span/span");
    private By btnSecureCheckout = By.xpath("//button[@title='Proceed to Checkout']");
    int i=1;

    public void removeCartItems(){
        List<WebElement> noOfCartItems = syscoLabUI.getDriver().findElementsByClassName("item-info");
        for (WebElement items : noOfCartItems) {
            items = noOfCartItems.get(i-1);
            i++;
            syscoLabUI.waitTillElementLoaded(lblCartRemoveIcon, 3000);
            syscoLabUI.click(lblCartRemoveIcon);
        }
    }

    public String getProductName(){
        syscoLabUI.waitTillElementLoaded(lblProductName, 3000);
        return syscoLabUI.getText(lblProductName);
    }

    public String getUnitPrice(){
        return syscoLabUI.getText(lblUnitPrice);
    }

    public void clickSecureCheckout(){
        syscoLabUI.click(btnSecureCheckout);
    }

}
