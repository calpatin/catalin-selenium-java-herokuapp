package com.catalin.selenium.steps;

import com.catalin.selenium.framework.driver.DriverManager;
import com.catalin.selenium.framework.pages.HomePage;
import com.catalin.selenium.hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class HomeSteps {
    private final HomePage homePage = new HomePage();

    @Given("I open the  Herokuapp homepage")
    public void iOpenTheHomePage() {
        DriverManager.getDriver().get(Hooks.getConfigReader().get("base.url"));
    }

    @Then("The Homepage is displayed")
    public void theHomepageIsDisplayed() {
        String headerText = homePage.getHeaderText();

        String HEADER_TEXT = "Welcome to the-internet";
        Assert.assertEquals(headerText, HEADER_TEXT, "Homepage header text is incorrect");
    }

    @Then("The Fork me on GitHub banner is displayed")
    public void forkMeOnGitHubBannerIsDisplayed() {
        Assert.assertTrue(homePage.isForkMeOnGitHubDisplayed(),
                "Fork me on GitHub banner is not displayed");
    }
}
