package com.atqa2020nromanchuk.pages;

import com.atqa2020nromanchuk.framework.SubMenu;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ElectronicsPage extends Page {
    private SubMenu subMenu;

    public ElectronicsPage(RemoteWebDriver driver) {
        super(driver);
        this.subMenu = new SubMenu(driver);
    }

    public <T extends Page> T navigateToComputerAndAccessoriesPage(Class<T> clazz) throws Exception {
        return subMenu.clickOnComputersAndAccessoriesFromTopMenu(clazz);
    }
}
