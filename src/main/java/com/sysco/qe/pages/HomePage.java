package com.sysco.qe.pages;

import com.sysco.qe.utils.Log;
import com.sysco.qe.utils.PageBase;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

public class HomePage extends PageBase {

    private By lnkLogin = By.xpath("//a[text()='Login']");
    private By lblAccountUserName = By.xpath("//a[text()='My account']/../../li[2]/span/span");
    private By lblMiniCart = By.xpath("//div[@class='minicart-wrapper']");
    private By lnkViewCart = By.xpath("//span[text()='View Cart']/../..");
    private By lblMiniCartItemCount = By.xpath("//div[@class='minicart-wrapper']/span/span");
    private By lnkProductItem = By.xpath("(//a[@class='product-item-link'])[5]");
    private By lnkHomePage = By.xpath("//strong[@class='slogan']");

    public void waitForLoginLink(){
        syscoLabUI.waitTillElementLoaded(lnkLogin, 3000);
    }

    public void clickLoginLink(){
        syscoLabUI.click(lnkLogin);
    }

    public String getAccountUserName(){
        syscoLabUI.waitTillElementLoaded(lblAccountUserName, 3000);
        return syscoLabUI.getText(lblAccountUserName);
    }

    public void clickCartIcon(){
        syscoLabUI.waitTillElementLoaded(lblMiniCart, 3000);
        syscoLabUI.click(lblMiniCart);
    }

    public void clickViewCartBtn(){
        syscoLabUI.waitTillElementLoaded(lnkViewCart, 3000);
        syscoLabUI.clickOnVisibleElement(lnkViewCart);
    }

    public String checkCartItemsExists(){
        String counterQtyAttribute = syscoLabUI.getAttribute(lblMiniCartItemCount, "class");
        return counterQtyAttribute;
    }

    public void clickCategory(String categoryName){
        syscoLabUI.click(By.xpath("//a[text()='"+categoryName+"']"));
    }

    public void clickSubCategory(String subCategoryName){
        syscoLabUI.click(By.xpath("(//a[text()='"+subCategoryName+"'])[1]"));
    }

    public void clickProductItem(){
        syscoLabUI.scrollToElement(lnkProductItem);
        syscoLabUI.click(lnkProductItem);
    }

    public void goToHomePage(){
        if(!syscoLabUI.getCurrentURL().equalsIgnoreCase("https://www.theathletesfoot.com.au/")){
            syscoLabUI.clickOnVisibleElement(lnkHomePage);
        }
    }
}
