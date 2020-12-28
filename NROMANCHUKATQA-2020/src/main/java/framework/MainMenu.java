package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.Page;

public class MainMenu {

    private String productsLowerTwentyButtonLocator = "//body/aside/div[2]/nav[2]/ul/li[3]/a";
    protected RemoteWebDriver driver;
    private String newLowerPricesLinkLocator = "//body/aside/div[2]/nav[@class='hnf-menu__nav2']/ul/li[2]/a";


    public MainMenu( RemoteWebDriver driver) {
        this.driver = driver;
    }



    public <T extends Page> T navigateNewLowerPricesPage(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(newLowerPricesLinkLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }
     public <T extends Page> T navigateProductsLowerTwenty(Class<T> clazz) throws Exception{
        driver.findElement(By.xpath(productsLowerTwentyButtonLocator)).click();
        return PageFactory.newPage(driver,clazz);
     }

}
