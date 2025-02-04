package com.appium.base;

import org.openqa.selenium.By;

public class SearchPage  extends DriverSetup{

    Waits waits = new Waits();
    By filterIconBtnBy = By.id("filter_icon");

    /**
     * Click on Filter button
     */
    public void clickOnFilterButton(){
        waits.waitToElementIsClickable(getDriver().findElement(filterIconBtnBy));
        getDriver().findElement(filterIconBtnBy).click();
    }

}
