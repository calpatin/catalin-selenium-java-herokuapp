package com.catalin.selenium.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage {

    @FindBy(linkText = "Click Here")
    private WebElement clickHereLink;

    @FindBy(tagName = "h3")
    private WebElement pageHeader;

    public void openNewWindow() {
        click(clickHereLink);
    }

    public String getHeaderTxt() {
        return getText(pageHeader);
    }

    public String captureCurrentWindow() {
        return getCurrentWindow();
    }

    public void switchToOriginalWindow(String windowHandle) {
        switchToWindow(windowHandle);
    }

    public void switchToNewlyOpenedWindow(String originalWindow) {
        switchToNewWindow(originalWindow);
    }

}
