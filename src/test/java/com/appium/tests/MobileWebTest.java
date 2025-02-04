package com.appium.tests;

import com.appium.base.BasePage;
import com.appium.base.DriverSetup;
import com.appium.base.SearchPage;
import com.appium.base.Waits;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;

public class MobileWebTest extends DriverSetup {

    Waits waits = new Waits();
    BasePage basePage = new BasePage();
    SearchPage searchPage = new SearchPage();

    By frameElementBy = By.cssSelector("[data-testid='com.picsart.social.search']");

    @Test
    @Description("Open Picsart Search and check filter")
    public void PicsartTest() throws InterruptedException {
        basePage.openApplication("search/all/");
        Thread.sleep(20000);

        Allure.step("Click on Accept all cookies");
        basePage.clickOnAcceptAllCookies();

        Allure.step("Switch to Iframe");
        basePage.switchToIframe(frameElementBy);

        Allure.step("Click on Open Filter button");
        searchPage.clickOnFilterButton();

        //Personal filter does not appear for mobile view
        Allure.step("Click on close Filter button");
        searchPage.clickOnFilterButton();

    }
}