package com.catalin.selenium.steps;

import com.catalin.selenium.framework.driver.DriverManager;
import com.catalin.selenium.framework.pages.JavaScriptAlertsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class JavaScriptsAlertsSteps {

    private final JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();

    @Given("I open the JavaScript alert page")
    public void openJsAlertsPage() {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @When("I click for JS Alert")
    public void clickJsAlert() {
        javaScriptAlertsPage.clickJsAlertButton();
    }

    @When("I click for JS Confirm")
    public void clickJsConfirmation() {
        javaScriptAlertsPage.clickJsConfirmButton();
        javaScriptAlertsPage.dismissAlert();
    }

    @When("I enter the {string} in the JS Prompt")
    public void handlePrompt(String text) {
        javaScriptAlertsPage.clickJsPromptButton();
        javaScriptAlertsPage.sendTextToPrompt(text);
    }

    @Then("The alert is displayed and accepted")
    public void confirmSimpleAlert() {
        String alertText = javaScriptAlertsPage.acceptAlertAndGetText();
        String resultText = javaScriptAlertsPage.getResultText();
        Assert.assertEquals(alertText, "I am a JS Alert");
        Assert.assertEquals(resultText, "You successfully clicked an alert");
    }

    @Then("The confirmation is cancelled")
    public void confirmDismissedConfirmation() {
        Assert.assertEquals(javaScriptAlertsPage.getResultText(), "You clicked: Cancel");
    }

    @Then("The prompt result contains {string}")
    public void confirmPromptResult(String text) {
        Assert.assertTrue(javaScriptAlertsPage.getResultText().contains(text));
    }


}


