package com.catalin.selenium.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage {

    @FindBy(linkText = "Nested Frames")
    private WebElement nestedFrames;

    @FindBy(linkText = "iFrame")
    private WebElement iFrame;

    @FindBy(name = "frame-top")
    private WebElement frameTop;

    @FindBy(name = "frame-middle")
    private WebElement frameMiddle;

    @FindBy(id = "content")
    private WebElement middleFrameText;

    @FindBy(id = "mce_0_ifr")
    private WebElement editorFrame;

    @FindBy(id = "tinymce")
    private WebElement editorBody;

    public void openNestedFrame() {
        click(nestedFrames);
    }

    public void openIFrame() {
        click(iFrame);
    }

    public String getTextFromMiddleFrame() {
        switchToFrame(frameTop);
        switchToFrame(frameMiddle);
        String text = getText(middleFrameText);
        switchToDefaultContent();
        return text;
    }

    public void typeInEditor(String text) {
        switchToFrame(editorFrame);
        editorBody.sendKeys(text);
        switchToDefaultContent();
    }

    public String getEditorText() {
        switchToFrame(editorFrame);
        String text = editorBody.getText();
        switchToDefaultContent();
        return text;
    }


}
