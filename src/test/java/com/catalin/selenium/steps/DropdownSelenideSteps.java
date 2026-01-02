package com.catalin.selenium.steps;

import com.catalin.selenium.framework.pages.DropdownSelenidePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class DropdownSelenideSteps {

    private final DropdownSelenidePage dropdownSelenidePage = new DropdownSelenidePage();

    @Given("I open the Dropdown Page using Selenide")
    public void openDropdownPageUsingSelenide() {
        dropdownSelenidePage.openDropdownPage();
    }

    @When("I select the following options using Selenide:")
    public void selectOptionsUsingSelenide(DataTable dataTable) {
        List<String> options = dataTable.asMaps(String.class, String.class)
                .stream()
                .map(row -> row.get("option"))
                .toList();

        for (String option : options) {
            dropdownSelenidePage.selectOption(option);
            dropdownSelenidePage.shouldHaveSelectedOption(option);
        }
    }

    @Then("The dropdown should display the following selected option using Selenide:")
    public void confirmSelectedOptionUsingSelenide(DataTable dataTable) {
   // Semantical step for readiness. The assertions are already done under the @When step.

    }
}
