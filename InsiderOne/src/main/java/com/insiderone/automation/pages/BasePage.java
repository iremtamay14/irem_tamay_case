package com.insiderone.automation.pages;

import com.insiderone.automation.constants.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void acceptCookiesIfPresent() {
        try {
            WebElement acceptBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(Locators.ACCEPT_COOKIES)
            );
            acceptBtn.click();
            wait.until(ExpectedConditions.invisibilityOf(acceptBtn));
        } catch (Exception ignored) {
            // Cookie not present
        }
    }
}
