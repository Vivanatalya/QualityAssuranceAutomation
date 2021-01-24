package com.atqa2020nromanchuk.pages;

import com.atqa2020nromanchuk.framework.Header;
import com.atqa2020nromanchuk.framework.SubMenu;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ComputersAndAccessoriesPage extends Page {

    private SubMenu subMenu;

    public ComputersAndAccessoriesPage(RemoteWebDriver driver) {
        super(driver);
        this.subMenu = new SubMenu(driver);
    }

    public <T extends Page> T navigateToMonitorsPage(Class<T> clazz) throws Exception {
        return subMenu.clickOnMonitorsButton(clazz);
    }

}
