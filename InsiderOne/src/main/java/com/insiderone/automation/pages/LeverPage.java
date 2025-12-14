package com.insiderone.automation.pages;

import com.insiderone.automation.constants.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class LeverPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private boolean isLeverTabActive = false;


    public LeverPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Verify that Lever page is opened
    public boolean verifyLeverPageOpened() {
        try {
            switchToNewTabIfExists();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    Locators.LEVER_HEADER
            ));

            return driver.getCurrentUrl().contains("lever.co");
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getJobDetails() {
        try {
            switchToNewTabIfExists();

            String title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    Locators.LEVER_JOB_TITLE
            )).getText();

            String location = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    Locators.LEVER_JOB_LOCATION
            )).getText();

            return "Job Details\n"
                    + "Title    : " + title + "\n"
                    + "Location : " + location;

        } catch (TimeoutException e) {
            return "Job details could not be retrieved";
        }
    }

    // Verify job location is Istanbul, Turkiye
    public boolean verifyJobLocation() {
        try {
            switchToNewTabIfExists();

            String location = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    Locators.LEVER_JOB_LOCATION
            )).getText();

            System.out.println("Job Location : " + location);

            return location.equalsIgnoreCase("Istanbul, Turkiye");
        } catch (TimeoutException e) {
            return false;
        }
    }
    // Switch to new browser tab if opened
    private void switchToNewTabIfExists() {
        if (isLeverTabActive) {
            return;
        }

        String currentWindow = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                isLeverTabActive = true;
                break;
            }
        }
    }
    public void printJobDetails() {
        try {
            switchToNewTabIfExists();

            String title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    Locators.LEVER_JOB_TITLE
            )).getText();

            String location = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    Locators.LEVER_JOB_LOCATION
            )).getText();

            System.out.println("\n===== LEVER JOB DETAILS =====");
            System.out.printf("%-15s : %s%n", "Title", title);
            System.out.printf("%-15s : %s%n", "Location", location);
            System.out.println("============================\n");

        } catch (TimeoutException e) {
            System.out.println("Job details could not be retrieved");
        }
    }
}
