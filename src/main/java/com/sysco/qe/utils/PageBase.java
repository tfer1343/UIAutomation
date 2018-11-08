package com.sysco.qe.utils;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.Capabilities;

public class PageBase {

    protected static SyscoLabUI syscoLabUI;

    public static void loadHomePage(Capabilities capabilities, String url) {
        syscoLabUI = new SyscoLabWUI(capabilities);
        syscoLabUI.navigateTo(url);
        syscoLabUI.driver.manage().window().maximize();
    }

    public void quitDriver() {
        if (syscoLabUI != null) {
            syscoLabUI.quit();
        }
    }
}
