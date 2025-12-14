package com.insiderone.automation.pages;

import com.insiderone.automation.constants.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class QAJobsPage extends BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public QAJobsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Apply location and department filters
    public void filterJobs() {

        acceptCookiesIfPresent();

        List<WebElement> oldJobs = driver.findElements(Locators.JOB_LIST_ITEMS);

        WebElement location = wait.until(
                ExpectedConditions.elementToBeClickable(Locators.LOCATION_DROPDOWN)
        );
        location.click();

        WebElement istanbul = wait.until(
                ExpectedConditions.elementToBeClickable(Locators.LOCATION_ISTANBUL)
        );
        istanbul.click();

        WebElement department = wait.until(
                ExpectedConditions.elementToBeClickable(Locators.DEPARTMENT_DROPDOWN)
        );
        department.click();

        WebElement qa = wait.until(
                ExpectedConditions.elementToBeClickable(Locators.QA_DEPARTMENT_OPTION)
        );
        qa.click();

        if (!oldJobs.isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(oldJobs.get(0)));
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                Locators.JOB_LIST_ITEMS
        ));
    }


    // Verify job list is loaded
    public boolean verifyJobListLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    Locators.JOB_LIST_ITEMS
            ));
            return driver.findElements(Locators.JOB_LIST_ITEMS).size() > 0;
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Verify job titles contain QA or Quality
    public boolean verifyJobInformation() {
        List<WebElement> jobs = driver.findElements(Locators.JOB_LIST_ITEMS);

        for (WebElement job : jobs) {
            String text = job.getText();
            if (!(text.contains("QA") || text.contains("Quality"))) {
                return false;
            }
            if (!text.contains("Istanbul, Turkiye")) {
                return false;
            }
            if (!text.contains("Quality Assurance")) { // department kontrolü
                return false;
            }
        }
        return true;
    }

    // Click the first View Role button
    public void clickFirstViewRole() {

        wait.until(driver ->
                "complete".equals(
                        String.valueOf(
                                ((JavascriptExecutor) driver)
                                        .executeScript("return document.readyState")
                        )
                )
        );

        WebElement role = wait.until(
                ExpectedConditions.elementToBeClickable(Locators.VIEW_ROLE_BUTTON)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", role);

        role.click();
    }
    public void printFilteredJobList() {
        List<WebElement> jobs = driver.findElements(Locators.JOB_LIST_ITEMS);

        System.out.println("\n===== FILTERED QA JOBS =====");
        int index = 1;
        for (WebElement job : jobs) {
            String text = job.getText();
            System.out.println(index + ". " + text.replaceAll("\\r?\\n", " | "));
            index++;
        }
        System.out.println("============================\n");
    }
}
