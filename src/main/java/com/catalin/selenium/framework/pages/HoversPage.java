package com.catalin.selenium.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HoversPage extends BasePage {

    @FindBy(css = ".figure")
    private List<WebElement> figures;

    public void hoverUserByIndex(int index) {
        actions().moveToElement(figures.get(index))
                .perform();
    }

    //    All the captions are present in the DOM, but only one is visible
    public String getVisibleUserCaption() {
        By visibleCaption = By.cssSelector(".figcaption h5");

        WebElement caption = wait
                .until(driver ->
                        driver.findElements(visibleCaption)
                                .stream()
                                .filter(WebElement::isDisplayed)
                                .findFirst()
                                .orElse(null)
                );
        return caption.getText();
    }
}
