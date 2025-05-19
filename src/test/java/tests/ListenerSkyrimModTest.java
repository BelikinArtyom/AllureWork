package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class ListenerSkyrimModTest extends TestBase {

    public static final String repo = "HydrogensaysHDT/hdt-skyrimse-mods";
    public static final String IssueName = "Skinned Mesh Physics (SMP) source code for Skyrim LE";

    @Test
    void testSkyrimMod() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").pressEnter();
        $(linkText(repo)).click();
        $("#issues-tab").click();
        $(withText(IssueName)).should(exist);
    }
}
