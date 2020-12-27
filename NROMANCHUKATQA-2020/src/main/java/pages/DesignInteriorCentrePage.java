package pages;

import framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DesignInteriorCentrePage extends Page {

    private String kitchenButtonLocator = "//div[@class='carousel__body-wrapper']/div/div[1]/button";

    public DesignInteriorCentrePage(RemoteWebDriver driver) {
        super(driver);
    }

    public <T extends Page> T clickOnKitchenButton(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(kitchenButtonLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }
}
