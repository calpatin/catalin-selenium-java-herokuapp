package com.catalin.selenium.steps;

import com.catalin.selenium.framework.driver.DriverManager;
import com.catalin.selenium.framework.pages.WindowsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class WindowsSteps {

    private final WindowsPage windowsPage = new WindowsPage();
    private String originalWindow;

    @Given("I open the Windows Page")
    public void openWindowsPage() {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/windows");
        originalWindow = windowsPage.captureCurrentWindow();
    }

    @When("I open a new window")
    public void openNewWindow() {
        windowsPage.openNewWindow();
        windowsPage.switchToNewlyOpenedWindow(originalWindow);
    }

    @Then("The new window content is displayed")
    public void confirmNewWindow() {
        Assert.assertEquals(
                windowsPage.getHeaderTxt(),
                "New Window"
        );
    }

    @Then("I return to the original window")
    public void returnToOriginalWindow() {
        windowsPage.switchToOriginalWindow(originalWindow);
        Assert.assertEquals(
                windowsPage.getHeaderTxt(),
                "Opening a new window"
        );
    }
}
