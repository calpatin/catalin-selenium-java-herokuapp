package com.catalin.selenium.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicControlsPage extends BasePage {

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkbox;

    @FindBy(css = "button[onclick='swapCheckbox()']")
    private WebElement removeAddButton;

    @FindBy(id = "message")
    private WebElement message;

    public void clickRemoveAddButton() {
        click(removeAddButton);
    }

    public boolean isCheckboxGone() {
        return fluentWait(driver -> {
            try {
                return !checkbox.isDisplayed();
            } catch (Exception e) {
                return true;
            }
        });
    }

    public String getMessageText() {
        return fluentWait(driver -> {
            try {
                return message.getText();
            } catch (Exception e) {
                return null;
            }
        });
    }

}
