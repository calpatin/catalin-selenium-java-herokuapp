package com.catalin.selenium.framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private DriverFactory() {

    }

    public static void initDriver(BrowserType browser) {

        WebDriver driver;

        switch (browser) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");

                driver = new ChromeDriver(options);
            }
//            case FIREFOX -> {
////                to be implemented when needed
//            }

            default -> throw new IllegalArgumentException("Browser not Supported: " + browser);
        }
        DriverManager.setDriver(driver);
    }
}
