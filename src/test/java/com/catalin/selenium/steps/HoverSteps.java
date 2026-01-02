package com.catalin.selenium.steps;

import com.catalin.selenium.framework.driver.DriverManager;
import com.catalin.selenium.framework.pages.HoversPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HoverSteps {
    private final HoversPage hoversPage = new HoversPage();

    @Given("I open the Hover Page")
    public void openHoverPage() {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/hovers");
    }

    @When("I hover on user {int}")
    public void hoverOnUser(int index) {
        // Feature uses 1-based index, code uses 0-based
        hoversPage.hoverUserByIndex(index - 1);
    }

    @Then("the details {string} are displayed")
    public void checkUserDetails(String expectedText) {
        String actualText = hoversPage.getVisibleUserCaption();

        Assert.assertTrue(actualText.contains(expectedText),
                "Expected hover text not displayed");
    }
}
