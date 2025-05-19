package tests;

import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static tests.ListenerSkyrimModTest.IssueName;

public class SkyrimTestSteps {

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

    @Step("Проверяем видимость элемента c текстом {issue}")
    public void issuesWithTextShouldBeVisible(String issue) {
        $(withText(IssueName)).should(exist);
    }

}
