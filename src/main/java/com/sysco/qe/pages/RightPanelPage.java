package com.sysco.qe.pages;

import com.sysco.qe.utils.PageBase;
import org.openqa.selenium.By;

public class RightPanelPage extends PageBase {

    private By lblProductName = By.xpath("//span[@class='base']");
    private By lblProductPrice = By.xpath("//span[@class='price']");
    private By btnAddToCart = By.id("product-addtocart-button");
    private By btnPlaceOrder = By.xpath("//button[text()='Place Order']");

    public String getProductName(){
        syscoLabUI.waitTillElementLoaded(lblProductName, 6000);
        return syscoLabUI.getText(lblProductName);
    }

    public String getProductPrice()
    {
        return syscoLabUI.getText(lblProductPrice);
    }

    public void clickAddToCartButton(){
        syscoLabUI.click(btnAddToCart);
    }

    public void clickProductSize(String size){
        syscoLabUI.clickOnVisibleElement(By.xpath("(//div[@option-label='"+size+"'])[2]"));
    }

    public void clickPlaceOrderButton(){
        syscoLabUI.click(btnPlaceOrder);
    }
}
