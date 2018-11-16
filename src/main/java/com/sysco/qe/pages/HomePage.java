package com.sysco.qe.pages;
import com.sysco.qe.utils.PageBase;
import org.openqa.selenium.By;

public class HomePage extends PageBase {

    private By lnkLogin = By.xpath("//a[text()='Login']");
    private By lblAccountUserName = By.xpath("//a[text()='My account']/../../li[2]/span/span");
    private By lblMiniCart = By.xpath("//div[@class='minicart-wrapper']");
    private By lnkViewCart = By.xpath("//div[@class='minicart-bottom']/div/a");
    private By lblMiniCartItemCount = By.xpath("//div[@class='minicart-wrapper']/span/span");
    private By lnkProductItem = By.xpath("(//a[@class='product-item-link'])[5]");
    private String lnkCategoryName = "//a[text()='CATEGORY']";
    private String lnkSubCategoryName = "//a[@title='CATEGORY']/following::a[text()='SUBCATEGORY']";

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
        return syscoLabUI.getAttribute(lblMiniCartItemCount, "class");
    }

    public void clickCategory(String categoryName){
        syscoLabUI.click(By.xpath(lnkCategoryName.replace("CATEGORY", categoryName)));
    }

    public void clickSubCategory(String categoryName, String subCategoryName){
        syscoLabUI.click(By.xpath((lnkSubCategoryName.replaceFirst("CATEGORY", categoryName)).replace("SUBCATEGORY", subCategoryName)));
    }
}
