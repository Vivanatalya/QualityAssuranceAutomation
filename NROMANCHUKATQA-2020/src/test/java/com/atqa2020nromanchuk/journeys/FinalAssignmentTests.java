package com.atqa2020nromanchuk.journeys;

import com.atqa2020nromanchuk.BaseTest;
import com.atqa2020nromanchuk.framework.Header;
import com.atqa2020nromanchuk.framework.LeftDropDownMenu;
import com.atqa2020nromanchuk.listeners.TestListener;
import com.atqa2020nromanchuk.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class FinalAssignmentTests extends BaseTest {

    private HomePage homePage;
    private NewReleasesPage newReleasesPage;
    private MostGiftedPage mostGiftedPage;
    private BooksPage booksPage;
    private ElectronicsPage electronicsPage;
    private ComputersAndAccessoriesPage computersAndAccessoriesPage;
    private MonitorsPage monitorsPage;
    private SeeAllPage seeAllPage;
    private SeeAllResultsPage seeAllResultsPage;
    private SearchResultsPage searchResultsPage;
    private Header header;
    private LeftDropDownMenu leftDropDownMenu;
    private String allButtonLocator = "//div[@class='nav-left']/a";
    private String newReleasesButtonLocator = "//div[@id='hmenu-content']/ul[1]/li[3]/a";
    private String searchTerm = "go pro 4k";


    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        driver.get("https://www.amazon.co.uk");
        homePage = new HomePage(driver);

    }

    protected boolean isElementDisplayed(By selector) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
            return driver.findElement(selector).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    @Test(groups = "main", suiteName = "ui")
    public void verifyNewReleasesPageTest() throws Exception {
        //Given user opens a browser and provides a valid url (navigate to amazon.co.uk)

        //When from the home page click on button “ALL” on the left panel to navigate to left drop down menu

        //And from the left drop down menu select “New Releases”
        newReleasesPage = homePage.navigateToLeftDropDownMenu().navigateToNewReleasesPage(NewReleasesPage.class);

        //Then
        Assert.assertTrue(newReleasesPage.ifAllTitlesAreExist(), "Title is not correct!!!");
    }

    @Test(groups = "main", suiteName = "ui")
    public void verifyMostGiftedPageTest() throws Exception {
        //Given user opens a browser and provides a valid url (navigate to amazon.co.uk)

        //When from the home page click on link “New Releases” from the Top menu

        //And from the “Hot New Releases” click on “Most Gifted” link from the top menu

        //from the “Amazon Gift Ideas” click on “Books” link from the left menu
        booksPage = homePage.navigateToNewReleasesPageFromTopMenu(NewReleasesPage.class).navigateToMostGiftedPage(MostGiftedPage.class).clickOnLeftMenuBooksLink(BooksPage.class);

        //Than on the “Most Gifted in Books” page check ALL listings and verify that all of them have Ratings presented
        Assert.assertTrue(booksPage.allBooksContainRating(), "Doesn't contain");
    }

    @Test(groups = "main") //not works
    public void tc3Test() throws Exception {
        //Given user navigates to the expected page through the footer
        searchResultsPage = homePage.searchForItem(SearchResultsPage.class, searchTerm);

        searchResultsPage.selectFourPlusCustomerReviewRating().setMinimalPrice().submitPrice();

        //Then page URL constructed as required
        Assert.assertTrue(searchResultsPage.isExpectedConditionsMet(), "Expected conditions weren't met");
    }

    @Test(groups = "main", suiteName = "ui")
    public void tc4Monitors() throws Exception {
        //Given user opens a browser and provides a valid url (navigate to amazon.co.uk) and accept cookies
        homePage.acceptCoockies();

        //When from the home page click on link “Electronics” from the Top menu
        electronicsPage = homePage.navigateToElectronicsPage(ElectronicsPage.class);

        //And on “Electronics” page click on “Computers & Accessories” on undertop menu
        computersAndAccessoriesPage = electronicsPage.navigateToComputerAndAccessoriesPage(ComputersAndAccessoriesPage.class);

        //And on “Computers & Accessories” page click on “Monitors” on undertop menu
        monitorsPage = computersAndAccessoriesPage.navigateToMonitorsPage(MonitorsPage.class);
/**********************************************************************************************************
 * it works good in debug mode, but not always in Run mode, so I decided to make little changes in test case and
 * choose "See all results" in the bottom on page

 //And on Monitors Page checks if section "Top rated" is present. If not - reload page by clicking on
 // Monitors button
    if (!monitorsPage.isTitleContainsTopRatedText()) {
    do {
        monitorsPage.clickOnMonitorsButtonToReloadSection();
     } while (monitorsPage.isTitleContainsTopRatedText());
     }

 //And on “Monitors” page click on “See all” link  next to the “Top rated" section
 // seeAllPage = monitorsPage.navigateToSeeAllPage(SeeAllPage.class);
 ***************************************************************************************************************/

        //And on  “Monitors see all results” page apply filter “Sort by: Avg. Customer Review” from the top of the page
        seeAllResultsPage = monitorsPage.navigateToSeeAllResults(SeeAllResultsPage.class).clickOnSortField().chooseAvgCustomerReview();

        //Then verify that in refreshed list all listings on the first page are sorted according to the Customer
        // review (e.g., most rated on the top, etc.)
        Assert.assertTrue(seeAllResultsPage.isRatingGoDown());

    }

    @Test(groups = "main", suiteName = "ui")
    public void tc5() throws Exception {

    }
}