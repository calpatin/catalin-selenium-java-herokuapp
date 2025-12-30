package com.catalin.selenium.steps;

import com.catalin.selenium.framework.driver.DriverManager;
import com.catalin.selenium.framework.pages.DragAndDropPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DragAndDropSteps {

    private final DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Given("I open the Drag and Drop Page")
    public void opnDragAndDropPage() {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @When("I drag column A onto column B")
    public void dragAToB() {
        dragAndDropPage.dragAndDropAtoB();
    }

    @Then("column A should be in position B")
    public void checkDragAndDrop() {
        Assert.assertEquals(dragAndDropPage.getColumnAText(), "B", "Drag and drop did not work as expected");
    }
}
