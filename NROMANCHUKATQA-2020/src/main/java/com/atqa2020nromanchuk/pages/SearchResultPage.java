package com.atqa2020nromanchuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchResultPage extends Page {

    private String searchResultPageTitleLocator = "//*[@id='content']/div/div/div[1]/div[1]/h1";

    public SearchResultPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isSearchTermValid(String searchTerm) {
        return driver.findElement(By.xpath(searchResultPageTitleLocator)).getText().contains(searchTerm);
    }


}
