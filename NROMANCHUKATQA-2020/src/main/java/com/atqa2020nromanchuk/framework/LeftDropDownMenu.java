package com.atqa2020nromanchuk.framework;

import com.atqa2020nromanchuk.ElementBase;
import com.atqa2020nromanchuk.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftDropDownMenu extends ElementBase {

    protected RemoteWebDriver driver;
    protected WebDriverWait wait;
    private String newReleasesButtonLocator="//div[@id='hmenu-content']/ul[1]/li[3]/a";

    public LeftDropDownMenu(RemoteWebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    protected boolean isElementDisplayed(By selector) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
            return driver.findElement(selector).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public <T extends Page> T clickOnNewReleasesButton(Class<T> clazz) throws Exception {
        if (isElementDisplayed(By.xpath(newReleasesButtonLocator))){
            driver.findElement(By.xpath(newReleasesButtonLocator)).click();
        }
        return PageFactory.newPage(driver, clazz);
    }
}
