package com.catalin.selenium.steps;

import com.catalin.selenium.framework.driver.DriverManager;
import com.catalin.selenium.framework.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class HomeSteps {
    private final HomePage homePage = new HomePage();

    @Given("I open the  Herokuapp homepage")
    public void iOpenTheHomePage() {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/");
    }

    @Then("The Homepage is displayed")
    public void theHomepageIsDisplayed() {
        String headerText = homePage.getHeaderText();

        String HEADER_TEXT = "Welcome to the-internet";
        Assert.assertEquals(headerText, HEADER_TEXT, "Homepage header text is incorrect");
    }
}
