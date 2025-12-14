package com.insiderone.automation.constants;

import org.openqa.selenium.By;

public class Locators {

    public static final By MAIN_BANNER = By.cssSelector("div.header-banner");
    public static final By HEADER =  By.cssSelector("#navigation");
    public static final By FOOTER = By.cssSelector("#footer");
    public static final By ACCEPT_COOKIES = By.cssSelector(".wt-cli-accept-all-btn");


    public static final By SEE_ALL_QA_JOBS = By.xpath("//a[contains(text(),'See all QA jobs')]");
    public static final By LOCATION_DROPDOWN = By.cssSelector("#filter-by-location");
    public static final By LOCATION_ISTANBUL=By.xpath("//select[@id='filter-by-location']/option[contains(text(),'Istanbul, Turkiye')]");
    public static final By DEPARTMENT_DROPDOWN = By.cssSelector("#filter-by-department");
    public static final By QA_DEPARTMENT_OPTION = By.xpath("//select[@id='filter-by-department']/option[text()='Quality Assurance']");

    public static final By JOB_LIST_ITEMS = By.cssSelector("div.position-list-item");
    public static final By VIEW_ROLE_BUTTON = By.cssSelector("#jobs-list > div > div > a");

    public static final By LEVER_HEADER = By.cssSelector("div.posting-headline, h2.posting-title");
    public static final By LEVER_JOB_TITLE = By.cssSelector(".posting-headline > h2");
    public static final By LEVER_JOB_LOCATION = By.cssSelector("div.location");

}
