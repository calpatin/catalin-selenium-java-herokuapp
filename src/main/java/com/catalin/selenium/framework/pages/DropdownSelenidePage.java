package com.catalin.selenium.framework.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DropdownSelenidePage {

    private final SelenideElement dropdown = $("#dropdown");

    public void openDropdownPage() {
        Selenide.open("https://the-internet.herokuapp.com/dropdown");
    }

    public void selectOption(String option) {
        dropdown.selectOption(option);
    }

    public void shouldHaveSelectedOption(String option) {
        dropdown.shouldHave(text(option));
    }
}
