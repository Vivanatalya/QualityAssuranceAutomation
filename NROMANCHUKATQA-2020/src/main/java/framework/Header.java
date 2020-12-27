package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.Page;

public class Header {

    protected RemoteWebDriver driver;


    private String searchFieldLocator = "//input";
    private String searchButtonLocator = "//span/button[@id='search-box__searchbutton']";

    private String productsButtonLocator = "//header/div/div/div/nav/ul/li[1]/a";
    private String newLowerPricesLinkLocator = "//body/aside/div[2]/nav[@class='hnf-menu__nav2']/ul/li[2]/a";

    private String designInteriorCentreButtonLocator = "//header/div/div/div/nav/ul/li[3]/a";

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


    public Header clickOnProductsMenuButton() throws Exception {
        driver.findElement(By.xpath(productsButtonLocator)).click();
        return this;
    }

    public <T extends Page> T navigateNewLowerPricesPage(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(newLowerPricesLinkLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }

    public <T extends Page> T clickOnDesignInteriorCentreButton(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(designInteriorCentreButtonLocator)).click();
        return PageFactory.newPage(driver, clazz);

    }
}
