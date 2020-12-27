import com.atqa2020nromanchuk.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class FirstWebTests {

//    private java.lang.String bedsAndMatracesNavigateButton = "//a[contains(text(),'Łóżka i materace')]";
//    private String acceptButton = "//button[contains(text(),'Akceptuj')]";

    private RemoteWebDriver driver;
    private String acceptButtonLocator = "//button[@id='onetrust-accept-btn-handler']";
    private HomePage homePage;
    private String searchTerm = "LUSTIGT Półka ścienna";
    private WallShelfPage wallShelfPage;
    private NewLowerPricesPage newLowerPricesPage;
    private DesignInteriorCentrePage designInteriorCentrePage;
    private KitchenPage kitchenPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(" https://www.ikea.com/pl/pl/");
        driver.manage().window().maximize();
        if (driver.findElement(By.xpath(acceptButtonLocator)).isDisplayed()) {
            driver.findElement(By.xpath(acceptButtonLocator)).click();
        }
        //driver.manage().window().maximize();
        System.out.println("setup sample test");

        homePage = new HomePage(driver);
    }

    @Test(priority = 0, suiteName = "main")
    public void SearchTest() throws Exception {

        //Given user opens a browser and provides a valid url

        //When user provides a search term "LUSTIGT Półka ścienna" and clicks on search button

        //Then user can see page whith searching result
        wallShelfPage = homePage.searchForItem(WallShelfPage.class, searchTerm);
    }

    @Test(priority = 1, suiteName = "main")
    public void NewLowerPricesTest() throws Exception {

        //Given user opens a browser and provides a valid url

        //When user clicks on "products" button and clicks on "new lower prices"  button

        //Then user can see page whith searching result
        newLowerPricesPage = homePage.navigateToNewLowerPricesPage(NewLowerPricesPage.class);
    }

    @Test(priority = 2, suiteName = "main")
    public void GalleryTest() throws Exception {
        //Given user opens a browser and provides a valid url

        //When user clicks on "design interior centre" button and redirecting to design interior page
        designInteriorCentrePage = homePage.navigateToDesignInteriorCentrePage(DesignInteriorCentrePage.class);
        
        //And clicks on 'kitchen' button and redirecting to kitchen page
        kitchenPage = designInteriorCentrePage.clickOnKitchenButton(KitchenPage.class);
        //Then user can see page whith searching result
    }

}