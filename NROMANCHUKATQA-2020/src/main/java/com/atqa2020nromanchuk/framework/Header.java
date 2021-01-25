package com.atqa2020nromanchuk.framework;

import com.atqa2020nromanchuk.pages.NewReleasesPage;
import com.atqa2020nromanchuk.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Header {
    protected RemoteWebDriver driver;
    private String searchFieldLocator = "//input";
    private String searchButtonLocator = "//span/button[@id='search-box__searchbutton']";
    private String productsButtonLocator = "//header/div/div/div/nav/ul/li[1]/a";
    private String newLowerPricesLinkLocator = "//body/aside/div[2]/nav[@class='hnf-menu__nav2']/ul/li[2]/a";
    private String designInteriorCentreButtonLocator = "//header/div/div/div/nav/ul/li[3]/a";
    private String productsLowerTwentyButtonLocator = "//body/aside/div[2]/nav[2]/ul/li[3]/a";
    private String allButtonLocator = "//div[@class='nav-left']/a";
    private String newReleasesTopMenuButtonLocator = "//div[@id='nav-xshop']/a[contains(text(),'New Releases')]";
    private String electronicsTopMenuButtonLocator= "//div[@id='nav-xshop']/a[contains(text(),'Electronics')]";



    public Header(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public Header setSearchTerm(String searchTerm) {
        driver.findElement(By.xpath(searchFieldLocator)).sendKeys(searchTerm);
        return this;
    }

    public <T extends Page> T clickOnSearchButton(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(searchButtonLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }


    public <T extends Page> T navigateNewLowerPricesPage(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(newLowerPricesLinkLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }

    public <T extends Page> T clickOnDesignInteriorCentreButton(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(designInteriorCentreButtonLocator)).click();
        return PageFactory.newPage(driver, clazz);

    }

    public Header clickOnProductsMenuButton() {
        driver.findElement(By.xpath(productsButtonLocator)).click();
        return this;
    }

    public <T extends Page> T navigateProductsLowerTwenty(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(productsLowerTwentyButtonLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }

    public Header clickOnAllButton() {
        driver.findElementByXPath(allButtonLocator).click();
        return this;
    }

    public <T extends Page> T navigateToNewReleasesPage(Class<T> clazz) throws Exception {
        return PageFactory.newPage(driver, clazz);
    }

    public <T extends Page> T clickOnNewReleasesButtonFromTopMenu(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(newReleasesTopMenuButtonLocator)).click();
        return PageFactory.newPage(driver,clazz);
    }


    public <T extends Page> T clickOnElectronicsFromTopMenu(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(electronicsTopMenuButtonLocator)).click();
        return PageFactory.newPage(driver,clazz);
    }



}
