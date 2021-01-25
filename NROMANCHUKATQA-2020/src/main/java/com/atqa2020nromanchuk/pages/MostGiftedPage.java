package com.atqa2020nromanchuk.pages;

import com.atqa2020nromanchuk.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MostGiftedPage extends Page {

 private String booksLeftMenuButtonLocator="//div[@id='zg_left_col2']/ul/ul/li/a[contains(text(),'Books')]";

    public MostGiftedPage(RemoteWebDriver driver) {super(driver);}

    public <T extends Page>T clickOnLeftMenuBooksLink(Class<T> clazz) throws Exception{
        driver.findElement(By.xpath(booksLeftMenuButtonLocator)).click();
        return PageFactory.newPage(driver,clazz);
    }

}
