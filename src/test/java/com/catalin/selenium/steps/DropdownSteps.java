package com.catalin.selenium.steps;

import com.catalin.selenium.framework.driver.DriverManager;
import com.catalin.selenium.framework.pages.DropdownPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class DropdownSteps {

    private final DropdownPage dropdownPage = new DropdownPage();

    @Given("I open the Dropdown Page")
    public void openDropdownPage() {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/dropdown");
    }

    @When("I select the following option for dropdown:")
    public void selectMultipleOptions(DataTable dataTable) {
        List<String> options = dataTable.asList();

        for (String option : options) {
            dropdownPage.selectByVisibleText(option);
            Assert.assertEquals(dropdownPage.getSelectedOptions(),
                    option,
                    "Dropdown selection failed for option: " + option);
        }
    }

    @Then("The selected option should be correctly selected")
    public void confirmSelections() {
// Semantical step for readiness. The assertions are already done under the @When step.
    }
}
