package com.catalin.selenium.hooks;

import com.catalin.selenium.framework.driver.BrowserType;
import com.catalin.selenium.framework.driver.DriverFactory;
import com.catalin.selenium.framework.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
        DriverFactory.initDriver(BrowserType.CHROME);
    }

    @After
    public void tearDown() {
        if (DriverManager.getDriver() != null){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
