package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.util.Map;

public class TestBase  {

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.headless = false;
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browser.version", "128.0");
        Configuration.browserSize = System.getProperty("browser.size", "2560x1440");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        Configuration.holdBrowserOpen = false;

        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}