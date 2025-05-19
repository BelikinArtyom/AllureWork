package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LyambdaSkyrimModTest extends TestBase {

    public static final String repo = "HydrogensaysHDT/hdt-skyrimse-mods";
    public static final String IssueName = "Skinned Mesh Physics (SMP) source code for Skyrim LE";

    @Test
    void testSkyrimLyambdaStep() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открытие главной страницы GitHub", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий " + repo, () ->{
            $(".search-input").click();
            $("#query-builder-test").sendKeys(repo);
            $("#query-builder-test").pressEnter();
        });

        step("Кликаем по ссылке репозитория" + repo, () -> {
            $(linkText(repo)).click();
        });

        step("Открываем таб issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем видимость элемента c номером " + IssueName, () -> {
            $(withText(IssueName)).should(exist);
        });
    }
}
