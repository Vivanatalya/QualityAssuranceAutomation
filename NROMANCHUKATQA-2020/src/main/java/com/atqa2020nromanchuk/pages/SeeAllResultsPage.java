package com.atqa2020nromanchuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class SeeAllResultsPage extends Page {

    private String sortFieldLocator = "//span[@class='a-dropdown-container']//span[@class='a-button-inner']";
    private String avgCustomerReviewChoiseLinkLocator = "//div[@class='a-popover-inner']/ul/li[4]/a";
    private String allMonitorsLocator = "//div[@class='s-include-content-margin s-border-bottom s-latency-cf-section']";
    private String starsRatingLocator ="//div[@class='a-section a-spacing-none a-spacing-top-micro']//span[@class='a-declarative']/a/i[1]/span";
            //"//span[contains(text(),'stars')]";
    public SeeAllResultsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public SeeAllResultsPage clickOnSortField() {
        driver.findElement(By.xpath(sortFieldLocator)).click();
        return this;
    }

    public SeeAllResultsPage chooseAvgCustomerReview() {
        driver.findElement(By.xpath(avgCustomerReviewChoiseLinkLocator)).click();
        return this;
    }

    public boolean isRatingGoDown() {
        List<WebElement> elements = getElements(By.xpath(allMonitorsLocator));
        double previousRating = 5;

        for (WebElement element : elements) {
            WebElement ratingElement = element.findElement(By.xpath(starsRatingLocator));
            String ratingElementText = ratingElement.getText();
            String[] ratingText = ratingElementText.split(" ");
            double currentRating = Double.parseDouble(ratingText[0]);
            if (previousRating < currentRating) {
                return false;
            }
        }
        return true;
    }

}
