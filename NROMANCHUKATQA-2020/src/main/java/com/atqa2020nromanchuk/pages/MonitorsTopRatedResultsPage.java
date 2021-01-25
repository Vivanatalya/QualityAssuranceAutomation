package com.atqa2020nromanchuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MonitorsTopRatedResultsPage extends Page {

    private String sortFieldLocator="//span[@class='a-dropdown-container']//span[@class='a-button-inner']";
    private String avgCustomerReviewChoiseLinkLocator="//div[@class='a-popover-inner']/ul/li[4]/a";
    public MonitorsTopRatedResultsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public MonitorsTopRatedResultsPage clickOnSortField(){
        driver.findElement(By.xpath(sortFieldLocator)).click();
        return this;
    }

    public MonitorsTopRatedResultsPage chooseAvgCustomerReview(){
        driver.findElement(By.xpath(avgCustomerReviewChoiseLinkLocator)).click();
        return this;
    }
    //driver.findElement(By.xpath("//span[@class='a-dropdown-container']//span[@class='a-button-inner']")).click();
    //driver.findElement(By.xpath("//div[@class='a-popover-inner']/ul/li[4]/a")).click();
}
