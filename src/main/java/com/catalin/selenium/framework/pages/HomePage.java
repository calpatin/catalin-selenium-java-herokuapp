package com.catalin.selenium.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(tagName = "h1")
    private WebElement header;

    @FindBy(css = "img[alt='Fork me on GitHub']")
    private WebElement forkMeOnGitHubBanner;

    public String getHeaderText() {
        waitForVisibility(header);
        return header.getText();
    }

    public boolean isForkMeOnGitHubDisplayed() {
        waitForVisibility(forkMeOnGitHubBanner);
        return forkMeOnGitHubBanner.isDisplayed();
    }

    public boolean isPresentOnPage() {
        waitForVisibility(header);
        waitForVisibility(forkMeOnGitHubBanner);
        return true;
    }
}
