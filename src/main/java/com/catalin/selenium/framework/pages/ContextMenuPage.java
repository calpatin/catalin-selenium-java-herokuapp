package com.catalin.selenium.framework.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage{

    @FindBy(id = "hot-spot")
    private WebElement hotspot;

    public void rightClickHotSpot(){
        actions().contextClick(hotspot)
                .perform();
    }

    public String getAlertTextAndAccept() {
        Alert alert = waitForAlert();
        String text = alert.getText();
        alert.accept();
        return text;
    }
}
