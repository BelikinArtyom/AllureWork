package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import javax.crypto.spec.PSource;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AllureTask extends TestBase {


        public static final String REPOSITORY = "eroshenkoam/allure-example";
        public static final int ISSUE = 80;

        @Test
        public void someSearchTestLyambda() {
            SelenideLogger.addListener("allure", new AllureSelenide());

            step("открываем главную страницу", () -> {
                open("https://github.com/");
            });

            step("ищем репозиторий " + REPOSITORY, () ->{
                $(".search-input").click();
                $("#query-builder-test").sendKeys(REPOSITORY);
                $("#query-builder-test").pressEnter();
            });

            step("Кликаем по ссылке репо" + REPOSITORY, () -> {
                $(linkText(REPOSITORY)).click();
            });

            step("Открываем таб issues", () -> {
                $("#issues-tab").click();
            });

            step("Проверяем видимость элемента c номером " + ISSUE, () -> {
                $(withText("#" + ISSUE)).should(exist);
            });
    }

    @Test
    public void annotatedTest(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps webSteps = new WebSteps();
        webSteps.openMainPage();
        webSteps.searchForRepository(REPOSITORY);
        webSteps.repositoryLinkClick(REPOSITORY);
        webSteps.issuesTabOpen();
        webSteps.issuesWithNumberShouldBeVisible(ISSUE);

    }

    @Test
    public void someSearchTestLyambdaAttatchments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("открываем главную страницу", () -> {
            open("https://github.com/");
            attachment("Source", webdriver().driver().source());
        });

    }
    @Test
    public void annotatedTestAttatchments() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps webSteps = new WebSteps();

        webSteps.openMainPage();
        webSteps.takeScreenshot();

    }
}
