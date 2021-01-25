package com.atqa2020nromanchuk.pages;

import com.atqa2020nromanchuk.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MonitorsPage extends Page {

    private String monitorsButtonLocator = "//div[@id='nav-subnav']//span[contains(text(), 'Monitors')]//parent::a";
    private String topRatedTitleLocator = "//div[@class='a-section octopus-pc-card-title']/span";
    private String seeAllLinkLocator="//div[@class='a-section octopus-pc-card-title']/a";
    private static String TOP_RATED_TITLE="Top Rated";
    private String seeAllResultsLinkLocator="//div[@class='a-box-inner']/a";

    public MonitorsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isTitleContainsTopRatedText()throws Exception{
        return driver.findElement(By.xpath(topRatedTitleLocator)).getText().equals(TOP_RATED_TITLE);
    }

    public MonitorsPage clickOnMonitorsButtonToReloadSection(){
        driver.findElement(By.xpath(monitorsButtonLocator)).click();
        return this;
    }

    public <T extends Page> T navigateToSeeAllPage(Class<T> clazz) throws Exception{
        driver.findElement(By.xpath(seeAllLinkLocator)).click();
        return PageFactory.newPage(driver,clazz);
    }
    public <T extends Page> T navigateToSeeAllResults(Class<T> clazz) throws Exception{
     driver.findElement(By.xpath(seeAllResultsLinkLocator)).click();
     return PageFactory.newPage(driver, clazz);
    }
}
