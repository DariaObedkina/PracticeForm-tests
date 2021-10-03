package com.dobedkina.tests;

import com.codeborne.selenide.Configuration;
import com.dobedkina.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterEach
    void tearDown() {
        Attach.browserConsoleLogs();
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
    }
}
