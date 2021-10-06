package com.dobedkina.tests;

import com.codeborne.selenide.Configuration;
import com.dobedkina.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestBase {
    @BeforeAll
    static void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        //capabilities.setCapability("browserName","firefox");
        //capabilities.setCapability("browserVersion","88.0");

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
        //browser = System.getProperty("browser","opera");

    }

    @AfterEach
    void tearDown() {
        Attach.browserConsoleLogs();
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.addVideo();
    }
}
