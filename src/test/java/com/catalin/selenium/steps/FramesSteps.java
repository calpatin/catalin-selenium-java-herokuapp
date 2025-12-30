package com.catalin.selenium.steps;

import com.catalin.selenium.framework.driver.DriverManager;
import com.catalin.selenium.framework.pages.FramesPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FramesSteps {

    private final FramesPage framesPage = new FramesPage();

    @Given("I open the Frames Page")
    public void openFramesPage() {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/frames");
    }

    @When("I navigate to Nested Frames")
    public void openNestedFrames() {
        framesPage.openNestedFrame();
    }

    @When("I navigate to iFrame Page")
    public void openIFrame() {
        framesPage.openIFrame();
    }

    @When("I type {string} in the editor")
    public void typTextInTheEditor(String text) {
        framesPage.typeInEditor(text);
    }

    @Then("I can read the text from the middle frame")
    public void readMiddleFrameText() {
        Assert.assertEquals(framesPage.getTextFromMiddleFrame(), "MIDDLE");
    }

    @Then("The editor contains {string}")
    public void confirmEditorText (String expectedText){
        Assert.assertEquals(framesPage.getEditorText(), expectedText);

    }


}
