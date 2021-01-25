package com.atqa2020nromanchuk;

import com.atqa2020nromanchuk.listeners.TestListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.Properties;


//import static org.apache.commons.lang3.SystemUtils.*;


@Listeners(TestListener.class)
public abstract class BaseTestForFinalAssignmentTests {
    protected RemoteWebDriver driver;
    protected WebDriverWait wait;
    private static Properties properties;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
//        if (IS_OS_MAC || IS_OS_LINUX) {
//            if (getBrowser().equals("chrome")) {
//                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//                driver = new ChromeDriver();
//                this.wait = new WebDriverWait(driver, Integer.parseInt(getTimeout()));
//                driver.manage().window().maximize();
//            } else if (getBrowser().equals("firefox")) {
//                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver/geckodriver");
//                driver = new FirefoxDriver();
//                this.wait = new WebDriverWait(driver, Integer.parseInt(getTimeout()));
//                driver.manage().window().maximize();
//            }
//        } else if (IS_OS_WINDOWS) {
//            if (getBrowser().equals("chrome")) {
//                System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
//                driver = new ChromeDriver();
//                this.wait = new WebDriverWait(driver, Integer.parseInt(getTimeout()));
//                driver.manage().window().maximize();
//            } else if (getBrowser().equals("firefox")) {
//                System.setProperty("webdriver.gecko.driver", "drivers//geckodriver//geckodriver.exe");
//                driver = new FirefoxDriver();
//                this.wait = new WebDriverWait(driver, Integer.parseInt(getTimeout()));
//                driver.manage().window().maximize();
//            }
    }
    // driver.get(getMainUrl());

}

//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//        System.out.println("teardown");
//    }
//
//    protected String getTimeout() {
//        return getProperty("test.timeout");
//    }
//
//    protected String getBrowser() {
//        return getProperty("test.browser");
//    }
//
//    protected String getProperty(String key) {
//        String result = properties.getProperty(key);
//        return (result != null) ? result.trim() : null;
//    }
//}
