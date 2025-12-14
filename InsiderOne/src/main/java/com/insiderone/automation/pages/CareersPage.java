package com.insiderone.automation.pages;

import com.insiderone.automation.constants.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CareersPage extends BasePage {

    private WebDriver driver;

    public CareersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void open() {
        driver.get("https://insiderone.com/careers/quality-assurance/");
    }


    public void clickSeeAllQAJobs() {
        acceptCookiesIfPresent();
        driver.findElement(Locators.SEE_ALL_QA_JOBS).click();
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        Locators.JOB_LIST_ITEMS
                ));
    }
}
