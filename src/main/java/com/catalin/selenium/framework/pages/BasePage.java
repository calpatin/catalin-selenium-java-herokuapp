package com.catalin.selenium.framework.pages;

import com.catalin.selenium.framework.config.ConfigManager;
import com.catalin.selenium.framework.driver.DriverManager;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage() {
        this.driver = DriverManager.getDriver();
        int timeout = ConfigManager.getConfig().getInt("explicit.wait");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        PageFactory.initElements(driver, this);
    }

    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForClickability(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForStaleness(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    protected void waitForPresence(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    protected String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    //    generic fluent wait
    protected <T> T fluentWait(Function<WebDriver, T> condition) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        return fluentWait.until(condition);
    }

    protected Alert waitForAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    protected void switchToFrame(WebElement frame) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    protected Actions actions() {
        return new Actions(driver);
    }

    protected Select select(WebElement element) {
        return new Select(element);
    }

    protected String getCurrentWindow() {
        return driver.getWindowHandle();
    }

    protected void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    protected void switchToNewWindow(String originalWindow) {
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            if(!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                return;
            }
        }
    }

}
