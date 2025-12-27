package com.catalin.selenium.framework.pages;

import com.catalin.selenium.framework.driver.DriverManager;
import org.openqa.selenium.By;

public class HomePage {

    private final By header = By.tagName("h1");

    public String getHeaderText(){
        return DriverManager.getDriver()
                .findElement(header)
                .getText();
    }
}
