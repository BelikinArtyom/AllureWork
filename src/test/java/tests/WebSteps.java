package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static tests.AllureTask.ISSUE;
import static tests.AllureTask.REPOSITORY;

public class WebSteps {

    @Step("открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".search-input").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").pressEnter();
    }

    @Step("Кликаем по ссылке репо {repo}")
    public void repositoryLinkClick(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем таб issues")
    public void issuesTabOpen() {
        $("#issues-tab").click();
    }

    @Step("Проверяем видимость элемента c номером  {issue}")
    public void issuesWithNumberShouldBeVisible(int issue) {
        $(withText("#" + ISSUE)).should(exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
