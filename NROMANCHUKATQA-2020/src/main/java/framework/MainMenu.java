package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.Page;

public class MainMenu {
    protected RemoteWebDriver driver;
    private String newLowerPricesLinkLocator = "//body/aside/div[2]/nav[@class='hnf-menu__nav2']/ul/li[2]/a";

    // private String productsButton = "//body[1]/aside[1]/div[2]/nav[1]/ul[1]/li[1]/a[1]";
    // private String productsButton = "//div[@id='onetrust-banner-sdk']";

    public MainMenu(final RemoteWebDriver driver) {
        this.driver = driver;
    }



    public <T extends Page> T navigateNewLowerPricesPage(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(newLowerPricesLinkLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }
}
