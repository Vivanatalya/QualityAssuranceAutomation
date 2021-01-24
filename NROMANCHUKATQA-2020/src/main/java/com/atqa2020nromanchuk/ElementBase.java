package com.atqa2020nromanchuk;

import com.atqa2020nromanchuk.framework.PageFactory;
import com.atqa2020nromanchuk.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementBase {
    protected RemoteWebDriver driver;
    protected WebDriverWait wait;

    public WebElement click(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
        return element;
    }

    public <T extends Page> T click(Class<T> clazz, By locator) throws Exception {
        driver.findElement(locator).click();
        return PageFactory.newPage(driver, clazz);
    }
}
