package com.atqa2020nromanchuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;

public class BooksPage extends Page {

    private String allListingsLinksLocator = "//ul[@id=zg_browseRoot]/ul/ul/li/a";
    private String mostGiftedBooksLinkLocator = "//div[@class='a-section a-spacing-none aok-relative']";
    //private String ratingLocator = "//div[@class='a-icon-row a-spacing-none']/a[@class='a-link-normal']";
    private String ratingLocator = "//a[@class='a-link-normal']";

    public BooksPage(RemoteWebDriver driver) {super(driver);}

    private List<WebElement> getBooksOnPage(){
        return driver.findElements(By.xpath(mostGiftedBooksLinkLocator));
    }

    private boolean isBookElementConsistsRating(WebElement bookElement){
        WebElement ratingElement = bookElement.findElement(By.xpath(ratingLocator));
        boolean result = ratingElement.isDisplayed();
        return result;
    }

    public boolean allBooksContainRating(){
        List<WebElement> books = getBooksOnPage();
        for (WebElement book: books
             ) {
            if (!isBookElementConsistsRating(book)){
                return false;
            }
        }
        return true;
    }
}
