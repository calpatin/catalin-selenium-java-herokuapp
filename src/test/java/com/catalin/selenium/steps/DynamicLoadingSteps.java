package com.catalin.selenium.steps;

import com.catalin.selenium.framework.driver.DriverManager;
import com.catalin.selenium.framework.pages.DynamicLoadingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DynamicLoadingSteps {

    private final DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();


    @Given("I open the Example1 Page")
    public void openTheExample1Page() {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading");
        dynamicLoadingPage.clickOnExample1();
    }

    @Given("I open the Example2 Page")
    public void openTheExample2Page() {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading");
        dynamicLoadingPage.clickOnExample2();
    }

    @Given("I open the {string} Page")
    public void openTheExamplePage(String example) {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading");

        switch (example.toLowerCase()) {
            case "example1" -> dynamicLoadingPage.clickOnExample1();
            case "example2" -> dynamicLoadingPage.clickOnExample2();
            default -> throw new IllegalArgumentException("Unknown dynamic loading example page: " + example);

        }
    }

    @When("I start the dynamic loading")
    public void startDynamicLoading() {
        dynamicLoadingPage.clickOnStartButton();
    }

    @Then("The dynamic loaded text is displayed")
    public void confirmLoadedText() {
        Assert.assertEquals(dynamicLoadingPage.getFinishTextWhenVisible(), "Hello World!");
    }
}
