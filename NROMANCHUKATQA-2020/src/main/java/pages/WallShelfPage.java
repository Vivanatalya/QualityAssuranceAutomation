package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WallShelfPage extends Page {

    private String wallShelfPageTitleLocator="//*[@id='content']/div/div/div[1]/div[1]/h1";

    public WallShelfPage(RemoteWebDriver driver) {
        super(driver);
    }
    public boolean isSearchTermValid(String searchTerm) {
        return driver.findElement(By.xpath(wallShelfPageTitleLocator)).getText().contains(searchTerm);
    }
}
