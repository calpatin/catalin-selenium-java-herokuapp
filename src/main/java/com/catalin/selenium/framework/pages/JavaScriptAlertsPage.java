package com.catalin.selenium.framework.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPage extends BasePage {

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    private WebElement clickForJsAlertButton;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    private WebElement clickForJsConfirmButton;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    private WebElement clickForJsPromptButton;

    @FindBy(id = "result")
    WebElement resultText;

    public void clickJsAlertButton() {
        click(clickForJsAlertButton);
    }

    public void clickJsConfirmButton() {
        click(clickForJsConfirmButton);
    }

    public void clickJsPromptButton() {
        click(clickForJsPromptButton);
    }

    public String acceptAlertAndGetText() {
        Alert alert = waitForAlert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public void dismissAlert() {
        Alert alert = waitForAlert();
        alert.dismiss();
    }

    public void sendTextToPrompt(String text) {
        Alert alert = waitForAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getResultText() {
        return getText(resultText);
    }


}