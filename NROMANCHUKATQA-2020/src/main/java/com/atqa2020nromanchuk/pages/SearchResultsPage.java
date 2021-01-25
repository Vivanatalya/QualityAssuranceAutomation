package com.atqa2020nromanchuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class SearchResultsPage extends Page {

    private String searchResultPageTitleLocator = "//*[@id='content']/div/div/div[1]/div[1]/h1";
    private String fourPlusReviewSelector = "//i[@class='a-icon a-icon-star-medium a-star-medium-4']";
    private String inputPriceLocator = "//input[@id='low-price']";
    private String priceSubmitButtonLocator = "//span[@class='a-button a-spacing-top-mini a-button-base s-small-margin-left']//input[@type='submit']";
    private String searchResultsListLocator = "//*[@data-component-type='s-search-result']";
    private String sponsoredLabelLocator = "//span[@class='a-size-mini a-color-secondary']";
    private String item4PlusRatingLocator = "//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom']";
    private String item5RatingLocator = "//i[@class='a-icon a-icon-star-small a-star-small-5 aok-align-bottom']";
    private String wholePriceLocator = "//span[@class='a-price-whole']";


    public SearchResultsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isSearchTermValid(String searchTerm) {
        return driver.findElement(By.xpath(searchResultPageTitleLocator)).getText().contains(searchTerm);
    }

    public SearchResultsPage selectFourPlusCustomerReviewRating() {
        return clickOnElements(By.xpath(fourPlusReviewSelector), SearchResultsPage.class);
    }

    public SearchResultsPage setMinimalPrice() {
        return setText(By.xpath(inputPriceLocator), "100", SearchResultsPage.class);
    }
    public SearchResultsPage submitPrice() {
        return clickOnElements(By.xpath(priceSubmitButtonLocator), SearchResultsPage.class);
    }
    public boolean isExpectedConditionsMet() {
        List<WebElement> elements = getElements(By.xpath(searchResultsListLocator));
        boolean result = true;

        for(WebElement element : elements){
            if (!isDisplayed(element, By.xpath(sponsoredLabelLocator))) {
                if ((!isDisplayed(element, By.xpath(item4PlusRatingLocator)) ||
                        !isDisplayed(element, By.xpath(item5RatingLocator))) &&
                        Integer.parseInt(element.findElement(By.xpath(wholePriceLocator)).getText()) < 100) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
