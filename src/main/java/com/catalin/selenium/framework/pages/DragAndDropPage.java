package com.catalin.selenium.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class DragAndDropPage extends BasePage {

    @FindBy(id = "column-a")
    private WebElement columnA;

    @FindBy(id = "column-b")
    private WebElement columnB;

    public void dragAndDropAtoB() {
        actions().dragAndDrop(columnA, columnB);
    }

    public void dragAtoBWithActions() {
        actions().clickAndHold(columnA)
                .moveToElement(columnB)
                .pause(Duration.ofMillis(500))
                .release()
                .build()
                .perform();
    }

    public String getColumnAText() {
        return columnA.getText();
    }

    public String getColumnBText() {
        return columnB.getText();
    }


}
