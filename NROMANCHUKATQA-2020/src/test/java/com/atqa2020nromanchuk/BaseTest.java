package com.atqa2020nromanchuk;

import com.atqa2020nromanchuk.listeners.TestListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

@Listeners(TestListener.class)
public abstract class BaseTest {

    private static final String DEFAULT_ENV_PROPERTIES_FILE_PATH = "src/test/resources/test.properties";
    protected RemoteWebDriver driver = null;
    private static Properties properties;

    static {
        properties = new Properties();
        loadPropertiesFromFile(DEFAULT_ENV_PROPERTIES_FILE_PATH);
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
//        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(getMainUrl());
        System.out.println("setup base test");
    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//        System.out.println("teardown");
//    }

    protected String getMainUrl() {
        String result;
        if (getProperty("test.isLocal").equals("true")) {
            result = properties.getProperty("test.mainUrl");
        } else {
            result = properties.getProperty("test.qaUrl");
        }
        return (result != null) ? result.trim() : null;
    }

    protected String getProperty(String key) {
        String result = properties.getProperty(key);
        return (result != null) ? result.trim() : null;
    }

    private static void loadPropertiesFromFile(String propertiesFilePath) {
        try {
            InputStream propertiesStream;
            propertiesStream = new FileInputStream(new File(propertiesFilePath).getPath());
            properties.load(propertiesStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
