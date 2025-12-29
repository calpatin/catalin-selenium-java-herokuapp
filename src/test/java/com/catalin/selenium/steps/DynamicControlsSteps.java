package com.catalin.selenium.steps;

import com.catalin.selenium.framework.driver.DriverManager;
import com.catalin.selenium.framework.pages.DynamicControlsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DynamicControlsSteps {

    private DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

    @Given("I open the Dynamic Controls Page")
    public void openDynamicControls() {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    @When("I select and remove the checkbox")
    public void removeCheckbox() {
        dynamicControlsPage.clickRemoveAddButton();
    }

    @Then("The checkbox is no longer displayed on page")
    public void checkboxIsGone() {
        Assert.assertTrue(dynamicControlsPage.isCheckboxGone());
    }

    @Then("A confirmation message is shown")
    public void confirmMessage() {
        Assert.assertEquals(dynamicControlsPage.getMessageText(), "It's gone!");
    }
}
