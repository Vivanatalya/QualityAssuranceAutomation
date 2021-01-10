package com.atqa2020nromanchuk.framework;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.rmi.Remote;

public class Footer {
    protected RemoteWebDriver driver;

    public Footer(final RemoteWebDriver driver){
        this.driver=driver;
    }
}
