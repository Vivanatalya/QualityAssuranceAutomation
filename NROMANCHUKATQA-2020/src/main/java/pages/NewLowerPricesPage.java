package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NewLowerPricesPage extends Page {

    private String newLoverPriseImageLocator ="//div[@id='eafb62f0-cf1f-11e9-bc28-691a022138fb']/div/h2";
    private static String NEW_LOWER_PRICE_PAGE_TITLE="Niższa cena, ta sama jakość.";


    public NewLowerPricesPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isTitleCorrect() {
        return driver.findElement(By.xpath(newLoverPriseImageLocator)).getText().equals(NEW_LOWER_PRICE_PAGE_TITLE);
    }
}
