package com.atqa2020nromanchuk.pages;

import com.atqa2020nromanchuk.framework.Header;
import com.atqa2020nromanchuk.framework.LeftDropDownMenu;
import com.atqa2020nromanchuk.framework.MainMenu;
import com.atqa2020nromanchuk.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePage extends Page {

    private Header header;
    private LeftDropDownMenu leftMenu;

    public HomePage(RemoteWebDriver driver) {
        super(driver);
        this.header = new Header(driver);
        this.leftMenu = new LeftDropDownMenu(driver);
    }

    public <T extends Page> T searchForItem(Class<T> clazz, String searchTerm) throws Exception {
        return header.setSearchTerm(searchTerm).clickOnSearchButton(clazz);
    }

    public <T extends Page> T navigateToNewLowerPricesPage(Class<T> clazz) throws Exception {
        return header.clickOnProductsMenuButton().navigateNewLowerPricesPage(clazz);
    }

    public <T extends Page> T navigateToDesignInteriorCentrePage(Class<T> clazz) throws Exception {
        return header.clickOnDesignInteriorCentreButton(clazz);
    }

    public HomePage navigateToLeftDropDownMenu() throws Exception {
        header.clickOnAllButton();
        return this;
    }

    public <T extends Page> T navigateToNewReleasesPage(Class<T> clazz) throws Exception {
        return leftMenu.clickOnNewReleasesButton(clazz);
    }

    public <T extends Page> T navigateToNewReleasesPageFromTopMenu(Class<T> clazz) throws Exception {
        return header.clickOnNewReleasesButtonFromTopMenu(clazz);
    }

    public HomePage acceptCoockies() throws Exception {
        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();
        return this;
    }

    public <T extends Page> T navigateToElectronicsPage(Class<T> clazz) throws Exception {
        return header.clickOnElectronicsFromTopMenu(clazz);
    }
}
