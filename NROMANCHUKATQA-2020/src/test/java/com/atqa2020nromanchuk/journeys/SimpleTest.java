package com.atqa2020nromanchuk.journeys;

import com.atqa2020nromanchuk.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleTest extends BaseTest {

    private String searchFieldLocator = "//input";
    private String searchTerm = "LUSTIGT Półka ścienna";
    private String searchButtonLocator = "//span/button[@id='search-box__searchbutton']";

    private String productsButtonLocator = "//nav[@class='hnf-header__nav']/ul/li[1]/a";
    private String dropDownMenu = "//body/aside";
    private String newLowerPricesLinkLocator = "//body/aside/div[2]/nav[@class='hnf-menu__nav2']/ul/li[2]/a";

    private String designInteriorCentreButtonLocator = "//header/div/div/div/nav/ul/li[3]/a";
    private String acceptButtonLocator = "//button[@id='onetrust-accept-btn-handler']";
    private String kitchenButtonLocator = "//div[@class='carousel__body-wrapper']/div/div[1]/button";
    private String galleryButtonLocator = "//*[@id=\"ea03b70f-28d1-11eb-886e-1db5641597a2\"]/div/div[2]/div/div/a/span";

    private String productsLowerTwentyButtonLocator = "//body/aside/div[2]/nav[2]/ul/li[3]/a";
    private String spoonsLinkLocator = "//*[@id=\"akcesoriadladzieci\"]/div/div/div[1]/div/div/a";
    private String basketLocator = "//*[@id=\"content\"]/div/div/div/div[2]/div[3]/div/div[2]/div/div/button/span";


    @BeforeMethod(alwaysRun = true)
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(" https://www.ikea.com/pl/pl/");
        driver.manage().window().maximize();
        if (driver.findElement(By.xpath(acceptButtonLocator)).isDisplayed()) {
            driver.findElement(By.xpath(acceptButtonLocator)).click();
        }
        System.out.println("setup sample test");
    }

    @Test(priority = 0, suiteName = "main")
    public void SearchTest() throws Exception {

        //Given user opens a browser and provides a valid url

        //When user provides a search term "LUSTIGT Półka ścienna"
        driver.findElement(By.xpath(searchFieldLocator)).sendKeys(searchTerm);

        //And clicks on search button
        driver.findElement(By.xpath(searchButtonLocator)).click();

        //Than user can see page with search result
    }

    @Test(priority = 1, suiteName = "main")
    public void newLowerPricesPageTest() throws Exception {
        //Given user opens a browser and provides a valid url

        //When user clicks on products button
        driver.findElement(By.xpath(productsButtonLocator)).click();

        //And clicks on  "new lower prices" button
        if (driver.findElement(By.xpath(dropDownMenu)).isDisplayed()) {

            driver.findElement(By.xpath(newLowerPricesLinkLocator)).click();
        }
        //Than user can see page with search result
    }

    @Test(priority = 2, suiteName = "main")
    public void GalleryTest() throws Exception {
        //Given user opens a browser and provides a valid url

        //When user clicks on "design interior centre" button and redirecting to design interior page
        driver.findElement(By.xpath(designInteriorCentreButtonLocator)).click();

        //And clicks on 'kitchen' button and redirecting to kitchen page
        driver.findElement(By.xpath(kitchenButtonLocator)).click();

        //Then user clicks on "gallery" button and user can see Gallery page
        driver.findElement(By.xpath(galleryButtonLocator)).click();

    }

    @Test(priority = 3, suiteName = "main")
    public void BaySpoonsTest() throws Exception {

        //Given user opens a browser and provides a valid url
        //When user clicks on "products" button and then click on "products lower twenty"
        driver.findElement(By.xpath(productsButtonLocator)).click();
        driver.findElement(By.xpath(productsLowerTwentyButtonLocator)).click();
        //And user can see "products lower twenty" page and click on first position with spoons
        driver.findElement(By.xpath(spoonsLinkLocator)).click();
        //Then user can adds spoons to basket
        driver.findElement(By.xpath(basketLocator)).click();
    }
}


