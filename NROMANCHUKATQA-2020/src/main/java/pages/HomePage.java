package pages;

import framework.Header;
import framework.MainMenu;
import framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePage extends Page {

    private Header header;
    private MainMenu mainMenu;
    private NewLowerPricesPage newLowerPricesPage;

    public HomePage(RemoteWebDriver driver) {
        super(driver);
        this.header = new Header(driver);
        this.mainMenu = new MainMenu(driver);

    }

    public <T extends Page> T searchForItem(Class<T> clazz, String searchTerm) throws Exception {
        return header.setSearchTerm(searchTerm).clickOnSearchButton(clazz);
    }


    public <T extends Page> T navigateToNewLowerPricesPage(Class<T> clazz) throws Exception {
       return header.clickOnProductsMenuButton().navigateNewLowerPricesPage(clazz);

    }
    public <T extends Page> T navigateToDesignInteriorCentrePage(Class<T> clazz) throws Exception{
        return header.clickOnDesignInteriorCentreButton(clazz);
    }
}
