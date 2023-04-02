package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static helpers.Attach.getSessionId;

public class TestBase {

    public static String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    static void beforeAll() {

        if (deviceHost.equals("appium")) {
            Configuration.browser = LocalMobileDriver.class.getName();
        } else if (deviceHost.equals("browserstack")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        }

        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 15000;
        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();
        Attach.pageSource();
        closeWebDriver();

        if (deviceHost.equals("browserstack")) {
            Attach.addVideo(sessionId);
        }
    }
}


