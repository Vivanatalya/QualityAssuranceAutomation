package com.atqa2020nromanchuk.pages;

import com.atqa2020nromanchuk.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.atqa2020nromanchuk.pages.Page;

import java.util.ArrayList;
import java.util.List;

public class NewReleasesPage extends Page {

    private String newReleasesTitlesLocator ="//div[@class='zg_homeWidget']/h3";
    private String newReleasesListLocator="//*[@id='zg_browseRoot']/ul/li";
    private String mostGiftedTopMenuButtonLocator="//div[@id='zg_tabs']/ul/li/div/a[contains(text(),'Most Gifted')]";

    public NewReleasesPage(RemoteWebDriver driver) {
        super(driver);
    }

    public ArrayList<String> getTitlesByXpathLocator(String xpathLocator){
        List<WebElement> elements = driver.findElements(By.xpath(xpathLocator));
        ArrayList<String> titles = new ArrayList<String>();
        for (WebElement element: elements) {
            titles.add(element.getText());
        }
        return titles;
    }

//    public ArrayList<String> getNewReleasesTitles(){
//        List<WebElement> elements = driver.findElements(By.xpath(newReleasesTitlesLocator));
//        ArrayList<String> titles = new ArrayList<String>();
//        for (WebElement element: elements) {
//            titles.add(element.getText());
//        }
//        return titles;
//    }

    public boolean ifAllTitlesAreExist () {
        ArrayList<String> leftMenuTitles = getTitlesByXpathLocator(newReleasesListLocator);
        ArrayList<String> titles = getTitlesByXpathLocator(newReleasesTitlesLocator);
        boolean result = leftMenuTitles.containsAll(titles);
        return result;
    }
    public <T extends Page>T navigateToMostGiftedPage(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(mostGiftedTopMenuButtonLocator)).click();
        return PageFactory.newPage(driver,clazz);
    }
}















//    protected <T extends Page>T selectDropdownOption(By selector, String optionName, Class<T> clazz) throws Exception {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
//        Select select = new Select(driver.findElement(selector));
//        List<WebElement> options = select.getOptions();
//        for (WebElement option : options) {
//            if (option.getText().equals(optionName)) {
//                option.click();
//            }
//        }
//        return PageFactory.newPage(driver, clazz);
//    }
