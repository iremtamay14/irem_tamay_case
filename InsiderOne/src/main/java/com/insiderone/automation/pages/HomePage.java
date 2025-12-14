package com.insiderone.automation.pages;

import com.insiderone.automation.constants.Locators;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void open() {
        driver.get("https://insiderone.com/");
    }

    // Verify that home page is loaded
    public boolean isHomePageOpened() {
        return driver.findElement(Locators.HEADER).isDisplayed()
                && driver.findElement(Locators.MAIN_BANNER).isDisplayed()
                && driver.findElement(Locators.FOOTER).isDisplayed();
    }
    public void printHomePageSections() {
        System.out.println("Header: " + driver.findElement(Locators.HEADER).getText());
        System.out.println("Header: " + driver.findElement(Locators.MAIN_BANNER).getText());
        System.out.println("Header: " + driver.findElement(Locators.FOOTER).getText());
    }

}
