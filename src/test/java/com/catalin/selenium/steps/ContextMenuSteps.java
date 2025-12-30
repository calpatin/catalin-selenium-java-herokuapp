package com.catalin.selenium.steps;

import com.catalin.selenium.framework.driver.DriverManager;
import com.catalin.selenium.framework.pages.ContextMenuPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ContextMenuSteps {

    private final ContextMenuPage contextMenuPage = new ContextMenuPage();

    @Given("I open the Context Menu Page")
    public void openContextMenuPage() {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/context_menu");
    }

    @When("I right click on the context menu area")
    public void rightClickContextMenuArea() {
        contextMenuPage.rightClickHotSpot();
    }

    @Then("An Alert with the text {string} is displayed")
    public void confirmAlertText(String expectedText) {
        String actualText = contextMenuPage.getAlertTextAndAccept();

        Assert.assertEquals(actualText, expectedText, "Unexpected alert text");
    }
}
