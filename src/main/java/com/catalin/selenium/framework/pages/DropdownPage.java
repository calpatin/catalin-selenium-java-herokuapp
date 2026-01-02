package com.catalin.selenium.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropdownPage extends BasePage{

    @FindBy(id = "dropdown")
    private WebElement dropdown;

    public void selectByVisibleText(String text) {
        select(dropdown).selectByVisibleText(text);
    }

    public void selectByValue(String value) {
        select(dropdown).selectByValue(value);
    }

    public void selectByIndex (int index) {
        select(dropdown).selectByIndex(index);
    }

    public String getSelectedOptions() {
        return select(dropdown)
                .getFirstSelectedOption()
                .getText();
    }
}
