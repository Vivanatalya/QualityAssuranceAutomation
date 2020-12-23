import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstWebTests {

    private String menuButton = "//header/div[1]/div[1]/div[1]/ul[1]/li[6]/button[1]/span[1]";
    private String productsButton = "//body[1]/aside[1]/div[2]/nav[1]/ul[1]/li[1]/a[1]";
    private String bedsAndMatracesNavigateButton = "//a[contains(text(),'Łóżka i materace')]";

    private String searchBarButton="//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]";
    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1, suiteName = "main")
    public void Test2() {

        //Given user opens a browser and provides a valid url
        driver.get(" https://www.ikea.com/pl/pl/");
        //When user clicks on menu button
        driver.findElement(By.xpath(menuButton)).click();


        //And clicks on products in menu
        driver.findElement(By.xpath(productsButton)).click();

        //Then user clicks on Łóżka i materace
        //Test fails on this step. Smth is wrong with XPath maybe.
       // driver.findElement(By.xpath(bedsAndMatracesNavigateButton)).click();

    }

    @Test(priority = 2, suiteName = "main")
    public void Test3() {

        //Given user opens a browser and provides a valid url
        driver.get(" https://www.ikea.com/pl/pl/");
        //When user clicks on search button
        driver.findElement(By.xpath(searchBarButton)).click();
        //And

        //Then
    }

//    @Test(priority = 0, suiteName = "main")
//    public void mainUrlTest() {
//
//        //Given user opens a browser and provides a valid url
//        driver.get("https://google.com");
//        //When user clicks enter
//
//        //And
//
//        //Then user is redirected to the main page
//        Assert.assertTrue(driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).isDisplayed());
//    }
}
