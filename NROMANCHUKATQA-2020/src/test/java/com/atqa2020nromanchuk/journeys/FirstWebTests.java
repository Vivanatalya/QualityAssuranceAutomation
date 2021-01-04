package com.atqa2020nromanchuk.journeys;

import com.atqa2020nromanchuk.BaseTest;
import com.atqa2020nromanchuk.listeners.TestListener;
import com.sun.xml.internal.ws.server.ServerRtException;
import framework.Header;
import framework.MainMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.util.PriorityQueue;

@Listeners(TestListener.class)
public class FirstWebTests extends BaseTest {

    //    private java.lang.String bedsAndMatracesNavigateButton = "//a[contains(text(),'Łóżka i materace')]";
    private String acceptButton = "//button[contains(text(),'Akceptuj')]";

    private static String WALLSHELF_PAGE_TITLE = "Wyświetlanie wyników dla LUSTIGT Półka ścienna";

    private RemoteWebDriver driver;
    private String acceptButtonLocator = "";
            //div[@class='banner-actions-container']/button[@id='onetrust-accept-btn-handler']";
  //  <button id="onetrust-pc-btn-handler" tabindex="0">Ustawienia cookies</button>
    // onetrust-pc-btn-handler
  //button[@id='onetrust-accept-btn-handler']";
    //onetrust-accept-btn-handler
    private String acceptButtonsGroupLocator = "//div[@id='onetrust-button-group']";
    private HomePage homePage;
    private String searchTerm = "LUSTIGT Półka ścienna";
    private WallShelfPage wallShelfPage;
    private NewLowerPricesPage newLowerPricesPage;
    private DesignInteriorCentrePage designInteriorCentrePage;
    private KitchenPage kitchenPage;
    private GalleryPage galleryPage;
    private ProductsLowerTwenty productsLowerTwenty;
    private MainMenu mainMenu;
    private Header header;
    private String productsButtonLocator = "//nav[@class='hnf-header__nav']/ul/li[1]/a";

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getMainUrl());
        System.out.println("setup first Web tests");
        homePage = new HomePage(driver);

        if (driver.findElement(By.xpath(acceptButton)).isDisplayed()) {
            System.out.println("accept finded");
            driver.findElement(By.xpath(acceptButton)).click();
        }
        System.out.println("setup accept coocies");


    }

    @Test(priority = 0, suiteName = "main")
    public void SearchTest() throws Exception {

        //Given user opens a browser and provides a valid url

        //When user provides a search term "LUSTIGT Półka ścienna" and clicks on search button

        //Then user can see page whith searching result
        wallShelfPage = homePage.searchForItem(WallShelfPage.class, searchTerm);
        Assert.assertTrue(wallShelfPage.isSearchTermValid(searchTerm), "Title is not correct!!!");
        //System.out.println("Inside test");
    }

    @Test(priority = 1, suiteName = "main")
    public void NewLowerPricesTest() throws Exception {

        //Given user opens a browser and provides a valid url

        //When user clicks on "products" button and clicks on "new lower prices"  button

        //Then user can see page whith searching result
        newLowerPricesPage = homePage.navigateToNewLowerPricesPage(NewLowerPricesPage.class);
        Assert.assertTrue(newLowerPricesPage.isTitleCorrect(), "Title is not correct!!!");
    }

    @Test(priority = 2, suiteName = "main")
    public void GalleryTest() throws Exception {
        //Given user opens a browser and provides a valid url

        //When user clicks on "design interior centre" button and redirecting to design interior page
        designInteriorCentrePage = homePage.navigateToDesignInteriorCentrePage(DesignInteriorCentrePage.class);

        //And clicks on 'kitchen' button and redirecting to kitchen page
        kitchenPage = designInteriorCentrePage.clickOnKitchenButton(KitchenPage.class);
        //Then user can see page whith searching result
        galleryPage = kitchenPage.clickOnGalleryButton(GalleryPage.class);
    }

    @Test(priority = 3, suiteName = "main")
    public void BaySpoonsTest() throws Exception {

        //Given user opens a browser and provides a valid url

        //When user clicks on "products" button and then click on "products lower twenty"
        driver.findElement(By.xpath(productsButtonLocator)).click();

        productsLowerTwenty = header.navigateProductsLowerTwenty(ProductsLowerTwenty.class);
        //And user can see "products lower twenty" page and click on first position with spoons
        // driver.findElement(By.xpath(spoonsLinkLocator)).click();
        //Then user can adds spoons to basket
        // driver.findElement(By.xpath(koshykLocator)).click();
    }

}
