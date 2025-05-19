package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static tests.ListenerSkyrimModTest.IssueName;
import static tests.ListenerSkyrimModTest.repo;

public class AnnotationsSkyrimModTest extends TestBase {

    @Test
    public void skyrimModTestAnnotations() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        SkyrimTestSteps SkyrimTestSteps = new SkyrimTestSteps();
        SkyrimTestSteps.openMainPage();
        SkyrimTestSteps.searchForRepository(repo);
        SkyrimTestSteps.repositoryLinkClick(repo);
        SkyrimTestSteps.issuesTabOpen();
        SkyrimTestSteps.issuesWithTextShouldBeVisible(IssueName);
    }
}
