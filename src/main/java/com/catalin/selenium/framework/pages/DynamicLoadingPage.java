package com.catalin.selenium.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPage extends BasePage {

    //    locators for Example2
    @FindBy(linkText = "Dynamic Loading")
    private WebElement dynamicLoadingPage;

    @FindBy(linkText = "Example 1: Element on page that is hidden")
    private WebElement example1Link;

    @FindBy(css = "div[id='start'] button")
    private WebElement startButton;

    @FindBy(id = "loading")
    private WebElement loadingBar;

    @FindBy(id = "finish")
    private WebElement finishText;

//    locators for Example2
    @FindBy(linkText = "Example 2: Element rendered after the fact")
    private WebElement example2Link;

    private final By finishTextLocator = By.id("finish");


    public void clickOnExample1() {
        click(example1Link);
    }
     public void clickOnExample2() {
        click(example2Link);
    }

    public void clickOnStartButton() {
        click(startButton);
    }

    public String getFinishTextWhenVisible() {
        return getText(finishText);
    }

    public String getFinishTextAfterPresence() {
        waitForPresence(finishTextLocator);
        return getText(finishText);
    }


}
