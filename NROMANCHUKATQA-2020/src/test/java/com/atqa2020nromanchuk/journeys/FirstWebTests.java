package com.atqa2020nromanchuk.journeys;

import com.atqa2020nromanchuk.BaseTest;
import com.atqa2020nromanchuk.framework.Header;
import com.atqa2020nromanchuk.framework.SearchTermsDataProvider;
import com.atqa2020nromanchuk.listeners.TestListener;
import com.atqa2020nromanchuk.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class FirstWebTests extends BaseTest {

    private HomePage homePage;
    private WallShelfPage wallShelfPage;
    private SearchResultPage searchResultPage;
    private KitchenPage kitchenPage;
    private NewLowerPricesPage newLowerPricesPage;
    private DesignInteriorCentrePage designInteriorCentrePage;
    private String oneSearchTerm = "LUSTIGT Półka ścienna";
    private String acceptButtonLocator = "//button[@id='onetrust-accept-btn-handler']";

    //TODO this should be declared on the corresponding page
    private static String WALLSHELF_PAGE_TITLE = "Wyświetlanie wyników dla LUSTIGT Półka ścienna";
    private RemoteWebDriver driver;
    private ProductsLowerTwentyPage productsLowerTwentyPage;
    private GalleryPage galleryPage;
    private Header header;
    //TODO this should be declared on the corresponding page
    private String productsButtonLocator = "//nav[@class='hnf-header__nav']/ul/li[1]/a";

    @BeforeMethod(alwaysRun = true)
    public void setupTest() {

        //TODO: 09.01.2021 move it to the BaseTest.java................
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, 10);
        driver.get(getMainUrl());
        // ............................................................

        if (isElementDisplayed(By.xpath(acceptButtonLocator))) {
            driver.findElement(By.xpath(acceptButtonLocator)).click();
        }
        homePage = new HomePage(driver);
    }

    @DataProvider(name = "getSearchTerms")
    public Object[][] getSearchTerms() {
        return SearchTermsDataProvider.getAllSearchTerms();
    }

    @Test(groups = "main", suiteName = "ui")
    public void SearchTest() throws Exception {

        //Given user opens a browser and provides a valid url

        //When user provides a search term "LUSTIGT Półka ścienna" and clicks on search button

        //Then user can see page whith searching result
        wallShelfPage = homePage.searchForItem(WallShelfPage.class, oneSearchTerm);

        Assert.assertTrue(wallShelfPage.isSearchTermValid(oneSearchTerm), "Title is not correct!!!");

    }

    @Test(groups = "main", dataProvider = "getSearchTerms")
    public void searchTestUsingDataProvider(String searchTerm) throws Exception {

        //Given user opens a browser and provides a valid url

        //When user provides a search term from enum file and clicks on search button
        searchResultPage = homePage.searchForItem(SearchResultPage.class, searchTerm);
        //And checks for cookies
        //TODO misspel in method name
        chekForCookies();
        //Then title on the results page contains search term
        Assert.assertTrue(searchResultPage.isSearchTermValid(searchTerm), "Search term is not valid!");
    }

    @Test(priority = 1, suiteName = "main")
    //TODO please apply camel case naming format for the test method
    public void NewLowerPricesTest() throws Exception {

        //Given user opens a browser and provides a valid url

        //When user clicks on "products" button and clicks on "new lower prices"  button

        //Then user can see page whith searching result
        newLowerPricesPage = homePage.navigateToNewLowerPricesPage(NewLowerPricesPage.class);
        Assert.assertTrue(newLowerPricesPage.isTitleCorrect(), "Title is not correct!!!");
    }

    @Test(priority = 2, suiteName = "main")
    //TODO please apply camel case naming format for the test method
    public void GalleryTest() throws Exception {
        //Given user opens a browser and provides a valid url

        //When user clicks on "design interior centre" button and redirecting to design interior page
        designInteriorCentrePage = homePage.navigateToDesignInteriorCentrePage(DesignInteriorCentrePage.class);

        //And clicks on 'kitchen' button and redirecting to kitchen page
        kitchenPage = designInteriorCentrePage.clickOnKitchenButton(KitchenPage.class);
        //Then user can see page whith searching result
        galleryPage = kitchenPage.clickOnGalleryButton(GalleryPage.class);
        //TODO this test is missing Assert and therefore doesn't check anything, please add Assert here
    }

    // todo: make the test work
//
//    @Test(priority = 3, suiteName = "main")
//    public void BaySpoonsTest() throws Exception {
//
//        //Given user opens a browser and provides a valid url
//
//        //When user clicks on "products" button and then click on "products lower twenty"
//        driver.findElement(By.xpath(productsButtonLocator)).click();
//
//        productsLowerTwentyPage = header.navigateProductsLowerTwenty(ProductsLowerTwentyPage.class);
//        //And user can see "products lower twenty" page and click on first position with spoons
//        // driver.findElement(By.xpath(spoonsLinkLocator)).click();
//        //Then user can adds spoons to basket
//        // driver.findElement(By.xpath(koshykLocator)).click();
//    }

    // TODO: 09.01.2021 move it to the BaseTest.java
    protected boolean isElementDisplayed(By selector) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
            return driver.findElement(selector).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    //TODO if we're checking for cookies only in this class then make this method private
    public void chekForCookies() {
        if (isElementDisplayed(By.xpath(acceptButtonLocator))) {
            driver.findElement(By.xpath(acceptButtonLocator)).click();
        }
    }

}
