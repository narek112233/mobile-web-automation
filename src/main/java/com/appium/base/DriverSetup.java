package com.appium.base;

import com.appium.utils.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Listeners({AllureTestNg.class})
public class DriverSetup {
    private static AppiumDriver driver;
    Properties properties = ConfigReader.loadConfig();


    @BeforeClass
    public void setup() throws Exception {
        String platform = properties.getProperty("platform");
        DesiredCapabilities caps = new DesiredCapabilities();

        if (platform.equalsIgnoreCase("local")) {
            String platformName = properties.getProperty("platformName");
            caps.setCapability("platformName", platformName);
            caps.setCapability("browserName", properties.getProperty("browserName"));

            driver = platformName.equalsIgnoreCase("Android") ?
                    new AndroidDriver(new URL(properties.getProperty("appiumServer")), caps) :
                    new IOSDriver(new URL(properties.getProperty("appiumServer")), caps);
        } else {
            caps.setCapability("platformName", "Android");
            caps.setCapability("browserName", "Chrome");

            Map<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("userName", properties.getProperty("browserstack.username"));
            browserstackOptions.put("accessKey", properties.getProperty("browserstack.accesskey"));
            browserstackOptions.put("deviceName", properties.getProperty("device"));
            browserstackOptions.put("osVersion", properties.getProperty("os_version"));
            browserstackOptions.put("realMobile", properties.getProperty("real_mobile"));

            caps.setCapability("bstack:options", browserstackOptions);

            driver = new AndroidDriver(new URL(properties.getProperty("appiumServer")), caps);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static AppiumDriver getDriver(){
        return driver;
    }
}