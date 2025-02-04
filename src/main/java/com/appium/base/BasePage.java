package com.appium.base;

import org.openqa.selenium.By;


public class BasePage extends DriverSetup{

    Waits waits = new Waits();
    private final String baseUrl = System.getProperty("BASE_URL", "https://picsart.com/");
    By acceptAllCookiesButtonBy = By.id("onetrust-accept-btn-handler");

    /**
     * Open Application
     * @param url
     *        path of application
     */
    public void openApplication(String url) {
        getDriver().get(baseUrl+url);
    }

    /**
     * Click on accept all cookies button
     */
    public void clickOnAcceptAllCookies() {
        waits.waitForElementVisible(acceptAllCookiesButtonBy);
        getDriver().findElement(acceptAllCookiesButtonBy).click();
    }

    /**
     * Switch to iframe by locator
     * @param locatorBy
     *          iframe locator by
     */
    public void switchToIframe(By locatorBy) {
        waits.waitForElementVisible(locatorBy);
        getDriver().switchTo().frame(getDriver().findElement(locatorBy));
    }

    /**
     * Switch to Default page from iframe
     */
    public void switchToDefaultPage() {
        getDriver().switchTo().defaultContent();
    }

}
