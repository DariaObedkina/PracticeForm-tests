package com.dobedkina.tests;

import com.codeborne.selenide.Configuration;
import com.dobedkina.config.CredentialsConfig;
import com.dobedkina.helpers.Attach;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.browserVersion;


public class TestBase {
    @BeforeAll
    public static void setUp() {
        CredentialsConfig credentials =
                ConfigFactory.create(CredentialsConfig.class);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        Configuration.remote = String.format("https://%s:%s@", credentials.login(), credentials.password()) + System.getProperty("remoteBrowserUrl");
        browser = System.getProperty("browser", "chrome");
        browserVersion = System.getProperty("browserVersion", "91.0");

    }

    @AfterEach
    void tearDown() {
        Attach.browserConsoleLogs();
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.addVideo();
    }
}
