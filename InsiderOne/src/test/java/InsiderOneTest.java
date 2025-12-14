package com.insiderone.automation;

import com.insiderone.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(singleThreaded = true)
public class InsiderOneTest extends com.insiderone.automation.BaseTest {

    HomePage home;
    CareersPage careers;
    QAJobsPage qa;
    LeverPage lever;

    @BeforeClass
    public void initPages() {
        home = new HomePage(driver);
        careers = new CareersPage(driver);
        qa = new QAJobsPage(driver);
        lever = new LeverPage(driver);
    }

    @Test(priority = 0, description = "Verify home page")
    public void openHomePage() {
        home.open();
        Assert.assertTrue(home.isHomePageOpened(), "Home page is not opened");
    }

    @Test(priority = 1, description = "Open QA careers page and click See All QA Jobs")
    public void navigateToQACareers() {
        careers.open();
        careers.clickSeeAllQAJobs();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("qualityassurance"),
                "Failed to navigate to QA Careers page"
        );
    }

    @Test(priority = 2, description = "Filter QA jobs and verify job list")
    public void verifyQAJobList() {
        qa.filterJobs();

        Assert.assertTrue(
                qa.verifyJobListLoaded(),
                "Job list not loaded after filtering"
        );

        Assert.assertTrue(
                qa.verifyJobInformation(),
                "Job information does not match criteria"
        );
        qa.printFilteredJobList();
    }

    @Test(priority = 3, description = "Click View Role and verify Lever redirection")
    public void verifyLeverRedirect() {
        qa.clickFirstViewRole();

        Assert.assertTrue(
                lever.verifyLeverPageOpened(),
                "Lever application page was not opened"
        );
        Assert.assertTrue(
                lever.verifyJobLocation(),
                "Job location is not Istanbul, Turkiye"
        );
        lever.printJobDetails();
    }
}
