package com.atqa2020nromanchuk.pages;


import com.atqa2020nromanchuk.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.atqa2020nromanchuk.pages.Page;

public class KitchenPage extends Page {
    //TODO you can use single quotes in the locator, e.g. "//*[@id='ea03b70f-28d1-11eb-886e-1db5641597a2']/div/div[2]/div/div/a/span";
    private String galleryButtonLocator="//*[@id=\"ea03b70f-28d1-11eb-886e-1db5641597a2\"]/div/div[2]/div/div/a/span";

    public KitchenPage(RemoteWebDriver driver) {
        super(driver);
    }

    public <T extends Page> T clickOnGalleryButton(Class<T> clazz ) throws Exception{
        driver.findElement(By.xpath(galleryButtonLocator)).click();
        return PageFactory.newPage(driver,clazz);
    }
}
