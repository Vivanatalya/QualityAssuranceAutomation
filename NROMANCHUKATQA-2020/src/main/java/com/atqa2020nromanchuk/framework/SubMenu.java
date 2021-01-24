package com.atqa2020nromanchuk.framework;

import com.atqa2020nromanchuk.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SubMenu {

    protected RemoteWebDriver driver;
    private String computersAndAccessoriesButtonLocator = "//div[@id='nav-subnav']//span[contains(text(), 'Computers & Accessories')]//parent::a";
    private String monitorsButtonLocator = "//div[@id='nav-subnav']//span[contains(text(), 'Monitors')]//parent::a";

    public SubMenu(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public <T extends Page> T clickOnComputersAndAccessoriesFromTopMenu(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(computersAndAccessoriesButtonLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }

    public <T extends Page> T clickOnMonitorsButton(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(monitorsButtonLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }
}
