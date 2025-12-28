package com.catalin.selenium.hooks;

import com.catalin.selenium.framework.config.ConfigManager;
import com.catalin.selenium.framework.config.ConfigReader;
import com.catalin.selenium.framework.driver.BrowserType;
import com.catalin.selenium.framework.driver.DriverFactory;
import com.catalin.selenium.framework.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private static ConfigReader configReader;

    @Before
    public void setup() {
        configReader = new ConfigReader("config.properties");
        ConfigManager.init(configReader);
        BrowserType browser = BrowserType.valueOf(configReader.get("browser").toUpperCase());
        DriverFactory.initDriver(browser);
    }

    @After
    public void tearDown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

    public static ConfigReader getConfigReader() {
        return configReader;
    }

}
