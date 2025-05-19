package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Фича репозитория")
    @Story("Создание Issue")
    @Owner("belikinA")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "github", url= "https://github.com/")
    @DisplayName("Создание issue для авторизованного пользователя")
    public void StaticTest(){


    }

    @Test
    public void DynamicTest(){
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание issue для авторизованного пользователя")

        );
        Allure.feature("Фича репозитория");
        Allure.story("Создание Issue");
        Allure.label("owner","belikinA");
        Allure.label("severity", "blocker");
        Allure.link("gitHub", "https://github.com/");
    }

}
