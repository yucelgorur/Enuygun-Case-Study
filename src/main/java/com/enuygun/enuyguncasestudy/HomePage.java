package com.enuygun.enuyguncasestudy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement alertAcceptButton;
    @FindBy(xpath  ="//div[@data-testid='endesign-[unnamed]-tab-panel-0']")
    public List<WebElement> searchModuleinHomePage;
    @FindBy(xpath  ="//button[@data-testid='enuygun-homepage-flight-submitButton']")
    public List<WebElement> submitButtoninHomePage;
    public void alertAccept() {
        alertAcceptButton.click();
        System.out.println("Alert accept");
    }
    public void isElementPresent(List<WebElement> elements) {
        if (!elements.isEmpty()) {
            for (WebElement element : elements) {
                System.out.println("Element: " + element.getText());
            }
            System.out.println("Webelement is on the home page");
        } else {
            System.out.println("Webelement isn't on the home page!");
        }
    }
}
